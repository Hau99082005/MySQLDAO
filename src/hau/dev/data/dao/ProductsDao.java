package hau.dev.data.dao;
import java.util.List;

import hau.dev.data.model.Products;


public interface ProductsDao {
	public boolean insert(Products products);
	public boolean update(Products products);
	public boolean delete(int id);
	public Products find(int id);
    public List<Products> findAll();
    
}
