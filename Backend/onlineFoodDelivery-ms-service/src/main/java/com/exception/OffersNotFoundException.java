package com.exception;

public class OffersNotFoundException extends RuntimeException {
	
	public OffersNotFoundException(int offerId) {
		super("Could not find the offer with id " + offerId);
	}

}
