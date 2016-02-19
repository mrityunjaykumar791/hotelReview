/**
 * 
 */
package com.mindfire.reviewhotel.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindfire.reviewhotel.web.constant.Constant;
import com.mindfire.reviewhotel.web.domain.UserInfo;
import com.mindfire.reviewhotel.web.dto.SignInDTO;
import com.mindfire.reviewhotel.web.repository.UserRepository;

/**
 * @author mindfire
 *
 */
@Service
public class SignInService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String validate(SignInDTO signInDto, HttpSession session){
		BCryptPasswordEncoder passDecoder = new BCryptPasswordEncoder();
		UserInfo userInfo = userRepository.findByUserName(signInDto.getUserName());
		if(passDecoder.matches(signInDto.getPassword(), userInfo.getPassword())){
			session.setAttribute("userName", userInfo.getUserName());
			session.setAttribute("userId", userInfo.getId());
			if(userInfo.getRole().equals("admin")){
				session.setAttribute("user", "admin");
				return Constant.HOTEL_PAGE;
			}else{
				session.setAttribute("user", "user");
			return Constant.HOME_PAGE;
			}
			
		}else{
			return Constant.SIGN_IN_PAGE;
		}
		
	}
	

}
