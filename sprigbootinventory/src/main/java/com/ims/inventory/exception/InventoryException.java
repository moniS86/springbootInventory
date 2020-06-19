package com.ims.inventory.exception;

public class InventoryException extends Exception {

	private static final long serialVersionUID = 379642198780718919L;

	public InventoryException(String errorMessage, Throwable ex) {
		super(errorMessage, ex);
	}

}
