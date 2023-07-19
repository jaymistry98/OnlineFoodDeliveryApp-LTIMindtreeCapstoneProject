package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Offers;
import com.exception.OffersNotFoundException;
import com.repository.OffersRepository;

@Service
public class OffersDaoImpl implements OffersDao {

	// OFFER
	@Autowired
	private OffersRepository offerRepo;

	// OFFER
	@Override
	public List<Offers> getAllOffers() {
		return offerRepo.findAll();
	}

	@Override
	public Offers createOffer(Offers offer) {
		return offerRepo.save(offer);
	}

	@Override
	public Offers getOfferById(int id) {
		Optional<Offers> offer = offerRepo.findById(id);
		if (offer.isPresent()) {
			return offer.get();
		}
		throw new OffersNotFoundException(id);
	}

	@Override
	public Offers updateOffer(Offers offer) {
		if (offerRepo.findById(offer.getOfferId()).isPresent()) {
			return offerRepo.save(offer);

		}
		throw new OffersNotFoundException(offer.getOfferId());
	}
	 
	@Override
	public boolean deleteOfferById(int offerId) {
		if (offerRepo.findById(offerId).isPresent()) {
			offerRepo.deleteById(offerId);
			return true;
		}
		throw new OffersNotFoundException(offerId);
	}
}
