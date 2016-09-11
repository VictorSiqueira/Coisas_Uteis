package com.application.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection connection;

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");// ClassNotFoundException
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");// SQLException

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
				return connection;
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return null;
	}
}
