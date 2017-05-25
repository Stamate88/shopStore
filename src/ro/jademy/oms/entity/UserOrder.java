package ro.jademy.oms.entity;

import java.util.ArrayList;

public class UserOrder {

	private String number;
	private ArrayList<Product> products;
	private String userId;
	
	public UserOrder(String userId) {
		super();
		products = new ArrayList<Product>();
		this.userId = userId;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
