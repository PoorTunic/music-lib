package com.uttec.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uttec.database.DBConnection;

/**
 * Represents Genre table actions on DB
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 *
 */
public class GenreControl {

	/**
	 * Fetches an Array of all genres stored on database
	 * 
	 * @return String array of genres
	 * @throws Exception if the DB connection can't be stablished
	 */
	public static String[] getGenres() throws Exception {
		List<String> genres = new ArrayList<String>();

		String sql = "SELECT ID_genre, name FROM genre";
		PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			genres.add(rs.getString(2));
		}
		return genres.toArray(new String[0]);
	}
}
