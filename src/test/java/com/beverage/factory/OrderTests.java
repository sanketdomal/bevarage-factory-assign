package com.beverage.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.beverage.factory.controller.OrderController;
import com.beverage.factory.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class OrderTests {
	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	private OrderController orderController;

	private void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void contexLoads() throws Exception {
		assertThat(orderController).isNotNull();
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	public void withAndWithoutExclusion() throws Exception {
		String uri = "/order";
		Order ordr = new Order();
		List<String> itemList = new ArrayList<String>();
		itemList.add("Chai, -milk");
		itemList.add("Cofee");
		itemList.add("Mojito, -soda");

		ordr.setOrderItems(itemList);
		String inputJson = mapToJson(ordr);
		setUp();
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "{\"orderItems\":[\"Chai, -milk\",\"Cofee\",\"Mojito, -soda\"],\"price\":15.0}");
	}
	
	@Test
	public void withoutExclusuion() throws Exception {
		String uri = "/order";
		Order ordr = new Order();
		List<String> itemList = new ArrayList<String>();
		itemList.add("Chai");
		itemList.add("Cofee");
		itemList.add("Mojito");

		ordr.setOrderItems(itemList);
		String inputJson = mapToJson(ordr);
		setUp();
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "{\"orderItems\":[\"Chai\",\"Cofee\",\"Mojito\"],\"price\":16.5}");
	}
	
	
}
