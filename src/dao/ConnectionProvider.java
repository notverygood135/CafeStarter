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
    public static Connection getCon(){
        String url = "jdbc:sqlserver://localhost:1433;databaseName=CafeManagement";
        String user = "dung2003";
        String password = "2003";
        try {
           Class.forName("com.mysql.jdbc.Driver");
                   return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e)
        { return null;
        }
      
        
        
        
       
        
        
        
        
        
    }
}
