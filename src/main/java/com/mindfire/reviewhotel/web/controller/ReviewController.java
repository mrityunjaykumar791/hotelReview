/**
 * 
 */
package com.mindfire.reviewhotel.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.dto.ReviewDTO;
import com.mindfire.reviewhotel.web.dto.SearchByNameDTO;
import com.mindfire.reviewhotel.web.service.ReviewService;

/**
 * @author mindfire
 *
 */
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	 @RequestMapping(value="reviewAction",method = RequestMethod.POST)
	    public ModelAndView submit(@ModelAttribute("reviewData") ReviewDTO reviewDto, Model model, HttpSession session) {
	        model.addAttribute("reviewData", new ReviewDTO());
	        model.addAttribute("searchByNameData",new SearchByNameDTO());
	        return reviewService.saveReviewDetails(reviewDto,session);
	    }
}
