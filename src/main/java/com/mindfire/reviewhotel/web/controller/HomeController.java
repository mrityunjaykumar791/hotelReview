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
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("searchByNameData",new SearchByNameDTO());
		return Constant.HOME_PAGE;
	}
	
	 @RequestMapping(value="signUp", method=RequestMethod.GET)
	    public ModelAndView signUp(Model model) {
		 model.addAttribute("signUpData",new UserInfoDTO());
	        return new ModelAndView(Constant.SIGN_UP_PAGE);
	    }
	 
	    @RequestMapping(value="signIn", method=RequestMethod.GET)
	    public ModelAndView signIn(Model model) {
		 	model.addAttribute("signInData",new SignInDTO());
	        return new ModelAndView(Constant.SIGN_IN_PAGE);
	    }
	    
	    @RequestMapping("index")
	    public ModelAndView index(Model model) {
	    	model.addAttribute("searchByNameData", new SearchByNameDTO());
	    	return new ModelAndView(Constant.HOME_PAGE);
	    }
	    
	    @RequestMapping("searchByCategory")
	    public ModelAndView searchByCategory() {
	        return new ModelAndView(Constant.SEARCH_BY_CATEGORY);
	    }
	    
	    @RequestMapping(value="hotel", method=RequestMethod.GET)
	    public ModelAndView hotel(Model model) {
		 	model.addAttribute("hotelData",new HotelDTO());
	        return new ModelAndView(Constant.HOTEL_PAGE);
	    }
	    
	    @RequestMapping("profile")
	    public ModelAndView profile() {
	        return new ModelAndView(Constant.PROFILE_PAGE);
	    }
	    
	    @RequestMapping("review")
	    public ModelAndView review(){
	    	return new ModelAndView(Constant.REVIEW_MESSAGE_PAGE);
	    }
	    
	    @RequestMapping(value="searchByLocation",method=RequestMethod.GET)
	    public ModelAndView searchByLocation(@ModelAttribute("searchData") SearchDTO searchDto, Model model){
	    	return new ModelAndView(Constant.SEARCH_BY_LOCATION);
	    }
}
