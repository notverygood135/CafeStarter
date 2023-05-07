/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Dungpc
 */
public class DbOperations {
	public static void setDataOrDelete(String querry, String message) {
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate(querry);
			if (!message.equals(" ")) {
				JOptionPane.showMessageDialog(null, message);
			}
		} catch (HeadlessException | SQLException e) {
			JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
		}

	}
}
