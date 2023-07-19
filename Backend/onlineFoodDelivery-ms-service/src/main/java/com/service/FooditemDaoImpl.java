package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FoodItem;
import com.exception.FoodItemExistsException;
import com.exception.FoodItemNotFoundException;
import com.repository.FoodItemRepository;

@Service
public class FooditemDaoImpl implements FoodItemDao {
	@Autowired
	private FoodItemRepository foodItemrepo;

	//@Transactional
	@Override
	public List<FoodItem> getAllFoodItems() {
		return foodItemrepo.findAll();
	}

	@Override
	public List<FoodItem> getFoodItemsByVendorId(int vendorId) {
		return foodItemrepo.findByVendorId(vendorId);
	}
		

	@Override
	public FoodItem createFoodItem(FoodItem fooditem) {
		List<FoodItem> foodItemList = foodItemrepo.findAll();
		for(FoodItem item: foodItemList) {
			if(item.getVendorId() == fooditem.getVendorId() && item.getFoodName().equals(fooditem.getFoodName())) {
				throw new FoodItemExistsException(fooditem.getVendorId(), fooditem.getFoodName());
			}
		}
		return foodItemrepo.save(fooditem);
	}

	@Override
	public FoodItem getFoodItemByFoodId(int foodId) {
		Optional<FoodItem> foodItem = foodItemrepo.findById(foodId);
		if (foodItem.isPresent()) {
			return foodItem.get();
		}
		throw new FoodItemNotFoundException(foodId);
	}

	@Override
	public FoodItem updateFoodItem(FoodItem foodItem) {
		Optional<FoodItem> findFoodItem = foodItemrepo.findById(foodItem.getFoodId());
		if (findFoodItem.isPresent()) {
			List<FoodItem> foodItemList = foodItemrepo.findByVendorId(foodItem.getVendorId());
			for(FoodItem item: foodItemList) {
				if(item.getFoodName().equals(foodItem.getFoodName()) && item.getFoodId() != foodItem.getFoodId()) {
					throw new FoodItemExistsException(foodItem.getVendorId(), foodItem.getFoodName());
				}
			}
			return foodItemrepo.save(foodItem);
		}
		throw new FoodItemNotFoundException(foodItem.getFoodId());
	}

	@Override
	public boolean deleteFoodItemByFoodId(int foodId) {
		Optional<FoodItem> foodItem =foodItemrepo.findById(foodId);
		if(foodItem.isPresent()) {
			foodItemrepo.deleteById(foodId);
			return true;
		}
		throw new FoodItemNotFoundException(foodId);
	}
}
