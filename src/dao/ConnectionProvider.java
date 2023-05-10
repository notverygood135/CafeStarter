/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Dungpc
 */
public class ConnectionProvider {
	public static Connection getCon() {
		String url = "jdbc:sqlserver://database-2.cglnwe68wxsl.ap-southeast-2.rds.amazonaws.com:1433;databaseName=CafeManagement";
		String user = "admin";
		String password = "12345678";
                        System.out.println(123);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, user, password);
                        System.out.println(con);
                        return con;
		} catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}
}
