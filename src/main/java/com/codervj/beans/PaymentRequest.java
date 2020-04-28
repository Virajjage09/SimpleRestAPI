package com.codervj.beans;

public class PaymentRequest {

	private int userId;
	private String itemId;
	private double price;
	 
	 
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double discount) {
		this.price = discount;
	}
	
	 
}
