package com.uttec.controllers;

import java.sql.ResultSet;

import com.uttec.database.DBConnection;

public class Song {

	public Song() {

	}

	public static String[][] getAll() {
		String[][] data = null;

		try {
			ResultSet rs = DBConnection.getConnection().prepareStatement(
					"SELECT song.id_song, song.name, band.name, song.release FROM song INNER JOIN album ON song.id_song = album.id_song INNER JOIN band ON album.id_band = band.id_band")
					.executeQuery();

			while (rs.next()) {

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return data;
	}

}
