package hau.dev.data.dao;

import java.util.List;

import hau.dev.data.model.OrderItems;

public interface OrderItem {
	public boolean insert(OrderItems orderitems);
	public boolean update(OrderItems orderitems);
	public boolean delete(int id);
	public OrderItems find(int id);
    public List<OrderItems> findAll();
}
