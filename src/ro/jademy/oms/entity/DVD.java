package ro.jademy.oms.entity;

public class DVD extends Product {
	private String director;
	private Integer length;
	
	public DVD() {
		
	}
	
	public DVD(String title, String category, String director, Integer length, Double cost, Integer stock, int code) {
		super(code,title,cost,stock,category);
		this.director = director;
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "DVD [title=" + getTitle() + ", category=" + getCategory() + ", director=" + director + ", length=" + length
				+ ", cost=" + getCost() + "]";
	}

	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
}
