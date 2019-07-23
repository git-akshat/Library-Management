package com.cruds.model;

public class Author {
	
	private String name;
	private String email;
	public String book_isbn;
	
	public Author(String name, String email, String book_isbn) {
		this.name = name;
		this.email = email;
		this.book_isbn = book_isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}

	@Override
	public String toString() {
		return "" + name + "\t" + email + "\t" + book_isbn;
	}
	
	

}
