package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnections {
	private static String HOST = "localhost";
	private static String PASSWORD = "projects";
	private static String SCHEMA = "projects";
	private static String USER = "projects";
	private static int PORT = 3307;
	
	public static Connection getConnection() {
		String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s",HOST,PORT,SCHEMA,USER,PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(uri);
			System.out.println("Connection to Schema \"" + SCHEMA + "\" was successful");
			return conn;
		} catch (SQLException e){
			System.out.println("unable to get connection at" + uri);
			throw new DbException("Unable to get connection at \" + uri");
		}
		
	}
}

