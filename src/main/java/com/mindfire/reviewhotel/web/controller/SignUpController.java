package com.mindfire.reviewhotel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindfire.reviewhotel.web.dto.UserInfoDTO;
import com.mindfire.reviewhotel.web.service.UserInfoService;

@Controller
public class SignUpController {
	
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "signUpAction", method = RequestMethod.POST)
	public String submit(@ModelAttribute("signUpData") UserInfoDTO userInfoDto, Model model) {
		model.addAttribute("signInData", new UserInfoDTO());
		return userInfoService.createUserInfo(userInfoDto, model);
	}
}