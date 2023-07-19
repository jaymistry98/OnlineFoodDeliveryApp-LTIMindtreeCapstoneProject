package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Feedback;
import com.entity.FoodItem;
import com.entity.Offers;
import com.entity.User;
import com.entity.Vendor;
import com.service.FeedbackDao;
import com.service.FoodItemDao;
import com.service.OffersDao;
import com.service.UserDao;
import com.service.VendorDao;

@RestController
@RequestMapping("/foodDeliveryApp")
public class AppController {
	//Offer Controller
	@Autowired
	private OffersDao offersDao;
	
	@GetMapping("/allOffers")
	public List<Offers> getAllOffers(){
		return offersDao.getAllOffers();
	}
	
	@PostMapping("/createOffer")
	public Offers createOffer(@RequestBody Offers offer) {
		return offersDao.createOffer(offer);
	}
	
	@GetMapping("/getOfferById/{id}")
	public Offers getOfferById(@PathVariable int id) {
		return offersDao.getOfferById(id);
	}
	
	@PutMapping("/updateOffer")
	public Offers updateOffer(@RequestBody Offers offer) {
		return offersDao.updateOffer(offer);
	}
	
	@DeleteMapping("/deleteOfferById/{id}")
	public boolean deleteOfferById(@PathVariable int id) {
		return offersDao.deleteOfferById(id);
	}

	
	
	
	//Vendor Controller
	@Autowired
	private VendorDao vendorDao;
	
	@GetMapping("/getAllVendors")
	public List<Vendor> getAllVendors() {
		return vendorDao.getAllVendors();
	}
	
	@GetMapping("/getVendorById/{id}")
	public Vendor getVendorById(@PathVariable int id) {
		return vendorDao.getVendorById(id);
	}
	
	@GetMapping("/getVendorByUserId/{id}")
	public Vendor getVendorByUserId(@PathVariable int id) {
		return vendorDao.getVendorByUserId(id);
	}
	
	@PostMapping("/createVendor")
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorDao.createVendor(vendor);
	}
	
	@PutMapping("/updateVendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorDao.updateVendor(vendor);
	}
	
	@DeleteMapping("/deleteVendorById/{id}")
	public boolean deleteVendorById(@PathVariable int id) {
		return vendorDao.deleteVendorById(id);
	}

	
	
	
	//Login Controller
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userDao.createUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userDao.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public boolean deleteUserById(@PathVariable int id) {
		return userDao.deleteUserById(id);
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) {
		return userDao.loginUser(user);
	}

	
	
	//FoodItem Controller
	@Autowired
	private FoodItemDao foodItemDao;
	
	@GetMapping("/getAllfoodItems")
	public List<FoodItem> getAllFoodItems(){
		return foodItemDao.getAllFoodItems();
	}
	
	@PostMapping("/createFoodItems")
	public FoodItem createFoodItem(@RequestBody FoodItem foodItem) {
		return foodItemDao.createFoodItem(foodItem);
	}
	
	@GetMapping("/getFoodItemById/{id}")
	public FoodItem getFoodItemByFoodId(@PathVariable int id) {
		return foodItemDao.getFoodItemByFoodId(id);
	}
	
	@PutMapping("/updateFoodItem")
	public FoodItem updateFoodItem(@RequestBody FoodItem foodItem) {
		return foodItemDao.updateFoodItem(foodItem);
	}
	@DeleteMapping("/deleteFoodItemById/{id}")
	public boolean deleteFoodItembyId(@PathVariable int id) {
		return foodItemDao.deleteFoodItemByFoodId(id);
	}
	
	@GetMapping("/findFood/{id}")
	public List<FoodItem> findfood(@PathVariable int id){
		return foodItemDao.getFoodItemsByVendorId(id);
	}

	
	
	
	//Feedback Controller
	@Autowired
	private FeedbackDao feedbackDao;

	@GetMapping("/getAllFeedbacks")
	public List<Feedback> getAllFeedbacks(){
	  return feedbackDao.getAllFeedbacks();
	}
		
	@PostMapping("/createFeedback")
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return feedbackDao.createFeedback(feedback);
	}
	@DeleteMapping("/deleteFeedbackById/{id}")
	public boolean deleteFeedbackbyId(@PathVariable int id) {
		return feedbackDao.deleteFeedbackById(id);
	}
}
