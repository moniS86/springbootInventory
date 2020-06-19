package com.ims.inventory.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.inventory.dto.InventoryDTO;
import com.ims.inventory.exception.InventoryException;
import com.ims.inventory.exception.ResourceNotFoundException;
import com.ims.inventory.model.Inventory;
import com.ims.inventory.service.InventoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/company")
@Api(value = "Inventory Resource")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	/**
	 * Save Inventory
	 * 
	 * @param inventory
	 * @return
	 * @throws InventoryException
	 */
	@ApiOperation(value = "Save Inventory")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Inventory saved successfully!"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@PostMapping(value = "/inventories")
	public Inventory createInventory(@Valid @RequestBody InventoryDTO inventory, HttpServletRequest request)
			throws InventoryException {
		log.info("Inside save inventories");
		Inventory invent = new Inventory();
		invent.setName(inventory.getName());
		invent.setDescription(inventory.getDescription());
		return inventoryService.save(invent);
	}

	/**
	 * Search all Inventories
	 * 
	 * @return
	 * @throws InventoryException
	 */
	@Cacheable(value = "inventories")
	@GetMapping("/inventories")
	@ApiOperation(value = "Search all Inventories")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Searched all inventories successfully!"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	public List<Inventory> getAllInventories() throws InventoryException {
		log.info("Inside get all inventories");
		return inventoryService.findAll();
	}

	/**
	 * Get an Inventory by id
	 * 
	 * @param invId
	 * @return
	 * @throws InventoryException
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/inventories/{id}")
	@ApiOperation(value = "To get an Inventory")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Searched inventory by id successfully!"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	public ResponseEntity<Inventory> getInventoryById(@PathVariable(value = "id") Long invId)
			throws InventoryException {
		Inventory inv = inventoryService.findById(invId)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory", "id", invId));
		log.info("Inside get an inventory");
		return ResponseEntity.ok().body(inv);
	}

	/**
	 * Update an inventory by Id
	 * 
	 * @param invId
	 * @param inventory
	 * @return
	 * @throws InventoryException
	 */
	@PutMapping("/inventories/{id}")
	@ApiOperation(value = "Update Inventory")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Inventory updated successfully!"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	public ResponseEntity<Inventory> updateInventory(@PathVariable(value = "id") Long invId,
			@Valid @RequestBody InventoryDTO inventory) throws InventoryException {
		Optional<Inventory> inv = inventoryService.findById(invId);
		if (inv.isEmpty()) {
			log.error("Inventory not found for the id" + invId);
			return ResponseEntity.notFound().build();
		} else {
			Inventory invent = new Inventory();
			invent.setId(inventory.getId());
			invent.setName(inventory.getName());
			invent.setDescription(inventory.getDescription());
			log.info("Inside update inventories");
			Inventory updateInventory = inventoryService.save(invent);
			return ResponseEntity.ok().body(updateInventory);
		}
	}

	/**
	 * Delete an Inventory
	 * 
	 * @param invId
	 * @return
	 * @throws InventoryException
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/inventories/{id}")
	@ApiOperation(value = "Delete Inventory")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Inventory deleted successfully!"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	public ResponseEntity<Inventory> deleteInventory(@PathVariable(value = "id") Long invId)
			throws InventoryException {
		Inventory inv = inventoryService.findById(invId)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory", "id", invId));
		log.info("Inside delete inventories");
		log.error("Item not found for the id" + invId);
		inventoryService.deleteById(inv.getId());
		return ResponseEntity.ok().build();
	}

}
