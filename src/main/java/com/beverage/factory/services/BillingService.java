package com.beverage.factory.services;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.beverage.factory.InvalidOrderException;
import com.beverage.factory.model.Beverage;
import com.beverage.factory.model.Ingredient;
import com.beverage.factory.model.Order;

@Service
public class BillingService {
	
	public Order calculateOrderBill(List<String> orderItems, HashMap<String, Beverage> menu) throws Exception {
		Order neworder= new Order();
		neworder.setOrderItems(orderItems);
		
		double total=0;
		for(String item:orderItems) {
			String [] exclusionsList = item.split(", -");
			if(exclusionsList.length==1) {
				total=total+menu.get(exclusionsList[0]).getCost();
			}else {
				Beverage b=menu.get(exclusionsList[0]);
				if(b.getIngredientList().size()==exclusionsList.length-1) {
					throw new InvalidOrderException("An order cannot have all the ingredients in exclusion for a menu item.");
				}
				double toMinus=0;
				for(int i=1;i<exclusionsList.length;i++) {				
					for(Ingredient ing : b.getIngredientList()) {
						if(ing.getName().equals(exclusionsList[i])) {
							toMinus=toMinus + ing.getCost();
						}
					}				
				}
				double test = menu.get(exclusionsList[0]).getCost()-toMinus;
				total=total+test;
			}
		}
		neworder.setPrice(total);		
		
		return neworder;
		
	}

}
