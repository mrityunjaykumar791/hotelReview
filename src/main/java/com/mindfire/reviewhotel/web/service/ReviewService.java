/*
 * Copyright (c) Mindfire Solutions.
 */
package com.mindfire.reviewhotel.web.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.domain.Review;
import com.mindfire.reviewhotel.web.dto.ReviewDTO;
import com.mindfire.reviewhotel.web.repository.HotelRepository;
import com.mindfire.reviewhotel.web.repository.ReviewRepository;
import com.mindfire.reviewhotel.web.repository.UserRepository;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 *        Service class for Review related Operations
 */
@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private UserRepository userRepository;

	/**
	 * This method is used for saving the review Details and finding average rating for the hotel.
	 * 
	 * @param reviewDto
	 * @param model
	 * @return ModelAndView object
	 */
	public ModelAndView saveReviewDetails(ReviewDTO reviewDto, Model model) {
		int averageRating = 0;
		Review review = new Review();
		review.setReviewComment(reviewDto.getReviewComment());
		review.setRatingValue(reviewDto.getRatingValue());
		review.setUserId(userRepository.findById(reviewDto.getUserId()));
		review.setHotelId(hotelRepository.findById(reviewDto.getHotelId()));
		reviewRepository.save(review);

		List<Review> reviewList = reviewRepository.findByHotelIdOrderByReviewDateDesc(review.getHotelId());
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Iterator<Review> iterator = reviewList.iterator();
		while (iterator.hasNext()) {
			averageRating += (iterator.next()).getRatingValue();
		}		
		
		averageRating /=reviewList.size();
		modelMap.put("averageRating", averageRating);
		modelMap.put("totalComment", reviewList.size());
		modelMap.put("reviews", reviewList);
		modelMap.put("hotelById", review.getHotelId());
		return new ModelAndView(Constant.HOTEL_TEMPLATE, modelMap);
	}
	
	/**
	 * This Method is used for searching the review details based on their id and delete that review
	 * and finding average rating for updated table.
	 * 
	 * @param reviewId
	 * @return ModelAndView object
	 */
	public ModelAndView searchReviewDetail(Long reviewId){
		int averageRating = 0;
		Review review = reviewRepository.findById(reviewId);
		reviewRepository.delete(review);
		List<Review> reviewList = reviewRepository.findByHotelIdOrderByReviewDateDesc(review.getHotelId());
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		Iterator<Review> iterator = reviewList.iterator();
		while (iterator.hasNext()) {
			averageRating += (iterator.next()).getRatingValue();
		}		
		
		averageRating /=reviewList.size();
		modelMap.put("averageRating", averageRating);
		modelMap.put("totalComment", reviewList.size());
		modelMap.put("reviews", reviewList);
		modelMap.put("hotelById", review.getHotelId());
		return new ModelAndView(Constant.HOTEL_TEMPLATE, modelMap);
	}
}
