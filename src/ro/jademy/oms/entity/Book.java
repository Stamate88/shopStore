package ro.jademy.oms.entity;

public class Book extends Product {

	private String authors;
	private Integer pages;

	public Book() {
	}

	public Book(String title, String category, String author, Integer pages, Double cost, Integer stock,
			int code) {
		super(code, title, cost, stock, category);
		authors = author;
		this.pages = pages;
	}

	public void setAuthor(String author) {
		authors = author;
	}

	public String getAuthors() {
		return authors;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return authors + "   " + getTitle();
	}
}
