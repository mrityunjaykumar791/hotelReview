/*
 * Copyright (c) Mindfire Solutions.
 */
package com.mindfire.reviewhotel.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.dto.HotelDTO;
import com.mindfire.reviewhotel.web.dto.SearchByNameDTO;
import com.mindfire.reviewhotel.web.dto.SearchDTO;
import com.mindfire.reviewhotel.web.dto.SignInDTO;
import com.mindfire.reviewhotel.web.dto.UserInfoDTO;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 *        Handles requests for the application home page. This Class is used for
 *        simply handle the request And render to the view.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @param model
	 * @return HOME_PAGE
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("searchByNameData", new SearchByNameDTO());
		return Constant.HOME_PAGE;
	}

	/**
	 * Mapping with signUp value to render by returning its name.
	 * 
	 * @param model
	 * @return signUp
	 */
	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public ModelAndView signUp(Model model) {
		model.addAttribute("signUpData", new UserInfoDTO());
		return new ModelAndView(Constant.SIGN_UP_PAGE);
	}

	/**
	 * Mapping with signIn value to render by returning its name.
	 * 
	 * @param model
	 * @return signIn
	 */
	@RequestMapping(value = "signIn", method = RequestMethod.GET)
	public ModelAndView signIn(Model model) {
		model.addAttribute("signInData", new SignInDTO());
		return new ModelAndView(Constant.SIGN_IN_PAGE);
	}

	/**
	 * Mapping with index value to render by returning its name.
	 * 
	 * @param model
	 * @return HOME_PAGE
	 */
	@RequestMapping("index")
	public ModelAndView index(Model model) {
		model.addAttribute("searchByNameData", new SearchByNameDTO());
		return new ModelAndView(Constant.HOME_PAGE);
	}

	/**
	 * Mapping with searchByCategory value to render by returning its name.
	 * 
	 * @param model
	 * @return SEARCH_BY_CATEGORY
	 */
	@RequestMapping("searchByCategory")
	public ModelAndView searchByCategory() {
		return new ModelAndView(Constant.SEARCH_BY_CATEGORY);
	}

	/**
	 * Mapping with hotel value to render by returning its name.
	 * 
	 * @param model
	 * @return HOTEL_PAGE
	 */
	@RequestMapping(value = "hotel", method = RequestMethod.GET)
	public ModelAndView hotel(Model model) {
		model.addAttribute("hotelData", new HotelDTO());
		return new ModelAndView(Constant.HOTEL_PAGE);
	}

	/**
	 * Mapping with profile value to render by returning its name.
	 * 
	 * @return PROFILE_PAGE
	 */
	@RequestMapping("profile")
	public ModelAndView profile() {
		return new ModelAndView(Constant.PROFILE_PAGE);
	}

	/**
	 * Mapping with review value to render by returning its name.
	 * 
	 * @return REVIEW_MESSAGE_PAGE
	 */
	@RequestMapping("review")
	public ModelAndView review() {
		return new ModelAndView(Constant.REVIEW_MESSAGE_PAGE);
	}

	/**
	 * Mapping with searchByLocation value to render by returning its name.
	 * 
	 * @param searchDto
	 * @param model
	 * @return SEARCH_BY_LOCATION
	 */
	@RequestMapping(value = "searchByLocation", method = RequestMethod.GET)
	public ModelAndView searchByLocation(@ModelAttribute("searchData") SearchDTO searchDto, Model model) {
		return new ModelAndView(Constant.SEARCH_BY_LOCATION);
	}
}
