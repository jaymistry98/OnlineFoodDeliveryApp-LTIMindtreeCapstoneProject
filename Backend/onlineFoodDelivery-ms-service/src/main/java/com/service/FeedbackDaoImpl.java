package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Feedback;
import com.exception.FeedbackNotFoundException;
import com.repository.FeedbackRepository;

@Service
public class FeedbackDaoImpl implements FeedbackDao{
	
	@Autowired
	private FeedbackRepository feedRepo;

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedRepo.findAll();
	}

	@Override
	public Feedback createFeedback(Feedback feedback) {
		return feedRepo.save(feedback);
	}

	@Override
	public boolean deleteFeedbackById(int id) {
		
		//findById returns Optional
		//isPresent returns true or false
		if(feedRepo.findById(id).isPresent()) {
			feedRepo.deleteById(id);
			return true;
		}
		
		else {
			//Send http response 
			throw new FeedbackNotFoundException(id);
			
		}
	}

}
