package com.entity;

public class Book_Order {
	private int id;
	private String OrderId;
	private String username;
	private String email;
	private String phno;
	private String fulladd;
	private String paymentType;
	private String bookNmae;
	private String  author;
	private String price;
	
	public String getBookNmae() {
		return bookNmae;
	}

	public void setBookNmae(String bookNmae) {
		this.bookNmae = bookNmae;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Book_Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getFulladd() {
		return fulladd;
	}
	public void setFulladd(String fulladd) {
		this.fulladd = fulladd;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "Book_Order [id=" + id + ", username=" + username + ", email=" + email + ", phno=" + phno + ", fulladd="
				+ fulladd + ", paymentType=" + paymentType + "]";
	}
	
	
}
