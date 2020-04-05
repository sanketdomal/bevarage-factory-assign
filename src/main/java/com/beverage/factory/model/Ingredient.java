package com.beverage.factory.model;

public class Ingredient {

	private String name;
	private double cost;
	
	public Ingredient(String name, double d) {
		super();
		this.name = name;
		this.cost = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
