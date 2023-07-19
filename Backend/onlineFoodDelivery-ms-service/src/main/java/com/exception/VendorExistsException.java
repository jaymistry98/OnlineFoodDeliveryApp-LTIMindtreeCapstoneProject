package com.exception;

public class VendorExistsException extends RuntimeException {
	public VendorExistsException(String name, String location) {
		super("Vendor with name " + name + " and location " + location + " already exists");
	}
}
