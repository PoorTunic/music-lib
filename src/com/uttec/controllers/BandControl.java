package com.uttec.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.database.DBConnection;
import com.uttec.entities.Album;
import com.uttec.entities.Band;

public class BandControl implements AlbumSearcher<Album> {

	public static boolean saveBand(Band band) {
		try {
			String bandQuery = "SELECT * FROM persistBand(?)";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(bandQuery);
			statement.setString(1, band.getName());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				band.setID(rs.getInt(1));
			}
			String artistQuery = "INSERT INTO artist VALUES(DEFAULT, ?, ? ,?, ? ,?)";
			band.getArtists().forEach(artist -> {
				try {
					PreparedStatement statementArtist = DBConnection.getConnection().prepareStatement(artistQuery);
					statementArtist.setInt(1, band.getID());
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

	@Override
	public List<Album> findByName(String name) {
		List<Album> albums = new ArrayList<Album>();
		try {
			String sql = "SELECT album.ID_album, album.name, album.departure FROM album INNER JOIN band ON album.ID_band=band.ID_band WHERE band.name=?";
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
		return null;
	}
}
