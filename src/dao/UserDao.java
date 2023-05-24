package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;

public class UserDao {

    public void save(User user) {
        String query = "INSERT INTO user(name, email, mobilenumber, address, password, securityQuestion, answer, status) VALUES ('"
                + user.getName() + "', '"
                + user.getEmail() + "', '"
                + user.getMobileNumber() + "', '"
                + user.getAddress() + "', '"
                + user.getPassWord() + "', '"
                + user.getSecurityQuestion() + "', '"
                + user.getAnswer() + "', '"
                + "false" + "')";
        DbOperations.setDataOrDelete(query, "Registed Succcessfully,Wait for admin approval ");
    }

    public User login(String email, String Password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE  email = '" + email + "' AND password = '" + Password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("Status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE  email = '" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;

    }

    public static void updatePassWord(String Email, String newPass) {
        String query = "UPDATE user SET password = '" + newPass + "' WHERE email = '" + Email + "'";
        DbOperations.setDataOrDelete(query, "Changed Password Succcessfully");

    }
}
