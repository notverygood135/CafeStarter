/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Bill;

/**
 *
 * @author Admin
 */
public class BillDao {
    public static int getNextId() {
        int id = 1;
        try {
            ResultSet rs = DbOperations.getData("SELECT MAX(id) FROM bill");
            if (rs.next()) {
                id = rs.getInt(1);
                id++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return id;
    }
    
    public static void save(Bill bill) {
        String query = String.format(
                "INSERT INTO bill VALUES(%d, '%s', '%s', '%s', '%s', %.2f, '%s')", 
                bill.getId(),
                bill.getName(),
                bill.getMobileNumber(),
                bill.getEmail(),
                bill.getDate().toString(),
                bill.getTotal(),
                bill.getCreatedBy());
        
        DbOperations.setDataOrDelete(query, "Bill details added successfully!");
    }
}
