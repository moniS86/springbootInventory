package com.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dao.InventoryDAO;
import com.inventory.model.Inventory;

@RestController
@RequestMapping("/company")
public class InventoryController {

	@Autowired
	InventoryDAO inventoryDAO;

	/* Save Inventory */
	@PostMapping("/inventories")
	public Inventory createInventory(@Valid @RequestBody Inventory inventory) {
		return inventoryDAO.save(inventory);
	}

	/* Search all Inventories */
	@GetMapping("/inventories")
	public List<Inventory> getAllInventories() {
		return inventoryDAO.findAll();
	}

	/* Get an Inventory by id */
	@GetMapping("/inventories/{id}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable(value = "id") Long invId) {
		Inventory inventory = inventoryDAO.getOne(invId);
		if (inventory == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(inventory);
		}

	}

	/* Update an inventory by Id */
	@PutMapping("/inventories/{id}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable(value = "id") Long invId,
			@Valid @RequestBody Inventory inventory) {
		Inventory inv = inventoryDAO.getOne(invId);
		if (inventory == null) {
			return ResponseEntity.notFound().build();
		} else {
			inv.setName(inventory.getName());
			inv.setDescription(inventory.getDescription());

			Inventory updateInventory = inventoryDAO.save(inv);
			return ResponseEntity.ok().body(updateInventory);
		}
	}
	/* Delete an Inventory */
		// Redis cache
		@DeleteMapping("/inventories/{id}")
		public List<Inventory> deleteInventory(@PathVariable(value = "id") Long invId) {
			Inventory inv = inventoryDAO.getOne(invId);
			/*if (inv == null) {
				return ResponseEntity.notFound().build();
			} else {*/
				inventoryDAO.delete(inv);
			/*}
			return ResponseEntity.ok().build();*/
			return getAllInventories();
		}

	}

