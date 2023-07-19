package com.exception;

public class VendorNotFoundException extends RuntimeException {
	public VendorNotFoundException(int vendorId) {
		super("Could not find vendor with id " + vendorId);
	}
}
