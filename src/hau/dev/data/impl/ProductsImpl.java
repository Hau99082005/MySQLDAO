package hau.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import hau.dev.data.dao.ProductsDao;
import hau.dev.data.driver.MySQLDriver;
import hau.dev.data.model.Products;

public class ProductsImpl implements ProductsDao {

    @Override
    public boolean insert(Products products) {
        String sql = "INSERT INTO Products(NAME, IMAGE, DESCRIPTION, PRICE, PRICE_OLD, QUANTITY, VIEW, CATEGORY_ID, CREATED_AT) VALUES (?, ?,?,?,?,?,?,?,?";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, products.name);
            stmt.setString(2, products.image);
            stmt.setString(3, products.description);
            stmt.setDouble(4, products.price);
            stmt.setDouble(5, products.price_old);
            stmt.setInt(5, products.quantity);
            stmt.setInt(6, products.view);
            stmt.setInt(7, products.category_id);
            stmt.setTimestamp(8, products.created_at);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Products products) {
        String sql = "UPDATE PRODUCTS SET NAME = ?, IMAGE = ?, DESCRIPTION = ?, PRICE = ?, PRICE_OLD = ?, QUANTITY = ?, VIEW = ?, CATEGORY_ID = ?, CREATED_AT = ? WHERE ID = ?";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, products.name);
            stmt.setString(2, products.image);
            stmt.setString(3, products.description);
            stmt.setDouble(4, products.price);
            stmt.setDouble(5, products.price_old);
            stmt.setInt(6, products.quantity);
            stmt.setInt(7, products.view);
            stmt.setInt(8, products.category_id);
            stmt.setTimestamp(9, products.created_at);
            stmt.setInt(10, products.id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Products find(int id) {
        String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    double price_old = rs.getDouble("price_old");
                    int quantity = rs.getInt("quantity");
                    int view = rs.getInt("view");
                    int category_id  = rs.getInt("category_id ");
                    Timestamp created_at = rs.getTimestamp("created_at");
                    
                    return new Products(id, name, image,description, price, price_old, quantity, view, category_id , created_at);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Không tìm thấy products với id = " + id);
    }


    @Override
    public List<Products> findAll() {
        List<Products> productsList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                double price_old = rs.getDouble("price_old");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int category_id  = rs.getInt("category_id ");
                Timestamp created_at = rs.getTimestamp("created_at");
                productsList.add(new Products(id, name, image, description, price, price_old, quantity, view, category_id, created_at));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }
}
