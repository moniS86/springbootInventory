package com.ims.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.inventory.exception.InventoryException;
import com.ims.inventory.model.Inventory;
import com.ims.inventory.service.InventoryService;

import junit.framework.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest
class InventoryServiceTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	ObjectMapper om = new ObjectMapper();
@Autowired
InventoryService service;
	
	@Before
	public void SetUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}


	@Test
	void testSave() throws InventoryException {
		Inventory res = new Inventory();
		Inventory inv = new Inventory();
		inv.setName("PROD10");
		inv.setDescription("Prod10 description");
		res=service.save(inv);
		Assert.assertNotNull(res);
	}


	@Test
	void testFailSave() throws InventoryException {
		Inventory res = new Inventory();
		Inventory inv = new Inventory();
		inv.setName(null);
		inv.setDescription("Prod10 description");
		res=service.save(inv);
		Assert.assertNotNull(res);
	}

	@Test
	public void testGetAllInventories() throws Exception {
		List<Inventory> res= new ArrayList<Inventory>();
		res = service.findAll();
		Assert.assertEquals(res.isEmpty(), false);
	}

	@Test
	void testFindById() throws InventoryException {
		Optional<Inventory> res =  service.findById((long) 1);
		Assert.assertEquals(res.isEmpty(), false);
	}

	@Test
	void testFailFindById() throws InventoryException {
		Optional<Inventory> res =  service.findById(null);
		Assert.assertEquals(res.isEmpty(), true);
	}
	
	@Test
	void testDeleteById() throws InventoryException {
		service.deleteById((long) 21);
		Optional<Inventory> res =  service.findById((long) 21);
		Assert.assertFalse("true", res.isEmpty());
		
	}
	@Test
	void testFailDeleteById() throws InventoryException {
		service.deleteById((long) 0);
		Optional<Inventory> res =  service.findById(null);
		Assert.assertFalse("true", res.isPresent());
		
	}

}
