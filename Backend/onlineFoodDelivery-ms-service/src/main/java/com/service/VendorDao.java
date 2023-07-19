package com.service;

import java.util.List;

import com.entity.Vendor;

public interface VendorDao {
	public List<Vendor> getAllVendors();
	public Vendor getVendorById(int vendorId);
	public Vendor getVendorByUserId(int userId);
	public Vendor createVendor(Vendor vendor);
	public boolean deleteVendorById(int vendorId);
	public Vendor updateVendor(Vendor vendor);
}
