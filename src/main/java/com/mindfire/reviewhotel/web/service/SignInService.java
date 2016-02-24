/*
 * Copyright (c) Mindfire Solutions.
 */
package com.mindfire.reviewhotel.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.domain.UserInfo;
import com.mindfire.reviewhotel.web.dto.SearchByNameDTO;
import com.mindfire.reviewhotel.web.dto.SignInDTO;
import com.mindfire.reviewhotel.web.repository.UserRepository;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 *        Service class for SignIn related Operations
 */
@Service
public class SignInService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * This Method is used for validating user name role and password and based
	 * on condition this method will return HOME_PAGE and SIGN_IN_PAGE
	 * 
	 * @param signInDto
	 * @param session
	 * @see BCryptPasswordEncoder
	 * @return HOME_PAGE or SIGN_IN_PAGE
	 */
	public String validate(SignInDTO signInDto, HttpSession session, Model model) {
		BCryptPasswordEncoder passDecoder = new BCryptPasswordEncoder();
		UserInfo userInfo = userRepository.findByUserName(signInDto.getUserName());

		if (passDecoder.matches(signInDto.getPassword(), userInfo.getPassword())) {
			session.setAttribute("userName", userInfo.getUserName());
			session.setAttribute("userId", userInfo.getId());
			if (userInfo.getRole().equals("admin")) {
				session.setAttribute("user", "admin");
			} else {
				session.setAttribute("user", "user");
			}

			model.addAttribute("searchByNameData", new SearchByNameDTO());
			return Constant.HOME_PAGE;
		} else {
			model.addAttribute("status", "Please Enter Valid UserName and Password!");
			return Constant.SIGN_IN_PAGE;
		}
	}

}
