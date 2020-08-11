package com.uttec.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.database.DBConnection;
import com.uttec.entities.Album;
import com.uttec.entities.Band;
import com.uttec.entities.Song;

/**
 * Represents Album Database Actions
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 * @version 1.0
 */
public class AlbumControl implements AlbumSearcher<Album> {

	/**
	 * Saves provided album
	 * 
	 * @param album to save
	 * @return boolean if the process is correct
	 */
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
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Represents strategy pattern to find a List of Albums by provided Album Name
	 * 
	 * @return List<Ablum> by provided name
	 * @see List
	 */
	@Override
	public List<Album> findByName(String name) {
		List<Album> albums = new ArrayList<Album>();
		try {
			String sql = "SELECT album.ID_album, album.name, album.departure FROM album WHERE album.name  LIKE ?";
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
	 * Fetches album information by provided Album class whit ID
	 * 
	 * @param fetchedAlbum whit ID
	 * @return Album information
	 */
	public static Album fetchInfo(Album fetchedAlbum) {
		try {
			int bandID = -1;
			String sql = "SELECT alb.ID_album, alb.ID_band, alb.name, alb.departure, alb.comment, gen.ID_genre FROM album alb INNER JOIN genre gen ON alb.id_genre = gen.id_genre WHERE ID_album=?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setInt(1, fetchedAlbum.getID());
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				bandID = rs.getInt(2);
				fetchedAlbum.setName(rs.getString(3));
				fetchedAlbum.setDeparture(rs.getDate(4));
				fetchedAlbum.setGenreID(rs.getInt(6));
			}
			Band albumBand = BandControl.findByID(bandID);
			fetchedAlbum.setBand(albumBand);
			List<Song> albumSongs = SongControl.getAlbumSongsByID(fetchedAlbum.getID());
			fetchedAlbum.setSongs(albumSongs);
			return fetchedAlbum;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean deleteAlbumById(int albumID) {
		try {
			String sql = "DELETE FROM album WHERE album.ID_album=?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setInt(1, albumID);
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
