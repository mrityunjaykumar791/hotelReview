/**
 * 
 */
package com.mindfire.reviewhotel.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.domain.Hotel;
import com.mindfire.reviewhotel.web.domain.Review;
import com.mindfire.reviewhotel.web.dto.HotelDTO;
import com.mindfire.reviewhotel.web.dto.SearchDTO;
import com.mindfire.reviewhotel.web.repository.HotelRepository;
import com.mindfire.reviewhotel.web.repository.ReviewRepository;

/**
 * @author mindfire
 *
 */
@Service
public class HotelService {

	@Autowired
	public HotelRepository hotelRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	public String saveHotelDetails(HotelDTO hotelDto, Model model){
		
		Hotel newHotel = new Hotel();
		
		newHotel.setHotelName(hotelDto.getHotelName());
		newHotel.setHotelWebsite(hotelDto.getHotelWebsite());
		newHotel.setHotelLocation(hotelDto.getHotelLocation());
		newHotel.setHotelDescription(hotelDto.getHotelDescription());
		newHotel.setHotelCategory(hotelDto.getHotelCategory());
		newHotel.setHotelImage(hotelDto.getHotelImage());
		
		Hotel createdHotel = hotelRepository.save(newHotel);
		
		if(createdHotel.equals(null)){
			model.addAttribute("status","Hotel Not registred");
			return Constant.HOTEL_PAGE;
		}else{
			model.addAttribute("status","Hotel registred");
			return Constant.HOTEL_PAGE;
		}
	}
	
	public ModelAndView searchHotelDetails(SearchDTO searchDto, Model model){
		List<Hotel> hotelList = hotelRepository.findByHotelLocationIgnoreCaseContaining(searchDto.getHotelLocation());
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		modelMap.put("hotels", hotelList);
		return new ModelAndView(Constant.SEARCH_BY_LOCATION, modelMap);
		
	}
	
	
	public ModelAndView searchByCategory(String hotelCategory){
		List<Hotel> hotelCategoryList = hotelRepository.findByHotelCategoryIgnoreCaseContaining(hotelCategory);
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("categoryHotels", hotelCategoryList);
		
		return new ModelAndView(Constant.SEARCH_BY_CATEGORY,modelMap);
	}
	
	public ModelAndView searchHotelDetailById(Long hotelId){
		Hotel hotel = hotelRepository.findById(hotelId);
		List<Review> reviewList = reviewRepository.findByHotelId(hotel);
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("hotelById", hotel);
		modelMap.put("reviews", reviewList);
		return new ModelAndView(Constant.HOTEL_TEMPLATE,modelMap);
	}
	
	public ModelAndView searchHotelByName(String hotelName){
		List<Hotel> hotelList = hotelRepository.findByHotelName(hotelName);
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("hotelsList", hotelList);
		
		return new ModelAndView(Constant.HOME_PAGE,modelMap);
	}
}
