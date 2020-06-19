package com.ims.infrastructure.inventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ims.inventory.model.Inventory;

@Repository
public class InventoryDAO implements InventoryRepository {

	@Autowired
	InventoryRepository inventoryRepository;
	/* Save Inventory */

	@SuppressWarnings("unchecked")
	public Inventory save(Inventory inventory) {

		return inventoryRepository.save(inventory);

	}

	/* Search all Inventories */

	public List<Inventory> findAll() {

		return (List<Inventory>) inventoryRepository.findAll();
	}

	/* Get an Inventory */

	public Optional<Inventory> findById(Long invId) {

		return inventoryRepository.findById(invId);

	}

	/* Delete Inventory */

	public void deleteById(Long invId) {
		inventoryRepository.deleteById(invId);
	}

	@Override
	public <S extends Inventory> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}

	@Override
	public Iterable<Inventory> findAllById(Iterable<Long> ids) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteAll(Iterable<? extends Inventory> entities) {
		/*
		 * Unimplemented methods
		 */

	}

	@Override
	public void deleteAll() {
		/*
		 * Unimplemented methods
		 */
	}

	@Override
	public void delete(Inventory entity) {
		/*
		 * Unimplemented methods
		 */
	}

}