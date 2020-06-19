package com.ims.inventory.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.inventory.controller.InventoryController;
import com.ims.inventory.model.Inventory;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryControllerTest {

	@InjectMocks
	private InventoryController inventoryController;
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void SetUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testCreateInventory() throws Exception {
		Inventory inv = new Inventory();
		inv.setName("PROD6");
		inv.setDescription("Prod6 description");
		String jsonRequest = om.writeValueAsString(inv);
		MvcResult result = (MvcResult) mockMvc
				.perform(post("/company/inventories").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				 .andExpect((ResultMatcher) status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Assert.assertTrue(resultContent, true);
	}

	@Test
	public void testGetAllInventories() throws Exception {
		Inventory inv = new Inventory();
		String jsonRequest = om.writeValueAsString(inv);
		MvcResult result = (MvcResult) mockMvc
				.perform(get("/company/inventories").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				//.andReturn();
		 .andExpect((ResultMatcher) status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Assert.assertTrue(resultContent, true);
	}

	@Test
	public void testGetInventoryById() throws Exception {
		Inventory inv = new Inventory();
		String jsonRequest = om.writeValueAsString(inv);
		MvcResult result = (MvcResult) mockMvc
				.perform(get("/company/inventories/1").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
		 .andExpect((ResultMatcher) status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Assert.assertTrue(resultContent, true);
	}

	@Test
	public void testUpdateInventory() throws Exception {
		Inventory inv = new Inventory();
		inv.setName("PROD6");
		inv.setDescription("Prod6 description");
		String jsonRequest = om.writeValueAsString(inv);
		MvcResult result = (MvcResult) mockMvc
				.perform(put("/company/inventories/6").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				 .andExpect((ResultMatcher) status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Assert.assertTrue(resultContent, true);
	}

	@Test
	public void testDeleteInventory() throws Exception {
		Inventory inv = new Inventory();
		String jsonRequest = om.writeValueAsString(inv);
		MvcResult result = (MvcResult) mockMvc
				.perform(delete("/company/inventories/6").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
		 .andExpect((ResultMatcher) status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Assert.assertTrue(resultContent, true);
	}

	
}
