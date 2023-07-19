package com.service;

import java.util.List;

import com.entity.FoodItem;

public interface FoodItemDao{
	public List<FoodItem>getAllFoodItems();
	public List<FoodItem> getFoodItemsByVendorId(int vendorId);
	public FoodItem createFoodItem(FoodItem fooditem);
	public FoodItem getFoodItemByFoodId(int foodId);
	public FoodItem updateFoodItem(FoodItem foodItem);
	public boolean deleteFoodItemByFoodId(int foodId);
}
