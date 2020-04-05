package com.beverage.factory.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.beverage.factory.model.Beverage;
import com.beverage.factory.model.Ingredient;

@Service
public class MenuService {

	HashMap<String, Beverage> beverageMap;



	public HashMap<String, Beverage> getBeverageMenu() {
		Ingredient milk = new Ingredient("milk", 1);
		Ingredient sugar = new Ingredient("sugar", 0.5);
		Ingredient soda = new Ingredient("soda", 0.5);
		Ingredient mint = new Ingredient("mint", 0.5);
		Ingredient water = new Ingredient("water", 0.5);

		beverageMap = new HashMap<String, Beverage>();
		
		// Cofee
		Set<Ingredient> cofeeIngredients = new HashSet<Ingredient>();
		cofeeIngredients.add(milk);
		cofeeIngredients.add(sugar);
		cofeeIngredients.add(water);
		Beverage cofee = new Beverage("Cofee", cofeeIngredients, 5);

		beverageMap.put("Cofee", cofee);

		// Chai
		Set<Ingredient> chaiIngredients = new HashSet<Ingredient>();
		chaiIngredients.add(milk);
		chaiIngredients.add(sugar);
		chaiIngredients.add(water);
		Beverage chai = new Beverage("Chai", chaiIngredients, 4);
		beverageMap.put("Chai", chai);

		// Banana Smoothie
		Set<Ingredient> bananaSmoothieIngredients = new HashSet<Ingredient>();
		bananaSmoothieIngredients.add(milk);
		bananaSmoothieIngredients.add(sugar);
		bananaSmoothieIngredients.add(water);
		Beverage bananaSmoothie = new Beverage("Banana Smoothie", bananaSmoothieIngredients, 6);
		beverageMap.put("Banana Smoothie", bananaSmoothie);

		// StrawBerry Shake
		Set<Ingredient> strawBerryShakeIngredients = new HashSet<Ingredient>();
		strawBerryShakeIngredients.add(milk);
		strawBerryShakeIngredients.add(sugar);
		strawBerryShakeIngredients.add(water);
		Beverage strawBerryShake = new Beverage("StrawBerry Shake", strawBerryShakeIngredients, 7);
		beverageMap.put("trawBerry Shake", strawBerryShake);

		// Mojito
		Set<Ingredient> mojitoIngredients = new HashSet<Ingredient>();
		mojitoIngredients.add(soda);
		mojitoIngredients.add(sugar);
		mojitoIngredients.add(water);
		mojitoIngredients.add(mint);
		Beverage mojito = new Beverage("Mojito", mojitoIngredients, 7.5);
		beverageMap.put("Mojito", mojito);

		return beverageMap;
	}

}
