package com.example.api;

public class Product {

	private String pId;
	private String pName;
	private String price;

	public Product() {

	}

	public Product(String pId, String pName, String price) {
		this.pId = pId;
		this.pName = pName;
		this.price = price;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
