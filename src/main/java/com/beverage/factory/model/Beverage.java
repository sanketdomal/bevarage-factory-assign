package com.beverage.factory.model;

import java.util.Set;

public class Beverage {

	private String name;
	private Set<Ingredient> IngredientList;
	private double cost;
	public Beverage(String name, Set<Ingredient> ingredientList, double cost) {
		super();
		this.name = name;
		IngredientList = ingredientList;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Ingredient> getIngredientList() {
		return IngredientList;
	}
	public void setIngredientList(Set<Ingredient> ingredientList) {
		IngredientList = ingredientList;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}	
	
}
