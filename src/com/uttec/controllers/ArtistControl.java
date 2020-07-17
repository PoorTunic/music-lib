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

public class ArtistControl implements AlbumSearcher<Album> {

	public static boolean save(List<Artist> artists) {
		Band newSolist = new Band(artists.get(0).getArtisticName(), artists);
		try {
			BandControl.saveBand(newSolist);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean save(Band newBand) {
		try {
			BandControl.saveBand(newBand);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Album> findByName(String name) {
		List<Album> albums = new ArrayList<Album>();
		try {
			String sql = "SELECT album.ID_album, album.name, album.departure FROM album INNER JOIN band ON album.ID_band=band.ID_band INNER JOIN artist ON band.ID_band=artist.ID_band WHERE artist.name=?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Album album = new Album(rs.getInt(1), rs.getString(2), rs.getDate(3), "", null);
				albums.add(album);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albums;
	}

}
