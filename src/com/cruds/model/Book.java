package com.cruds.model;

public class Book {
	
	private String isbn;
	private String title;
	private String Category;
	private int quantity;
	
	public Book(String isbn, String title, String category, int quantity) {
		this.isbn = isbn;
		this.title = title;
		Category = category;
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "" + isbn + "\t\t" + title + "\t\t" + Category + "\t\t" + quantity;
	}
	
}
