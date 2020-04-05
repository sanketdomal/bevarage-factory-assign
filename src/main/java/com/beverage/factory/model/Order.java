package com.beverage.factory.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<String> orderItems;
	private double totalPrice;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(ArrayList<String> orderItems, int price) {
		super();
		this.orderItems = orderItems;
		this.totalPrice = price;
	}
	public List<String> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<String> orderItems) {
		this.orderItems = orderItems;
	}
	public double getPrice() {
		return totalPrice;
	}
	public void setPrice(double price) {
		this.totalPrice = price;
	} 
	
}
