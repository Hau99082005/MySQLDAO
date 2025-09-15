package hau.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hau.dev.data.dao.CategoryDao;
import hau.dev.data.driver.MySQLDriver;
import hau.dev.data.model.Category;

public class CategoryImpl implements CategoryDao {

    @Override
    public boolean insert(Category category) {
        String sql = "INSERT INTO CATEGORIES(NAME, THUMBNAIL) VALUES (?, ?)";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category.name);
            stmt.setString(2, category.thumbnail);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category category) {
        String sql = "UPDATE CATEGORIES SET NAME = ?, THUMBNAIL = ? WHERE ID = ?";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category.name);
            stmt.setString(2, category.thumbnail);
            stmt.setInt(3, category.id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM CATEGORIES WHERE ID = ?";
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
    public Category find(int id) {
        String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String thumbnail = rs.getString("thumbnail");
                    return new Category(id, name, thumbnail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Không tìm thấy category với id = " + id);
    }


    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIES";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String thumbnail = rs.getString("thumbnail");
                categoryList.add(new Category(id, name, thumbnail));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
