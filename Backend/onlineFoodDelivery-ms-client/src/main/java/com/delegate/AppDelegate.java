package com.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Feedback;
import com.entity.FoodItem;
import com.entity.Offers;
import com.entity.User;
import com.entity.Vendor;

@Service
public class AppDelegate {
	@LoadBalanced
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	};

	@Autowired
	public RestTemplate template;

	// OFFER

	public List<Offers> getAllOffers() {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/allOffers",
				HttpMethod.GET, null, List.class).getBody();
	}

	public Offers createOffer(Offers offer) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/createOffer",
				HttpMethod.POST, new HttpEntity<Offers>(offer), Offers.class).getBody();
	}

	public Offers getOfferById(int id) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/getOfferById/" + id,
				HttpMethod.GET, null, Offers.class).getBody();
	}

	public Offers updateOffer(Offers offer) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/updateOffer",
				HttpMethod.PUT, new HttpEntity<Offers>(offer), Offers.class).getBody();

	}

	public boolean deleteOfferById(int id) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/deleteOfferById/" + id,
				HttpMethod.DELETE, null, boolean.class).getBody();

	}

	// USER

	public List<User> getAllUsers() {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/getAllUsers",
				HttpMethod.GET, null, List.class).getBody();

	}

	public User createUser(User user) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/createUser",
				HttpMethod.POST, new HttpEntity<User>(user), User.class).getBody();

	}

	public User updateUser(User user) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/updateUser", HttpMethod.PUT,
				new HttpEntity<User>(user), User.class).getBody();

	}

	public boolean deleteUserById(int id) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/deleteUser/" + id,
				HttpMethod.DELETE, null, boolean.class).getBody();
		
	}

	public User loginUser(User user) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/login", HttpMethod.POST,
				new HttpEntity<User>(user), User.class).getBody();
	}

	// Vendor

	public List<Vendor> getAllVendors() {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/getAllVendors",
				HttpMethod.GET, null, List.class).getBody();
	}

	public Vendor getVendorById(int id) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/getVendorById/" + id,
				HttpMethod.GET, null, Vendor.class).getBody();
	}
	
	public Vendor getVendorByUserId(int userId) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/getVendorByUserId/" + userId,
				HttpMethod.GET, null, Vendor.class).getBody();
	}

	public Vendor createVendor(Vendor vendor) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/createVendor",
				HttpMethod.POST, new HttpEntity<Vendor>(vendor), Vendor.class).getBody();

	}

	public Vendor updateVendor(Vendor vendor) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/updateVendor",
				HttpMethod.PUT, new HttpEntity<Vendor>(vendor), Vendor.class).getBody();

		
	}

	public boolean deleteVendorById(int id) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/deleteVendorById/" + id,
				HttpMethod.DELETE, null, boolean.class).getBody();

	}

	// FoodItem

	public List<FoodItem> getAllFoodItems() {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/getAllfoodItems",
				HttpMethod.GET, null, List.class).getBody();
		
	}

	public FoodItem createFoodItem(FoodItem foodItem) {
		return  template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/createFoodItems",
				HttpMethod.POST, new HttpEntity<FoodItem>(foodItem), FoodItem.class).getBody();

		
	}

	public FoodItem getFoodItemByFoodId(int id) {
		return  template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/getFoodItemById/" + id,
				HttpMethod.GET, null, FoodItem.class).getBody();
		
	}

	public FoodItem updateFoodItem(FoodItem fooditem) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/updateFoodItem",
				HttpMethod.PUT, new HttpEntity<FoodItem>(fooditem), FoodItem.class).getBody();

		
	}

	public boolean deleteFoodItemById(int id) {
		return template
				.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/deleteFoodItemById/" + id,
						HttpMethod.DELETE, null, boolean.class)
				.getBody();

		
	}

	public List<FoodItem> findFood(int id) {
		return  template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/findFood/" + id,
				HttpMethod.GET, null, List.class).getBody();
		
	}

	// Feedback

	public List<Feedback> getAllFeedbacks() {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/getAllFeedbacks",
				HttpMethod.GET, null, List.class).getBody();
		
	}

	public Feedback createFeedback(Feedback feedback) {
		return template.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/createFeedback",
				HttpMethod.POST, new HttpEntity<Feedback>(feedback), Feedback.class).getBody();

		
	}

	public boolean deleteFeedbackById(int id) {
		return template
				.exchange("http://onlinefooddelivery-ms-service/foodDeliveryApp/deleteFeedbackById/" + id,
						HttpMethod.DELETE, null, boolean.class)
				.getBody();

		
	}

}
