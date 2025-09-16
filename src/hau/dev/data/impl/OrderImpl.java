package hau.dev.data.impl;

import hau.dev.data.dao.OrderDao;
import hau.dev.data.driver.MySQLDriver;
import hau.dev.data.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements OrderDao{
    @Override
    public boolean insert(Order order) {
        String sql = "INSERT INTO ORDER(CODE,STATUS,USER_ID,CREATED_AT) VALUES (?, ?, ?,?)";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, order.code);
            stmt.setBoolean(2, order.status);
            stmt.setInt(3, order.user_id);
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public boolean update(Order order) {
		// TODO Auto-generated method stub
		String sql = "UPDATE ORDER SET CODE = ?, STATUS = ?, USER_ID = ?, CREATED_AT = ? WHERE ID = ?";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, order.code);
            stmt.setBoolean(2, order.status);
            stmt.setInt(3, order.user_id);
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM ORDER WHERE ID = ?";
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
	public Order find(int id) {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM ORDER WHERE ID=?";
	        try (Connection conn = MySQLDriver.getInstance().getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, id);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    String code = rs.getString("code");
	                    boolean status = rs.getBoolean("status");
	                    int user_id = rs.getInt("user_id");
	                    Timestamp created_at = rs.getTimestamp("created_at");
	                    return new Order(code, status, user_id, created_at);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        throw new RuntimeException("Không tìm thấy category với id = " + id);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		 List<Order> orderList = new ArrayList<>();
	        String sql = "SELECT * FROM ORDER";
	        try (Connection conn = MySQLDriver.getInstance().getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                String code = rs.getString("code");
	                boolean status = rs.getBoolean("status");
	                int user_id = rs.getInt("user_id");
	                Timestamp created_at = rs.getTimestamp("created_at");
	                orderList.add(new Order(code, status, user_id, created_at));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orderList;
	    }
}
