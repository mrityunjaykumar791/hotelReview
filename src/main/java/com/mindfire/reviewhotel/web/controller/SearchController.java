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

import com.mindfire.reviewhotel.web.dto.SearchByNameDTO;
import com.mindfire.reviewhotel.web.dto.SearchDTO;
import com.mindfire.reviewhotel.web.service.HotelService;
import com.mindfire.reviewhotel.web.service.UserInfoService;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 */
@Controller
public class SearchController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * Request mapping with searchAction Value To search hotels based on the location.
	 * 
	 * @param searchDto
	 * @param model
	 * @return SEARCH_BY_LOCATION
	 */
	 @RequestMapping(value="searchAction",method = RequestMethod.POST)
	    public ModelAndView submit(@ModelAttribute("searchData") SearchDTO searchDto, Model model) {
	        return hotelService.searchHotelDetails(searchDto, model);
	    }
	 
	 /**
	  * Request mapping with threeStar value to search hotel based on Three-Star category.
	  * 
	  * @return SEARCH_BY_CATEGORY
	  */
	 @RequestMapping("threeStar")
	    public ModelAndView threeStar() {
	        return hotelService.searchByCategory("Three-Star");
	    }
	    
	 /**
	  * Request mapping with fourStar value to search hotel based on Four-Star category.
	  * 
	  * @return SEARCH_BY_CATEGORY
	  */
	    @RequestMapping("fourStar")
	    public ModelAndView fourStar() {
	    	return hotelService.searchByCategory("Four-Star");
	    }
	    
	    /**
		  * Request mapping with fiveStar value to search hotel based on Five-Star category.
		  * 
		  * @return SEARCH_BY_CATEGORY
		  */
	    @RequestMapping("fiveStar")
	    public ModelAndView fiveStar() {
	    	return hotelService.searchByCategory("Five-Star");
	    }
	    
	    /**
	     * Request mapping with indexAction to search hotel by provided name.
	     * 
	     * @param searchByNameDto
	     * @param model
	     * @return HOME_PAGE
	     */
	    @RequestMapping(value="indexAction",method=RequestMethod.POST)
	    public ModelAndView searchByName(@ModelAttribute("searchByNameData") SearchByNameDTO searchByNameDto,Model model){
	    	return hotelService.searchHotelByName(searchByNameDto.getHotelName());
	    }
	    
	    /**
	     * Request mapping  with userDetails/{id} to search user details by provided  userId.
	     * 
	     * @param userId
	     * @return ModelAndView object.
	     */
	    @RequestMapping(value="userDetails/{id}", method=RequestMethod.GET)
	    public ModelAndView hotelTemplate(@PathVariable("id") Long userId) {
	        return userInfoService.userDetails(userId);
	    }
}
