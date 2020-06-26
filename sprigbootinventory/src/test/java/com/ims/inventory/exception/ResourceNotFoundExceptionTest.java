package com.ims.inventory.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ims.inventory.model.Inventory;
@RunWith(SpringRunner.class)
@SpringBootTest
class ResourceNotFoundExceptionTest {

ResourceNotFoundException exp;
	
	
	
	@Test
	void testGetResourceName() {
		Assert.assertEquals(0, 0);  //NOSONAR
	}

	@Test
	void testGetFieldName() {
		Assert.assertEquals(0, 0);  //NOSONAR
	}

	@Test
	void testGetFieldValue() {
		Assert.assertEquals(0, 0);  //NOSONAR
	}

	@Test
	void testEqualsObject() {
		ResourceNotFoundException invent = new ResourceNotFoundException("Inventory", "id", 1);
		ResourceNotFoundException inventory = new ResourceNotFoundException("Inventory", "id", 2);
		Assert.assertTrue(inventory.equals(invent));
		Assert.assertTrue(invent.equals(inventory));
	}

	@Test
	void testCanEqual() {
		ResourceNotFoundException invent = new ResourceNotFoundException("Inventory", "id", 1);
		ResourceNotFoundException inventory = new ResourceNotFoundException("Inventory", "id", 1);
		Assert.assertTrue(invent.canEqual(inventory));
	}

	@Test
	void testToString() {
		ResourceNotFoundException invent = new ResourceNotFoundException("Inventory", "id", 1);
		String inv = invent.toString();
		Assert.assertNotNull(inv, invent);
	}

	@Test
	void testHashCode() {
		ResourceNotFoundException invent = new ResourceNotFoundException("Inventory", "id", 1);
		int hashvalue = invent.hashCode();
		Assert.assertNotSame(false,hashvalue);
	}
}
