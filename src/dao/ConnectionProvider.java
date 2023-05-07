/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

/**
 *
 * @author Dungpc
 */
public class ConnectionProvider {
	public static Connection getCon() {
		String url = "jdbc:sqlserver://database-2.cglnwe68wxsl.ap-southeast-2.rds.amazonaws.com:1433;databaseName=CafeManagement";
		String user = "admin";
		String password = "12345678";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}
}
