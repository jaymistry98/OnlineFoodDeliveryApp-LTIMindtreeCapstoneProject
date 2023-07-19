package com.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entity.Feedback;
import com.exception.FeedbackNotFoundException;
import com.repository.FeedbackRepository;
import com.service.FeedbackDaoImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
 class FeedbackTests {
	@Mock
	private FeedbackRepository feedbackRepo;
	
	@InjectMocks
	private FeedbackDaoImpl feedbackService;
	
	@Test
	 void createFeedbackTest() throws Exception {
		Feedback feedback1 = new Feedback(1, "Bad", 1);
		Feedback feedback2 = new Feedback(2, "Ok", 2);
		
		given(feedbackRepo.save(feedback1)).willReturn(feedback1);
		given(feedbackRepo.save(feedback2)).willReturn(feedback2);
		
		assertEquals(feedbackService.createFeedback(feedback1), feedback1);
		assertEquals(feedbackService.createFeedback(feedback2), feedback2);
	}
	
	@Test
	 void getFeedbackListTest() throws Exception {
		List<Feedback> feedbackList = new ArrayList<>();
		Feedback feedback1 = new Feedback(1, "Great", 5);
		Feedback feedback2 = new Feedback(2, "Mid", 3);
		feedbackList.add(feedback1);
		feedbackList.add(feedback2);
		
		given(feedbackRepo.findAll()).willReturn(feedbackList);
		
		assertEquals(feedbackService.getAllFeedbacks(), feedbackList);
	}
	
	@Test
	 void deleteFeedbackByIdSuccessTest() throws Exception {
		Feedback feedback2 = new Feedback(2, "Mid", 3);
		Optional<Feedback> ret = Optional.of(feedback2);
		
		given(feedbackRepo.findById(2)).willReturn(ret);
		assertTrue(feedbackService.deleteFeedbackById(2));
	}
	
	@Test
	 void deleteFeedbackByIdExceptionTest() throws Exception {
		given(feedbackRepo.findById(2)).willReturn(Optional.empty());
		
		FeedbackNotFoundException except = assertThrows(FeedbackNotFoundException.class, () -> feedbackService.deleteFeedbackById(2));
		assertTrue(except.getMessage().contentEquals("Could not find the feedback with id 2"));
	}
}
