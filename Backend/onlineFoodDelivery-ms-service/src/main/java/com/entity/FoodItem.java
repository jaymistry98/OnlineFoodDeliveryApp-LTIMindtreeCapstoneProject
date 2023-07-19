package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "food_food_items")
@Data
public class FoodItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int foodId;
	int vendorId;
	String foodName;
	String description;
	int price;

	public FoodItem() {
		super();
	}

	public FoodItem(int foodId, int vendorId, String foodName, String description, int price) {
		super();
		this.foodId = foodId;
		this.vendorId = vendorId;
		this.foodName = foodName;
		this.description = description;
		this.price = price;
	}
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodItem [foodId=" + foodId + ", vendorId=" + vendorId + ", foodName=" + foodName + ", description="
				+ description + ", price=" + price + "]";
	}
}
