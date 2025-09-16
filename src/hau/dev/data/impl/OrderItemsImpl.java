package hau.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hau.dev.data.dao.OrderItem;
import hau.dev.data.driver.MySQLDriver;
import hau.dev.data.model.OrderItems;

public class OrderItemsImpl implements OrderItem {

	@Override
	public boolean insert(OrderItems orderitems) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO ORDERITEMS(QUANTITY,PRICE, ORDER_ID,PRODUCT_ID) VALUES (?, ?, ?,?)";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderitems.quantity);
            stmt.setDouble(2, orderitems.price);
            stmt.setInt(3, orderitems.order_id);
            stmt.setInt(4, orderitems.product_id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean update(OrderItems orderitems) {
		// TODO Auto-generated method stub
		String sql = "UPDATE ORDERITEMS SET QUANTITY = ?, PRICE = ?, ORDER_ID = ?, PRODUCT_ID = ? WHERE ID = ?";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, orderitems.quantity);
            stmt.setDouble(2, orderitems.price);
            stmt.setInt(3, orderitems.order_id);
            stmt.setInt(4, orderitems.product_id);
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
		String sql = "DELETE FROM ORDERITEMS WHERE ID = ?";
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
	public OrderItems find(int id) {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM ORDERITEMS WHERE ID=?";
	        try (Connection conn = MySQLDriver.getInstance().getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, id);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int quantity = rs.getInt("quantity");
	                    double price = rs.getDouble("price");
	                    int order_id  = rs.getInt("order_id ");
	                    int product_id  = rs.getInt("product_id");
	                    return new OrderItems(quantity, product_id, price, order_id, product_id );
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        throw new RuntimeException("Không tìm thấy category với id = " + id);
	}

	@Override
	public List<OrderItems> findAll() {
		// TODO Auto-generated method stub
		List<OrderItems> orderitemsList = new ArrayList<>();
        String sql = "SELECT * FROM ORDERITEMS";
        try (Connection conn = MySQLDriver.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int order_id = rs.getInt("order_id");
                int product_id  = rs.getInt("product_id");
                orderitemsList.add(new OrderItems(quantity,product_id, price, order_id, product_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderitemsList;
    }
      
}
