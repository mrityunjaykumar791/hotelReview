/**
 * 
 */
package com.mindfire.reviewhotel.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.domain.Review;
import com.mindfire.reviewhotel.web.dto.ReviewDTO;
import com.mindfire.reviewhotel.web.repository.HotelRepository;
import com.mindfire.reviewhotel.web.repository.ReviewRepository;
import com.mindfire.reviewhotel.web.repository.UserRepository;

/**
 * @author mindfire
 *
 */
@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private UserRepository userRepository;
	
	public ModelAndView saveReviewDetails(ReviewDTO reviewDto,HttpSession session){
		Review review = new Review();
		review.setReviewComment(reviewDto.getReviewComment());
		review.setRatingValue(reviewDto.getRatingValue());
		review.setUserId(userRepository.findById(reviewDto.getUserId()));
		review.setHotelId(hotelRepository.findById(reviewDto.getHotelId()));
		
		reviewRepository.save(review);
		List<Review> reviewList = reviewRepository.findByHotelId(review.getHotelId());
		Map<String,Object>  modelMap = new HashMap<String,Object>();
		modelMap.put("reviews", reviewList);
		
		modelMap.put("hotelById",review.getHotelId());
		return  new ModelAndView(Constant.HOTEL_TEMPLATE,modelMap); //"hotelTemplate"+"/"+reviewDto.getHotelId();//work not completed
	}
}
