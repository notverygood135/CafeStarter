
package dao;

import javax.swing.JOptionPane;

public class tables {
	public static void main(String[] args) {
		try {
			/*String userTable = " CREATE TABLE myTable " + "( id INT IDENTITY(1,1) PRIMARY KEY," + "  name VARCHAR(200),"
					+ "  email VARCHAR(200) UNIQUE," + "  mobilenumber VARCHAR(200)," + "  address VARCHAR(200),"
					+ " password VARCHAR(200)," + " securityQuestion VARCHAR(200)," + " answer VARCHAR(200) ),"+"status VARCHAR(200)";
			DbOperations.setDataOrDelete(userTable, "Create Table successfully");*/

                        String adminDetails = "INSERT INTO myTable(name,email,mobilenumber,address,password,securityQuestion,answer,status) "
                                + " VALUES('dung','ledung200803@gmail.com','0335620803','Hanoi','12345678','What is your girlfriend name?','Phuong','true')";
                        String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),pricr varchar(200))";
                        String categoryTable = "create table category (id int AUTO_INCREMENT primary key,name varchar(200)";
                        DbOperations.setDataOrDelete(adminDetails, " Add admin details successfully");
                        DbOperations.setDataOrDelete(categoryTable, " Category Table Created successfully");
                        DbOperations.setDataOrDelete(productTable, " Product Table Created successfully");
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
}
