package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{
	//Delete Food Item by foreign key Vendor ID
	int deleteByVendorId(int vendorId);
	List<FoodItem> findByVendorId(int vendorId);
}
