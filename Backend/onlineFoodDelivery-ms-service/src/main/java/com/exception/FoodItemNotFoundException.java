package com.exception;

public class FoodItemNotFoundException extends RuntimeException {
	public FoodItemNotFoundException(int id) {
		super("Could not find food item with id " + id);
	}
}
