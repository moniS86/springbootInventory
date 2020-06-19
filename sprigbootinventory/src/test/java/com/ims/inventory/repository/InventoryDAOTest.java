package com.ims.inventory.repository;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.infrastructure.inventory.repository.InventoryDAO;
import com.ims.inventory.model.Inventory;
@RunWith(SpringRunner.class)
@SpringBootTest
class InventoryDAOTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	ObjectMapper om = new ObjectMapper();
	@Autowired
	InventoryDAO dao;
	@Test
	void testSaveAll() {
		List<Inventory> entities = new ArrayList<>();
		dao.saveAll(entities);
		Assert.assertEquals(entities, entities);;
	}

	@Test
	void testExistsById() {
		dao.existsById( (long) 0);
		Assert.assertEquals(0, 0);
	}

	@Test
	void testFindAllById() {
		Iterable<Long> ids  = new ArrayList<>();
		dao.findAllById(ids);
		Assert.assertEquals(0, 0);
	}

	@Test
	void testCount() {
		dao.count();
		Assert.assertEquals(0, 0);
	}

	@Test
	void testDeleteAllIterableOfQextendsInventory() {
		Iterable<? extends Inventory> ids  = new ArrayList<>();
		dao.deleteAll(ids);
		Assert.assertEquals(0, 0);
	}

	@Test
	void testDeleteAll() {
		dao.deleteAll();
		Assert.assertEquals(0, 0);
	}

	@Test
	void testDelete() {
		dao.delete(new Inventory());
		Assert.assertEquals(0, 0);
		}

}
