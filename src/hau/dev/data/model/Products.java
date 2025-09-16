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
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getPrice_old() {
	return price_old;
}
public void setPrice_old(double price_old) {
	this.price_old = price_old;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getView() {
	return view;
}
public void setView(int view) {
	this.view = view;
}
public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}
public Timestamp getCreated_at() {
	return created_at;
}
public void setCreated_at(Timestamp created_at) {
	this.created_at = created_at;
}
}
