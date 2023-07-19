package com.entity;

public class Feedback {
	
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
