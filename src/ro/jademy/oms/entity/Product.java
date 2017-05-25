package ro.jademy.oms.entity;

public class Product {
	private int code;
	private String title;
	private Double cost;
	private Integer stock;
	private String category;
	
	public Product() {
		
	}
	
	public Product(int code, String title, Double cost, Integer stock, String category) {
		super();
		this.code = code;
		this.title = title;
		this.cost = cost;
		this.stock = stock;
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
