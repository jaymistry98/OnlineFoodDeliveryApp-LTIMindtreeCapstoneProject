package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delegate.AppDelegate;
import com.entity.Feedback;
import com.entity.FoodItem;
import com.entity.Offers;
import com.entity.User;
import com.entity.Vendor;

@RestController
@RequestMapping("/foodDeliveryAppClient")
@CrossOrigin("*")
public class AppController {

	@Autowired
	private AppDelegate dao;

	// Offer
	@GetMapping("/getAllOffers")
	public List<Offers> getAllOffers() {
		return dao.getAllOffers();
	}

	@PostMapping("/createOffer")
	public Offers createOffer(@RequestBody Offers offer) {
		return dao.createOffer(offer);
	}

	@GetMapping("/getOfferById/{id}")
	public Offers getOfferById(@PathVariable int id) {
		return dao.getOfferById(id);
	}

	@PutMapping("/updateOffer")
	public Offers updateOffer(@RequestBody Offers offer) {
		return dao.updateOffer(offer);
	}

	@DeleteMapping("/deleteOfferById/{id}")
	public boolean deleteOfferById(@PathVariable int id) {
		return dao.deleteOfferById(id);
	}

	
	
	// User
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return dao.createUser(user);
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return dao.updateUser(user);
	}

	@DeleteMapping("/deleteUserById/{id}")
	public boolean deleteUserById(@PathVariable int id) {
		return dao.deleteUserById(id);
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) {
		return dao.loginUser(user);
	}

	
	
	// Vendor
	@GetMapping("/getAllVendors")
	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

	@GetMapping("/getVendorById/{id}")
	public Vendor getVendorById(@PathVariable int id) {
		return dao.getVendorById(id);
	}
	
	@GetMapping("/getVendorByUserId/{id}")
	public Vendor getVendorByUserId(@PathVariable int id) {
		return dao.getVendorByUserId(id);
	}

	@PostMapping("/createVendor")
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return dao.createVendor(vendor);
	}

	@PutMapping("/updateVendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return dao.updateVendor(vendor);
	}

	@DeleteMapping("/deleteVendorById/{id}")
	public boolean deleteVendorById(@PathVariable int id) {
		return dao.deleteVendorById(id);
	}

	
	
	// FoodItem
	@GetMapping("/getAllFoodItems")
	public List<FoodItem> getAllFoodItems() {
		return dao.getAllFoodItems();
	}

	@PostMapping("/createFoodItems")
	public FoodItem createFoodItem(@RequestBody FoodItem foodItem) {
		return dao.createFoodItem(foodItem);
	}

	@GetMapping("/getFoodItemById/{id}")
	public FoodItem getFoodItemByFoodId(@PathVariable int id) {
		return dao.getFoodItemByFoodId(id);
	}

	@PutMapping("/updateFoodItem")
	public FoodItem updateFoodItem(@RequestBody FoodItem fooditem) {
		return dao.updateFoodItem(fooditem);
	}

	@DeleteMapping("/deleteFoodItemById/{id}")
	public boolean deleteFoodItemById(@PathVariable int id) {
		return dao.deleteFoodItemById(id);
	}

	@GetMapping("/findFood/{id}")
	public List<FoodItem> findFood(@PathVariable int id) {
		return dao.findFood(id);
	}

	
	
	// Feedback
	@GetMapping("/getAllFeedbacks")
	public List<Feedback> getAllFeedbacks() {
		return dao.getAllFeedbacks();
	}

	@PostMapping("/createFeedback")
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return dao.createFeedback(feedback);
	}

	@DeleteMapping("/deleteFeedbackById/{id}")
	public boolean deleteFeedbackById(@PathVariable int id) {
		return dao.deleteFeedbackById(id);
	}

}
