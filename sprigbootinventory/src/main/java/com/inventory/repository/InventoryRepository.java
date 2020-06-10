package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.Inventory;
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	//Redis
//	void delete(String id);
	
}