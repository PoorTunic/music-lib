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
public class ArtistControl implements AlbumSearcher<Album> {

	/**
	 * Saves a List of Artists belonging to a Band
	 * 
	 * @param artists to Save
	 * @param bandID  of artists belonging
	 * @return boolean check if the process is correct
	 */
	public static boolean save(List<Artist> artists, Integer bandID) {
		try {
			artists.forEach(artist -> {
				try {
					String artistQuery = "INSERT INTO artist VALUES(DEFAULT, ?, ? ,?, ? ,?)";
					PreparedStatement statementArtist = DBConnection.getConnection().prepareStatement(artistQuery);
					statementArtist.setInt(1, bandID);
					statementArtist.setString(2, artist.getArtisticName());
					statementArtist.setString(3, artist.getName());
					statementArtist.setDate(4, new java.sql.Date(artist.getBorn().getTime()));
					statementArtist.setString(5, artist.getBio());
					statementArtist.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Saves a Band calling BandControl
	 * 
	 * @param newBand to Save
	 * @return boolean check if the process is correct
	 * @see BandControl#saveBand(Band)
	 */
	public static boolean save(Band newBand) {
		try {
			BandControl.saveBand(newBand);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Represents strategy pattern to find a List of Albums by provided Artist Name
	 * 
	 * @return List of Albums by provided name
	 * @see List
	 */
	@Override
	public List<Album> findByName(String name) {
		List<Album> albums = new ArrayList<Album>();
		try {
			String sql = "SELECT album.ID_album, album.name, album.departure FROM album INNER JOIN band ON album.ID_band=band.ID_band INNER JOIN artist ON band.ID_band=artist.ID_band WHERE artist.name LIKE ?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
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

}
