package com.inventory.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.inventory.model.Inventory;
import com.inventory.repository.InventoryRepository;

@Service
public class InventoryDAO  {
	private RedisTemplate<String, Inventory> redisTemplate;

	private HashOperations hashOperations;

	@Autowired
	InventoryRepository inventoryRepository;

	public InventoryDAO(RedisTemplate<String, Inventory> redisTemplate) {
		this.redisTemplate = redisTemplate;

		hashOperations = redisTemplate.opsForHash();
	}
	/* Save Inventory */

	@SuppressWarnings("unchecked")
	public Inventory save(Inventory inventory) {

		return inventoryRepository.save(inventory);

	}
	/*
	 * @Override public void save(Inventory inventory) {
	 * hashOperations.put("INVENTORY", inventory.getId(), inventory); }
	 */

	/* Search all Inventories */

	@SuppressWarnings("unchecked")
	public List<Inventory> findAll() {

		 return inventoryRepository.findAll();
		//return (List<Inventory>) hashOperations.entries("INVENTORY");
	}

	/* Get an Inventory */

	public Inventory getOne(Long invId) {

		return inventoryRepository.getOne(invId);

	}

	/* Delete Inventory */

	public void delete(Inventory inventory) {
		inventoryRepository.delete(inventory);
	}


}