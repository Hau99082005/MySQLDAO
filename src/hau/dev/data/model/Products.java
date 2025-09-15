package hau.dev.data.model;

import java.sql.Timestamp;

public class Products {
  public int id;
  public String name;
  public String description;
  public String image;
  public double price;
  public double price_old;
  public int quantity;
  public int view;
  public int category_id;
  public Timestamp created_at;
public Products(int id, String name, String description, String image, double price, double price_old, int quantity,
		int view, int category_id, Timestamp created_at) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.image = image;
	this.price = price;
	this.price_old = price_old;
	this.quantity = quantity;
	this.view = view;
	this.category_id = category_id;
	this.created_at = created_at;
}
}
