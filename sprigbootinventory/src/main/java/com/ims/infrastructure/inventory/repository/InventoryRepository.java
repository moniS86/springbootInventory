package com.ims.infrastructure.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.ims.inventory.model.Inventory;
public interface InventoryRepository extends CrudRepository<Inventory, Long>{

	
}