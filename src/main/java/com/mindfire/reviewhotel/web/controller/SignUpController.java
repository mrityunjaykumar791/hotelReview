/*
 * Copyright (c) Mindfire Solutions.
 */
package com.mindfire.reviewhotel.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.dto.UserInfoDTO;
import com.mindfire.reviewhotel.web.service.UserInfoService;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 */
@Controller
public class SignUpController {
	
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * Request mapping with signUpAction value to save user details.
	 * 
	 * @param userInfoDto
	 * @param model
	 * @return HOME_PAGE
	 */
	@RequestMapping(value = "signUpAction", method = RequestMethod.POST)
	public String submit(@ModelAttribute("signUpData") @Valid UserInfoDTO userInfoDto,BindingResult result, Model model) {
		if(result.hasErrors()) {
            return Constant.SIGN_UP_PAGE;
        }
		return userInfoService.createUserInfo(userInfoDto, model);
	}
}