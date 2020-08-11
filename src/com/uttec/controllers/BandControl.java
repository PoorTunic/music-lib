package com.uttec.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.database.DBConnection;
import com.uttec.entities.Album;
import com.uttec.entities.Artist;
import com.uttec.entities.Band;

/**
 * Represents Artist Database Actions
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 * @version 1.0
 */
public class BandControl implements AlbumSearcher<Album> {

	/**
	 * Saves a Band
	 * 
	 * @param band to save
	 * @return boolean check if the process is correct
	 */
	public static boolean saveBand(Band band) {
		try {
			String bandQuery = "INSERT INTO band VALUES(DEFAULT, ?)";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(bandQuery,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, band.getName());
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				return false;
			}
			try (ResultSet id = statement.getGeneratedKeys()) {
				if (id.next()) {
					band.setID(id.getInt(1));
				} else {
					return false;
				}
			}
			return ArtistControl.save(band.getArtists(), band.getID());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Creates a solist, Band element in index 0 is the Band information
	 * 
	 * @param artistsToSave contains one element
	 * @return boolean check if the process is correct
	 */
	public static boolean saveSolist(List<Artist> artistsToSave) {
		try {
			Band solist = new Band(artistsToSave.get(0).getName(), artistsToSave);
			return saveBand(solist);
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Represents strategy pattern to find a List of Albums by provided Band Name
	 * 
	 * @return List<Ablum> by provided name
	 * @see List
	 */
	@Override
	public List<Album> findByName(String name) {
		List<Album> albums = new ArrayList<Album>();
		try {
			String sql = "SELECT album.ID_album, album.name, album.departure FROM album INNER JOIN band ON album.ID_band=band.ID_band WHERE band.name LIKE ?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, '%' + name + '%');
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Album album = new Album(rs.getInt(1), rs.getString(2), rs.getDate(3), 0, null, null);
				albums.add(album);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albums;
	}

	/**
	 * Fetches a List of Bands
	 * 
	 * @param qry is a part of the String
	 * @return List<Band>
	 */
	public static List<Band> findByBand(String qry) {
		List<Band> bands = new ArrayList<Band>();
		try {
			String sql = "SELECT band.ID_band, band.name FROM band WHERE band.name LIKE ?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, '%' + qry + '%');
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Band band = new Band(rs.getInt(1), rs.getString(2), null);
				bands.add(band);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bands;
	}

	/**
	 * Fetches a Band entity by provided Band ID
	 * 
	 * @param bandID of the band to fetch
	 * @return Band entity
	 */
	public static Band findByID(int bandID) {
		try {
			String sql = "SELECT ban.name FROM band ban WHERE ban.ID_band=?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setInt(1, bandID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return new Band(bandID, rs.getString(1), null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
