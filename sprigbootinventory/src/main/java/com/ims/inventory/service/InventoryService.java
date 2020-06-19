package com.ims.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.infrastructure.inventory.repository.InventoryDAO;
import com.ims.inventory.exception.InventoryException;
import com.ims.inventory.model.Inventory;

/**
 * @author ctsjavafsd21
 *
 */
@Service
public class InventoryService {

	@Autowired
	InventoryDAO inventoryDAO;

	/**
	 * Saves Inventory data
	 * 
	 * @param inventory
	 * @return
	 */
	public Inventory save(@Valid Inventory inventory) throws InventoryException {
		Inventory inv = new Inventory(0, inventory.getName(), inventory.getDescription());
		try {
			inv = inventoryDAO.save(inventory);
		} catch (Exception e) {
			throw new InventoryException(e.getMessage(), e);

		}
		return inv;
	}

	/**
	 * @return List of inventories
	 */
	public List<Inventory> findAll() throws InventoryException {
		List<Inventory> inventories = new ArrayList<>();
		try {
			inventories = inventoryDAO.findAll();
		} catch (Exception e) {
			throw new InventoryException(e.getMessage(), e);
		}
		return inventories;
	}

	/**
	 * Get inventory by id
	 * 
	 * @param invId
	 * @return
	 */
	public Optional<Inventory> findById(Long invId) throws InventoryException {
		Optional<Inventory> inventory;
		try {
			inventory = inventoryDAO.findById(invId);
		} catch (Exception e) {
			throw new InventoryException(e.getMessage(), e);
		}
		return inventory;
	}

	/**
	 * Delete inventory by id
	 * 
	 * @param invId
	 * @throws InventoryException
	 */
	public Inventory deleteById(Long invId) throws InventoryException {
		Inventory inventory = new Inventory();
		try {
			inventoryDAO.deleteById(invId);
		} catch (Exception e) {
			throw new InventoryException(e.getMessage(), e);
		}
		return inventory;
	}

}
