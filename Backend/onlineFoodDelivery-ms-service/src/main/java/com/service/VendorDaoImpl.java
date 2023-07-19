package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Vendor;
import com.exception.VendorExistsException;
import com.exception.VendorNotFoundException;
import com.repository.FoodItemRepository;
import com.repository.UserRepository;
import com.repository.VendorRepository;

@Service
public class VendorDaoImpl implements VendorDao {
	@Autowired
	private VendorRepository vendorRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private FoodItemRepository foodItemRepo;

	@Override
	public List<Vendor> getAllVendors() {
		return vendorRepo.findAll();
	}

	@Override
	public Vendor getVendorById(int vendorId) {
		Optional<Vendor> vendor = vendorRepo.findById(vendorId);
		if(vendor.isPresent()) {
			return vendor.get();
		}
		throw new VendorNotFoundException(vendorId);
	}
	
	@Override
	public Vendor getVendorByUserId(int userId) {
		List<Vendor> vendorList = vendorRepo.findByUserId(userId);
		if(!vendorList.isEmpty()) {
			return vendorList.get(0);
		}
		throw new VendorNotFoundException(0);
	}

	@Override
	public Vendor createVendor(Vendor vendor) {
		List<Vendor> vendorList = vendorRepo.findAll();
		for(Vendor v : vendorList) {
			if(v.getVendorName().equals(vendor.getVendorName()) && v.getVendorLocation().equals(vendor.getVendorLocation())) {
				throw new VendorExistsException(vendor.getVendorName(), vendor.getVendorLocation());
			}
		}
		return vendorRepo.save(vendor);
	}

	@Override
	@Transactional
	public boolean deleteVendorById(int vendorId) {
		Optional<Vendor> vendor = vendorRepo.findById(vendorId);
		if(vendor.isPresent()) {
			vendorRepo.deleteById(vendorId);
			userRepo.deleteById(vendor.get().getUserId());
			foodItemRepo.deleteByVendorId(vendorId);
			return true;
		}
		throw new VendorNotFoundException(vendorId);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		Optional<Vendor> findVendor = vendorRepo.findById(vendor.getVendorId());
		if(findVendor.isPresent()) {
			Vendor vendorFound = findVendor.get();
			List<Vendor> vendorList = vendorRepo.findAll();
			for(Vendor v: vendorList) {
				if(v.getVendorName().equals(vendorFound.getVendorName()) && v.getVendorLocation().equals(vendor.getVendorLocation())) {
					throw new VendorExistsException(vendorFound.getVendorName(), vendor.getVendorLocation());
				}
			}
			vendorFound.setVendorLocation(vendor.getVendorLocation());
			vendorRepo.save(vendorFound);
			return vendorFound;
		}
		throw new VendorNotFoundException(vendor.getVendorId());
	}

}
