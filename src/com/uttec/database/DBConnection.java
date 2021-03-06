package com.uttec.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 * @version 1.0
 */
public class DBConnection {

	/**
	 * Connection instance
	 */
	private static Connection connection;

	/**
	 * Database attributes
	 */
	private static String DB_NAME = "/music_lib";
	private static String HOST = "/localhost:5432";
	private static String URL = "jdbc:postgresql:/";
	private static String DRIVER = "org.postgresql.Driver";
	private static String USER = "postgres";
	private static String PASSWORD = ""; /* Cambiar por su propia PWD */

	/**
	 * Constructor that loads the DB Driver and authentication
	 * 
	 * @throws Exception ClassNotFound, SQLException Thrown when the DB Driver isn't
	 *                   found or it can't connect to DB, verify Project path and
	 *                   {@link #USER} / {@link #PASSWORD} values
	 */
	private DBConnection() throws Exception {
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL + HOST + DB_NAME, USER, PASSWORD);
	}

	/**
	 * Gets the connection, if it is not created, it will create a new instance
	 * 
	 * @return java.sql.Connection
	 * @throws Exception SQLException Thrown when the DB Driver isn't found or it
	 *                   can't connect to DB, verify Project path and {@link #USER}
	 *                   / {@link #PASSWORD} values
	 */
	public static Connection getConnection() throws Exception {
		if (connection == null) {
			new DBConnection();
		}
		return connection;
	}

	/**
	 * Closes the connection
	 * 
	 * @throws SQLException Thrown when SQLConnection can't be closed
	 */
	public static void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	/*
	 * Testing DB connection method
	 */
//	public static void main(String[] arguments) {
//		try {
//			ResultSet resultSet = DBConnection.getConnection().prepareStatement("SELECT * FROM genre").executeQuery();
//			while(resultSet.next()) {
//				System.out.println(rs.getString(2));
//			}
//		} catch (Exception e) {
//			System.out.println(e.getLocalizedMessage());
//		}
//	}

}
