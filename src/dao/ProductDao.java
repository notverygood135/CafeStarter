/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Product;

/**
 *
 * @author Hasagi
 */
public class ProductDao {

    public static void save(Product product) {
        String query = "insert into product(name,category,price) values('" + product.getName() + "','" + product.getCategory() + "'," + product.getPrice() + ")";
        DbOperations.setDataOrDelete(query, "Product Added Successfully");
    }

    public static List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return products;
    }

    public static void update(Product product) {
        String query = String.format(
                "UPDATE product SET name = '%s', "
                + "category = '%s', "
                + "price = '%f' "
                + "WHERE id = '%d'",
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getId());

        DbOperations.setDataOrDelete(query, "Product updated successfully!");
    }

    public static void delete(int id) {
        String query = "DELETE FROM product WHERE id = '" + id + "'";

        DbOperations.setDataOrDelete(query, "Product deleted successfully!");
    }

    public static List<Product> filterByCategory(String category) {
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE category = '%s'".formatted(category));
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                products.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return products;
    }

    public static List<Product> filterByName(String name, String category) {
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name LIKE '%%%s%%' AND category = '%s'".formatted(name, category));
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                products.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return products;
    }

    public static Product getByName(String name) {
        Product product = new Product();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name = '%s'".formatted(name));
            while (rs.next()) {
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getDouble(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
