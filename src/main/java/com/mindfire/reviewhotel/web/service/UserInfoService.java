/**
 * 
 */
package com.mindfire.reviewhotel.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.domain.UserInfo;
import com.mindfire.reviewhotel.web.dto.UserInfoDTO;
import com.mindfire.reviewhotel.web.repository.UserRepository;

/**
 * @author mindfire
 *
 */
@Service
public class UserInfoService {
	@Autowired
	public UserRepository userRepository;

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
		if (createdUser == null) {
			return Constant.HOME_PAGE;
		} else {
			model.addAttribute("userDetails", newUser);
			return Constant.SIGN_IN_PAGE;
		}
	}
}
