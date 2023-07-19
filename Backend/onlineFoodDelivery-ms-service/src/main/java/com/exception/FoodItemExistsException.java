package com.exception;

public class FoodItemExistsException extends RuntimeException {
	public FoodItemExistsException(int vendorId, String foodName) {
		super("Item " + foodName + " is already in the menu of vendor with id " + vendorId);
	}
}
