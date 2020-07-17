package com.uttec.controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uttec.database.DBConnection;
import com.uttec.entities.Song;

public class SongControl {

	public static List<Song> getAll() {
		List<Song> songs = new ArrayList<Song>();

		try {
			ResultSet rs = DBConnection.getConnection().prepareStatement(
					"SELECT song.id_song, song.name, song.release, song.comment FROM song INNER JOIN album ON song.id_song = album.id_song INNER JOIN band ON album.id_band = band.id_band")
					.executeQuery();
			while (rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4));
				songs.add(song);
			}
		} catch (Exception e) {
			System.out.println("No content");
		}
		return songs;
	}
}
