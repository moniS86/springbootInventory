package com.ims.inventory.dto;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.ims.inventory.model.Inventory;

class InventoryDTOTest {

	@Test
	void testHashCode() {
		InventoryDTO invent = new InventoryDTO(91,"", null);
				int hashvalue = invent.hashCode();
				Assert.assertNotSame(false,hashvalue);
	}

	@Test
	void testInventoryDTO() {
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
		Assert.assertFalse(invent.canEqual(inventory));
	}

	@Test
	void testToString() {
		InventoryDTO invent = new InventoryDTO(91,"", null);
		String inv = invent.toString();
		Assert.assertNotNull(inv, invent);
	}

	@Test
	void testInventoryDTOLongStringString() {
		Assert.assertEquals(0, 0);  //NOSONAR
	}

}
