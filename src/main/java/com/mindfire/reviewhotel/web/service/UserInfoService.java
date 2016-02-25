/*
 * Copyright (c) Mindfire Solutions.
 */
package com.mindfire.reviewhotel.web.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.domain.UserInfo;
import com.mindfire.reviewhotel.web.dto.SearchByNameDTO;
import com.mindfire.reviewhotel.web.dto.UserInfoDTO;
import com.mindfire.reviewhotel.web.repository.UserRepository;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 *        Service class for UserInfo related Operations
 */
@Service
public class UserInfoService {

	@Autowired
	public UserRepository userRepository;

	/**
	 * This method is used for saving the user information data based on
	 * UserInfoDto data.
	 * 
	 * @param userInfoDto
	 * @param model
	 * @see BCryptPasswordEncoder
	 * @return HOME_PAGE
	 */
	public String createUserInfo(UserInfoDTO userInfoDto, Model model) {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		UserInfo newUser = new UserInfo();

		newUser.setFirstName(userInfoDto.getFirstName());
		newUser.setLastName(userInfoDto.getLastName());
		newUser.setUserName(userInfoDto.getUserName());
		newUser.setUserEmail(userInfoDto.getUserEmail());
		newUser.setPassword(passEncoder.encode(userInfoDto.getPassword()));
		newUser.setRole("user");

		UserInfo createdUser = userRepository.save(newUser);
		model.addAttribute("searchByNameData", new SearchByNameDTO());
		if (createdUser == null) {
			return Constant.HOME_PAGE;
		} else {
			return Constant.HOME_PAGE;
		}
	}

	/**
	 * This Method is used for finding the user details by their id.
	 * 
	 * @param userId
	 * @return ModelAndView object
	 */
	public ModelAndView userDetails(Long userId) {
		UserInfo userInfo = userRepository.findById(userId);
		Map<String, Object> modelMap = new HashMap<String, Object>();

		modelMap.put("userInfo", userInfo);
		return new ModelAndView("userDetails", modelMap);
	}
}
