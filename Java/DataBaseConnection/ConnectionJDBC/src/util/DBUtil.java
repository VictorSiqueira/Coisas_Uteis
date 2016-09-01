package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//https://programmingenthusiast.wordpress.com/2015/05/02/a-simple-crud-tutorial-using-java-servletjsp-and-mysql/
	//http://www.mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java/
	private static Connection connection;
	public static Connection getDBConnection() {
		try {
			System.out.println("-------- MySQL JDBC Connection Testing ------------");
			
			Class.forName("com.mysql.jdbc.Driver");//ClassNotFoundException
			System.out.println("MySQL JDBC Driver Registered!");			
			
			connection = null;
			//getConnection("endereco e nome da base", "usuario", "senha");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");//SQLException
			
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
