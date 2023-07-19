package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entity.Vendor;
import com.exception.VendorExistsException;
import com.exception.VendorNotFoundAdvice;
import com.exception.VendorNotFoundException;
import com.repository.FoodItemRepository;
import com.repository.UserRepository;
import com.repository.VendorRepository;
import com.service.UserDaoImpl;
import com.service.VendorDaoImpl;

@ExtendWith(MockitoExtension.class)
 class VendorTests {
	@Mock
	private VendorRepository vendorRepo;
	
	@Mock
	private UserRepository userRepo;
	
	@Mock
	private FoodItemRepository foodRepo;
	
	@InjectMocks
	private VendorDaoImpl vendorService;
	
	@Test
	 void createVendorExceptionTest() throws Exception {
		List<Vendor> vendorList = new ArrayList<>();
		Vendor vendor1 = new Vendor(1, 1, "Mcdonalds", "Long Beach");
		Vendor vendor2 = new Vendor(2, 2, "Mcdonalds", "Long Beach");
		vendorList.add(vendor1);
		
		given(vendorRepo.findAll()).willReturn(vendorList);
		
		VendorExistsException except = assertThrows(VendorExistsException.class, () -> vendorService.createVendor(vendor2));
		assertTrue(except.getMessage().contentEquals("Vendor with name Mcdonalds and location Long Beach already exists"));
	}
	
	@Test
	 void createVendorSuccessTest() throws Exception {
		List<Vendor> vendorList = new ArrayList<>();
		Vendor vendor1 = new Vendor(1, 1, "Mcdonalds", "Long Beach");
		Vendor vendor2 = new Vendor(2, 2, "In-n-out", "Fremont");
		vendorList.add(vendor1);
		
		given(vendorRepo.save(vendor1)).willReturn(vendor1);
		assertEquals(vendorService.createVendor(vendor1), vendor1);
		
		given(vendorRepo.findAll()).willReturn(vendorList);
		given(vendorRepo.save(vendor2)).willReturn(vendor2);
		assertEquals(vendorService.createVendor(vendor2), vendor2);
	}
	
	@Test
	 void getVendorListTest() throws Exception {
		List<Vendor> vendorList = new ArrayList<>();
		Vendor vendor1 = new Vendor(1, 1, "Jack in the Box", "Sacramento");
		Vendor vendor2 = new Vendor(2, 2, "Breakfast Republic", "Irvine");
		vendorList.add(vendor1);
		vendorList.add(vendor2);
		
		given(vendorRepo.findAll()).willReturn(vendorList);
		
		assertEquals(vendorService.getAllVendors(), vendorList);
	}
	
	@Test
	 void getVendorByIdSuccessTest() throws Exception {
		Vendor vendor1 = new Vendor(1, 1, "Wendys", "Phoenix");
		
		given(vendorRepo.findById(1)).willReturn(Optional.of(vendor1));
		
		assertEquals(vendorService.getVendorById(1), vendor1);
	}
	
	@Test
	 void getVendorByIdExceptionTest() throws Exception {
		given(vendorRepo.findById(1)).willReturn(Optional.empty());
		
		VendorNotFoundException except = assertThrows(VendorNotFoundException.class, () -> vendorService.getVendorById(1));
		assertTrue(except.getMessage().contentEquals("Could not find vendor with id 1"));
	}
	
	@Test
	 void getVendorByUserIdSuccessTest() throws Exception {
		List<Vendor> vendorList = new ArrayList<>();
		Vendor vendor1 = new Vendor(1, 1, "Jack in the Box", "Sacramento");
		vendorList.add(vendor1);
		
		given(vendorRepo.findByUserId(1)).willReturn(vendorList);
		assertEquals(vendorService.getVendorByUserId(1), vendor1);
	}
	
	@Test
	 void getVendorByUserIdExceptionTest() throws Exception {
		List<Vendor> vendorList = new ArrayList<>();
		given(vendorRepo.findByUserId(1)).willReturn(vendorList);
		
		VendorNotFoundException except = assertThrows(VendorNotFoundException.class, () -> vendorService.getVendorByUserId(1));
		assertTrue(except.getMessage().contentEquals("Could not find vendor with id 0"));
	}
	
	@Test
	 void deleteVendorByIdSuccessTest() throws Exception {
		Vendor vendor1 = new Vendor(1, 1, "Sonic", "Seattle");
		
		given(vendorRepo.findById(1)).willReturn(Optional.of(vendor1));
		doNothing().when(userRepo).deleteById(1);
		given(foodRepo.deleteByVendorId(1)).willReturn(1);
		
		assertTrue(vendorService.deleteVendorById(1));
	}
	
	@Test
	 void deleteVendorByIdExceptionTest() throws Exception {
		given(vendorRepo.findById(1)).willReturn(Optional.empty());
		
		VendorNotFoundException except = assertThrows(VendorNotFoundException.class, () -> vendorService.getVendorById(1));
		assertTrue(except.getMessage().contentEquals("Could not find vendor with id 1"));
	}
	
	@Test
	 void updateVendorVendorExistsExceptionTest() throws Exception {
		List<Vendor> vendorList = new ArrayList<>();
		Vendor vendor1 = new Vendor(1, 1, "Jack in the Box", "Sacramento");
		Vendor vendor2 = new Vendor(2, 2, "Jack in the Box", "Irvine");
		vendorList.add(vendor1);
		vendorList.add(vendor2);
		
		given(vendorRepo.findById(1)).willReturn(Optional.of(vendor1));
		given(vendorRepo.findAll()).willReturn(vendorList);
		
		Vendor vendor3 = new Vendor(1, 5, "Jack in the Box", "Irvine");
		VendorExistsException except = assertThrows(VendorExistsException.class, () -> vendorService.updateVendor(vendor3));
		assertTrue(except.getMessage().contentEquals("Vendor with name Jack in the Box and location Irvine already exists"));
	}
	
	@Test
	 void updateVendorVendorNotFoundExceptionTest() throws Exception {
		Vendor vendor1 = new Vendor(1, 1, "Jack in the Box", "Sacramento");
		
		given(vendorRepo.findById(1)).willReturn(Optional.empty());
		
		VendorNotFoundException except = assertThrows(VendorNotFoundException.class, () -> vendorService.updateVendor(vendor1));
		assertTrue(except.getMessage().contentEquals("Could not find vendor with id 1"));
	}
	
	@Test
	 void updateVendorSuccessTest() throws Exception {
		List<Vendor> vendorList = new ArrayList<>();
		Vendor vendor1 = new Vendor(1, 1, "Jack in the Box", "Sacramento");
		Vendor vendor2 = new Vendor(2, 2, "Jack in the Box", "Irvine");
		vendorList.add(vendor1);
		vendorList.add(vendor2);
		
		given(vendorRepo.findById(1)).willReturn(Optional.of(vendor1));
		given(vendorRepo.findAll()).willReturn(vendorList);
		
		Vendor vendor3 = new Vendor(1, 5, "Jack", "Phoenix");
		assertEquals(vendorService.updateVendor(vendor3), vendor1);
		assertEquals(1, vendor1.getUserId());
		assertEquals(1, vendor1.getVendorId());
		assertEquals("Jack in the Box", vendor1.getVendorName());
		assertEquals("Phoenix", vendor1.getVendorLocation());
	}
}
