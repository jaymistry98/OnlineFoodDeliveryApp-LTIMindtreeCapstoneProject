package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entity.FoodItem;
import com.exception.FoodItemExistsException;
import com.exception.FoodItemNotFoundException;
import com.exception.VendorExistsException;
import com.repository.FoodItemRepository;
import com.service.FooditemDaoImpl;

@ExtendWith(MockitoExtension.class)
 class FoodItemTests {
	@Mock
	private FoodItemRepository foodItemRepo;

	@InjectMocks
	private FooditemDaoImpl foodService;

	@Test
	 void getFoodItemListTest() {
		List<FoodItem> foodItemList = new ArrayList<>();
		FoodItem foodItem1 = (new FoodItem(1, 2, "pizza", "pizza with cheese", 20));
		FoodItem foodItem2 = (new FoodItem(1, 2, "burger", "burger with cheese", 10));
		foodItemList.add(foodItem1);
		foodItemList.add(foodItem2);

		given(foodItemRepo.findAll()).willReturn(foodItemList);

		assertEquals(foodService.getAllFoodItems(), foodItemList);
	}
	
	@Test
	 void createFoodItemSuccessTest() throws Exception {
		FoodItem foodItem1 = (new FoodItem(1, 2, "pizza", "pizza with cheese", 20));
		FoodItem foodItem2 = (new FoodItem(1, 2, "burger", "burger with cheese", 10));

		given(foodItemRepo.save(foodItem1)).willReturn(foodItem1);
		given(foodItemRepo.save(foodItem2)).willReturn(foodItem2);

		assertEquals(foodService.createFoodItem(foodItem1), foodItem1);
		assertEquals(foodService.createFoodItem(foodItem2), foodItem2);
	}

	@Test
	 void createFoodItemExceptionTest() throws Exception {
		List<FoodItem> foodItemList = new ArrayList<>();
		FoodItem foodItem1 = (new FoodItem(1, 2, "pizza", "pizza with cheese", 20));
		FoodItem foodItem2 = (new FoodItem(1, 2, "burger", "burger with cheese", 10));
		foodItemList.add(foodItem1);
		foodItemList.add(foodItem2);

		given(foodItemRepo.findAll()).willReturn(foodItemList);
		
		FoodItem foodItem3 = (new FoodItem(3, 2, "burger", "burger with cheese, lettuce, and tomatoes", 15));

		FoodItemExistsException except = assertThrows(FoodItemExistsException.class,
				() -> foodService.createFoodItem(foodItem3));
		assertTrue(except.getMessage().contentEquals("Item burger is already in the menu of vendor with id 2"));
	}

	@Test
	 void getFoodItemsByVendorId() throws Exception {
		List<FoodItem> foodItemList = new ArrayList<>();
		FoodItem foodItem1 = (new FoodItem(1, 2, "pizza", "pizza with chez", 20));
		FoodItem foodItem2 = (new FoodItem(2, 2, "burger", "burger description", 10));
		foodItemList.add(foodItem1);
		foodItemList.add(foodItem2);

		given(foodItemRepo.findByVendorId(2)).willReturn(foodItemList);

		assertEquals(foodService.getFoodItemsByVendorId(2), foodItemList);
	}

	@Test
	 void getFoodItemsByFoodId() throws Exception {
		FoodItem foodItem1 = (new FoodItem(1, 2, "pizza", "pizza with cheese", 20));

		given(foodItemRepo.findById(1)).willReturn(Optional.of(foodItem1));

		assertEquals(foodService.getFoodItemByFoodId(1), foodItem1);
	}

	@Test
	 void getFoodItemsByFoodIdExceptionTest() throws Exception {
		given(foodItemRepo.findById(1)).willReturn(Optional.empty());

		FoodItemNotFoundException except = assertThrows(FoodItemNotFoundException.class,
				() -> foodService.deleteFoodItemByFoodId(1));
		assertTrue(except.getMessage().contentEquals("Could not find food item with id 1"));
	}

	@Test
	 void updateFoodItemSuccessTest() throws Exception {
		List<FoodItem> foodItemList = new ArrayList<>();
		FoodItem foodItem1 = (new FoodItem(1, 1, "pizza", "pizza with cheese", 20));
		FoodItem foodItem2 = (new FoodItem(2, 2, "burger", "burger with cheese", 10));
		foodItemList.add(foodItem1);
		foodItemList.add(foodItem2);

		List<FoodItem> foodItem2List = new ArrayList<>();
		foodItem2List.add(foodItem2);

		given(foodItemRepo.findById(2)).willReturn(Optional.of(foodItem1));
		given(foodItemRepo.findByVendorId(2)).willReturn(foodItem2List);

		FoodItem foodItem3 = new FoodItem(2, 2, "pizza", "pizza with no cheese", 15);

		given(foodItemRepo.save(foodItem3)).willReturn(foodItem3);

		assertEquals(foodService.updateFoodItem(foodItem3), foodItem3);
	}

	@Test
	 void updateFoodItemExistsException() throws Exception {
		List<FoodItem> foodItemList = new ArrayList<>();
		FoodItem foodItem1 = (new FoodItem(1, 1, "pizza", "pizza with cheese", 20));
		FoodItem foodItem2 = (new FoodItem(2, 1, "burger", "burger with cheese", 10));
		foodItemList.add(foodItem1);
		foodItemList.add(foodItem2);

		given(foodItemRepo.findById(2)).willReturn(Optional.of(foodItem2));
		given(foodItemRepo.findByVendorId(1)).willReturn(foodItemList);
		
		FoodItem foodItem3 = (new FoodItem(2, 1, "pizza", "pepporoni pizza", 25));

		FoodItemExistsException except = assertThrows(FoodItemExistsException.class,
				() -> foodService.updateFoodItem(foodItem3));
		assertTrue(except.getMessage().contentEquals("Item pizza is already in the menu of vendor with id 1"));
	}

	@Test
	 void updateFoodItemNotFoundExceptionTest() throws Exception {
		given(foodItemRepo.findById(1)).willReturn(Optional.empty());

		FoodItemNotFoundException except = assertThrows(FoodItemNotFoundException.class,
				() -> foodService.deleteFoodItemByFoodId(1));
		assertTrue(except.getMessage().contentEquals("Could not find food item with id 1"));
	}

	@Test
	 void deleteFoodItemByFoodIdSuccessTest() throws Exception {
		FoodItem foodItem = new FoodItem(1, 2, "pizza", "pizza with chez", 20);

		given(foodItemRepo.findById(1)).willReturn(Optional.of(foodItem));
		assertTrue(foodService.deleteFoodItemByFoodId(1));
	}

	@Test
	 void deleteFoodItemByFoodIdExceptionTest() throws Exception {
		given(foodItemRepo.findById(3)).willReturn(Optional.empty());

		FoodItemNotFoundException except = assertThrows(FoodItemNotFoundException.class,
				() -> foodService.deleteFoodItemByFoodId(3));
		assertTrue(except.getMessage().contentEquals("Could not find food item with id 3"));
	}

}