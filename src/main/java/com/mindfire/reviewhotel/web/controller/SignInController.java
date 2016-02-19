/**
 * 
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
import com.mindfire.reviewhotel.web.dto.HotelDTO;
import com.mindfire.reviewhotel.web.dto.SearchByNameDTO;
import com.mindfire.reviewhotel.web.dto.SignInDTO;
import com.mindfire.reviewhotel.web.service.SignInService;

/**
 * @author mindfire
 *
 */
@Controller
public class SignInController {
	
	@Autowired
	private SignInService signInService;
	
	 @RequestMapping(value="signInAction",method = RequestMethod.POST)
	    public String submit(@ModelAttribute("signInData") SignInDTO signInDto, Model model, HttpSession session) {
		    model.addAttribute("hotelData",new HotelDTO());
		    model.addAttribute("searchByNameData",new SearchByNameDTO());
	        return signInService.validate(signInDto,session);
	    }
	 
	 @RequestMapping(value="logout", method = RequestMethod.GET)
	 public String logout(Model model,HttpSession session){
		 session.invalidate();
		 model.addAttribute("searchByNameData",new SearchByNameDTO());
		 return Constant.HOME_PAGE;
	 }
}