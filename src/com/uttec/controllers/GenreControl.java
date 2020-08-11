package com.uttec.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uttec.database.DBConnection;

public class GenreControl {

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
