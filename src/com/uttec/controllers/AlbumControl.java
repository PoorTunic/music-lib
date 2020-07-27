package com.uttec.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.database.DBConnection;
import com.uttec.entities.Album;

public class AlbumControl implements AlbumSearcher<Album> {

	public static boolean save(Album album) {
		try {
			String sql = "INSERT INTO album VALUES (DEFAULT, ?, ?, ?, ?, ?)";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setInt(1, album.getBand().getID());
			statement.setString(2, album.getName());
			statement.setDate(3, new java.sql.Date(album.getDeparture().getTime()));
			statement.setString(4, "A COMMENT");
			statement.setInt(5, 1);
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				return false;
			}
			try (ResultSet id = statement.getGeneratedKeys()) {
				if (id.next()) {
					album.setID(id.getInt(1));
				} else {
					return false;
				}
			}
			return SongControl.save(album.getSongs(), album.getID());
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Album> findByName(String name) {
		List<Album> albums = new ArrayList<Album>();
		try {
			String sql = "SELECT album.ID_album, album.name, album.departure FROM album WHERE album.name  LIKE ?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setString(1, '%' + name + '%');
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Album album = new Album(rs.getInt(1), rs.getString(2), rs.getDate(3), "", null, null);
				albums.add(album);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albums;
	}

}
