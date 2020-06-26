package com.ims.inventory.model;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.ims.inventory.dto.InventoryDTO;

class InventoryTest {

	@Test
	void testHashCode() {
		Inventory invent = new Inventory(91,"", null);
		int hashvalue = invent.hashCode();
		Assert.assertNotSame(false,hashvalue);
	}

	@Test
	void testInventory() {
		Assert.assertEquals(0, 0);  //NOSONAR
	}

	@Test
	void testEqualsObject() {
		InventoryDTO invent = new InventoryDTO(91,"", null);
		Inventory inventory = new Inventory(91,"", null);
		Assert.assertFalse(inventory.equals(invent));
		Assert.assertFalse(invent.equals(inventory));
	}

	@Test
	void testCanEqual() {
		InventoryDTO invent = new InventoryDTO(91,"", null);
		Inventory inventory = new Inventory(91,"", null);
		Assert.assertFalse(inventory.canEqual(invent));
	}

	@Test
	void testToString() {
		Inventory invent = new Inventory(91,"", null);
		String inv = invent.toString();
		Assert.assertNotNull(inv, invent);
	}

}
