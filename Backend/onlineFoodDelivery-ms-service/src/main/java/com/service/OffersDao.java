package com.service;

import java.util.List;

import com.entity.Offers;

public interface OffersDao {

	// OFFERS
	public List<Offers> getAllOffers();

	public Offers createOffer(Offers offer);

	public Offers getOfferById(int id);

	public Offers updateOffer(Offers offer);
	
	public boolean deleteOfferById(int offerId);

}
