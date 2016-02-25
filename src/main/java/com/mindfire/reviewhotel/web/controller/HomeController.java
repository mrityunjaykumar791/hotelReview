/*
 * Copyright (c) Mindfire Solutions.
 */
package com.mindfire.reviewhotel.web.controller;

import javax.servlet.http.HttpSession;

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
	public String home(@ModelAttribute("searchByNameData") SearchByNameDTO searchByNameDto) {
		return Constant.HOME_PAGE;
	}

	/**
	 * Mapping with signUp value to render by returning its name.
	 * 
	 * @param model
	 * @return ModelAndViewobject
	 */
	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public ModelAndView signUp(@ModelAttribute("signUpData") UserInfoDTO userInfoDto) {
		return new ModelAndView(Constant.SIGN_UP_PAGE);
	}

	/**
	 * Mapping with signIn value to render by returning its name.
	 * 
	 * @param model
	 * @return ModelAndView object
	 */
	@RequestMapping(value = "signIn", method = RequestMethod.GET)
	public ModelAndView signIn(@ModelAttribute("signInData") SignInDTO signInDto) {
		return new ModelAndView(Constant.SIGN_IN_PAGE);
	}

	/**
	 * Mapping with index value to render by returning its name.
	 * 
	 * @param model
	 * @return ModelAndView object
	 */
	@RequestMapping("index")
	public ModelAndView index(@ModelAttribute("searchByNameData") SearchByNameDTO searchByNameDto) {
		return new ModelAndView(Constant.HOME_PAGE);
	}

	/**
	 * Mapping with searchByCategory value to render by returning its view name.
	 * 
	 * @param model
	 * @return ModelAndView object
	 */
	@RequestMapping("searchByCategory")
	public ModelAndView searchByCategory() {
		return new ModelAndView(Constant.SEARCH_BY_CATEGORY);
	}

	/**
	 * Mapping with hotel value to render by returning its view name and
	 * checking weather user is admin or not.
	 * 
	 * @param model
	 * @return HOTEL_PAGE
	 */
	@RequestMapping(value = "hotel", method = RequestMethod.GET)
	public ModelAndView hotel(@ModelAttribute("searchByNameData") SearchByNameDTO searchByNameDto,
			@ModelAttribute("hotelData") HotelDTO hotelDto, HttpSession session) {
		if (session.getAttribute("user") == null || session.getAttribute("user").equals("")
				|| session.getAttribute("user").equals("user")) {
			return new ModelAndView(Constant.HOME_PAGE);
		}
		
		return new ModelAndView(Constant.HOTEL_PAGE);
	}

	/**
	 * Mapping with profile value to render by returning its name.
	 * 
	 * @return ModelAndView object
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
	 * @return ModelAndView object
	 */
	@RequestMapping(value = "searchByLocation", method = RequestMethod.GET)
	public ModelAndView searchByLocation(@ModelAttribute("searchData") SearchDTO searchDto, Model model) {
		return new ModelAndView(Constant.SEARCH_BY_LOCATION);
	}
}
