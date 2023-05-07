/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author Dungpc
 */
public class tables {
    public static void main(String[] args) {
        try {
            String userTable = " CREATE TABLE myTable " +
"  id INT IDENTITY(1,1) PRIMARY KEY," +
"  name VARCHAR(200)," +
"  email VARCHAR(200) UNIQUE," +
"  mobilenumber VARCHAR(200)," +
"  address VARCHAR(200)," +
" password VARCHAR(200),"+
              " securityQuestion VARCHAR(200),"+
                    " answer VARCHAR(200)";
            DbOperations.setDataorDelete(userTable, "Create Table successfully");
            
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
