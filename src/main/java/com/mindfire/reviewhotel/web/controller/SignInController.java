/*
 * Copyright (c) Mindfire Solutions.
 */
package com.mindfire.reviewhotel.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.dto.SearchByNameDTO;
import com.mindfire.reviewhotel.web.dto.SignInDTO;
import com.mindfire.reviewhotel.web.service.SignInService;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 */
@Controller
public class SignInController {
	
	@Autowired
	private SignInService signInService;
	
	/**
	 * Request mapping with signInAction value to validate the User.
	 * 
	 * @param signInDto
	 * @param model
	 * @param session
	 * @return HOME_PAGE or SIGN_IN_PAGE
	 */
	 @RequestMapping(value="signInAction",method = RequestMethod.POST)
	    public String submit(@ModelAttribute("signInData") SignInDTO signInDto, Model model, HttpSession session) {
		    model.addAttribute("searchByNameData",new SearchByNameDTO());
		    model.addAttribute("signIndata",new SignInDTO());
	        return signInService.validate(signInDto,session,model);
	    }
	 
	 /**
	  * Request mapping with logout value to invalidate the session.
	  * @param model
	  * @param session
	  * @return HOME_PAGE
	  */
	 @RequestMapping(value="logout", method = RequestMethod.GET)
	 public String logout(Model model,HttpSession session){
		 session.invalidate();
		 model.addAttribute("searchByNameData",new SearchByNameDTO());
		 return Constant.HOME_PAGE;
	 }
}