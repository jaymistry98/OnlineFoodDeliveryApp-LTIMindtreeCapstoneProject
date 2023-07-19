package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "food_feedback")
@Data
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	private String description;
	private int rating;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Feedback(int feedbackId, String description, int rating) {
		super();
		this.feedbackId = feedbackId;
		this.description = description;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", description=" + description + ", rating=" + rating + "]";
	}
	public Feedback() {
		super();
	}
	
	

	
	
	
	
}
