package com.beverage.factory.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beverage.factory.InvalidOrderException;
import com.beverage.factory.model.Beverage;
import com.beverage.factory.model.Order;
import com.beverage.factory.services.BillingService;
import com.beverage.factory.services.MenuService;

@RestController
public class OrderController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	BillingService billingService;
	
	@RequestMapping("/")
	public Order populateMenu() {
		
		ArrayList<String> arr= new ArrayList<String>();
		arr.add("Chai");
		arr.add("Cofee");
		Order order1 = new Order(arr, 20);
		return order1;
	}
	
	@RequestMapping(method = RequestMethod.POST ,path="/order")
	public Order placeOrder(@RequestBody Order order1) throws Exception {
		if(order1.getOrderItems().isEmpty()) {
			throw new InvalidOrderException("Order Should have at least one menu item");
		}
		HashMap<String, Beverage>beverageList= menuService.getBeverageMenu();
		Order orderDetails = billingService.calculateOrderBill(order1.getOrderItems(), beverageList);				
		return orderDetails;
	}
	
	

}
