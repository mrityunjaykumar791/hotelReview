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

import com.mindfire.reviewhotel.web.dto.HotelDTO;
import com.mindfire.reviewhotel.web.dto.ReviewDTO;
import com.mindfire.reviewhotel.web.service.HotelService;
/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 * 
 * This Class is used for transfer the hotel related control to the service
 */

@Controller
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	/**
	 * Request mapping with adminAction Value To Save the hotel details providedd By admin.
	 * 
	 * @param hotelDto
	 * @param model
	 * @return HOTEL_PAGE
	 */
	 @RequestMapping(value="adminAction",method = RequestMethod.POST)
	    public String submit(@ModelAttribute("hotelData") HotelDTO hotelDto, Model model) {
	        return hotelService.saveHotelDetails(hotelDto, model);
	    }
	 
	 /**
	  * Request mapping with hotelTemplate value With Id To search hotel Details By provided hotelId. 
	  * 
	  * @param reviewDto
	  * @param model
	  * @param hotelId
	  * @return ModelAndView object
	  */
	 @RequestMapping(value="hotelTemplate/{id}", method=RequestMethod.GET)
	    public ModelAndView hotelTemplate(@ModelAttribute("reviewData") ReviewDTO reviewDto, Model model,@PathVariable("id") Long hotelId) {
	        return hotelService.searchHotelDetailById(hotelId,model);
	 }
}
