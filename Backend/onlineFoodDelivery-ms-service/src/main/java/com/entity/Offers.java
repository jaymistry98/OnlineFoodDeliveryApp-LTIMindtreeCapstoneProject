package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;


@Entity
@Table(name = "food_offers")
@Data
 
public class Offers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int offerId;
	private int discount;
	private String offerDescription;
	
	public Offers(int offerId, int discount, String offerDescription) {
		super();
		this.offerId = offerId;
		this.discount = discount;
		this.offerDescription = offerDescription;
	}
	
	public Offers() {
		super();

	}
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getOfferDescription() {
		return offerDescription;
	}
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	@Override
	public String toString() {
		return "Offers [offerId=" + offerId + ", discount=" + discount + ", offerDescription=" + offerDescription + "]";
	}
	
	
	
	
}
