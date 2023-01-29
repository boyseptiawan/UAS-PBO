package com.saepul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.saepul.connection.DBConnection;

public class ProductModel {

    public ProductModel(){
        DBConnection db = new DBConnection("db_product", "root", "");
        db.setConnection();
        this.conn = db.getConn();
    }

    private Connection conn;
    private PreparedStatement prepareStmt;
    private ResultSet rs;

    public void showAllProduct(){
        try {
            String sql = "SELECT * FROM product";
            prepareStmt = conn.prepareStatement(sql);
            rs = prepareStmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Nama Produk: " + rs.getString("product_name"));
                System.out.println("Jumlah: " + rs.getString("qty"));
                System.out.println("Harga: " + rs.getString("price"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveProduct(String productName, String qty, String price) {

        try {
            String sql = "INSERT INTO product (product_name, qty, price) values(?,?,?)";
            prepareStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepareStmt.setString(1, productName);
            prepareStmt.setInt(2, Integer.parseInt(qty));
            prepareStmt.setInt(3, Integer.parseInt(price));
            prepareStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProduct(String id, String productName, String qty, String price) {
        try {
            String sql = "UPDATE INTO product(product_name, qty, price) values(?,?,?) WHERE id = ?";
            prepareStmt = conn.prepareStatement(sql);
            prepareStmt.setString(1, productName);
            prepareStmt.setInt(2, Integer.parseInt(qty));
            prepareStmt.setInt(3, Integer.parseInt(price));
            prepareStmt.setInt(4, Integer.parseInt(id));
            prepareStmt.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteProduct(String id) {
        try {
            String sql = "DELETE FROM product WHERE id = ?";
            prepareStmt = conn.prepareStatement(sql);
            prepareStmt.setInt(1, Integer.parseInt(id));
            prepareStmt.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
