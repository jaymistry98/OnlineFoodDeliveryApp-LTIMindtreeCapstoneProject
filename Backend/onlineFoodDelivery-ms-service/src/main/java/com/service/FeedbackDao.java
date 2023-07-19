package com.service;

import java.util.List;

import com.entity.Feedback;

public interface FeedbackDao {
	
	public List<Feedback> getAllFeedbacks();
	public Feedback createFeedback(Feedback feedback);
	public boolean deleteFeedbackById(int id);


}
