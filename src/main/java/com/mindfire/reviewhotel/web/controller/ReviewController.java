/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.dto.ReviewDTO;
import com.mindfire.reviewhotel.web.service.ReviewService;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 */
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	/**
	 * Request mapping with reviewAction Value To Save the review Details.
	 * 
	 * @see ReviewDTO
	 * @param reviewDto
	 * @param model
	 * @return HOTEL_TEMPLATE
	 */
	 @RequestMapping(value="reviewAction",method = RequestMethod.POST)
	    public ModelAndView submit(@ModelAttribute("reviewData") ReviewDTO reviewDto, Model model) {
//	        model.addAttribute("reviewData", new ReviewDTO());
//	        model.addAttribute("searchByNameData",new SearchByNameDTO());
	        return reviewService.saveReviewDetails(reviewDto,model);
	    }
	 
	 /**
	  * This Controller map the request based on url and transfer the control to the service for searching review details.
	  * @param reviewDto
	  * @param model
	  * @param reviewId
	  * @return ModelAndView object
	  */
	 @RequestMapping(value="hotelTemplateAfterDeleteComment/{reviewId}", method=RequestMethod.GET)
	    public ModelAndView deleteComment(@ModelAttribute("reviewData") ReviewDTO reviewDto, Model model,@PathVariable("reviewId") Long reviewId) {
	    	model.addAttribute("reviewData", new ReviewDTO());
	        return reviewService.searchReviewDetail(reviewId);
	    }
}
