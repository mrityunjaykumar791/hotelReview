/**
 * 
 */
package com.mindfire.reviewhotel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.dto.SearchByNameDTO;
import com.mindfire.reviewhotel.web.dto.SearchDTO;
import com.mindfire.reviewhotel.web.service.HotelService;

/**
 * @author mindfire
 *
 */
@Controller
public class SearchController {

	@Autowired
	private HotelService hotelService;
	
	 @RequestMapping(value="searchAction",method = RequestMethod.POST)
	    public ModelAndView submit(@ModelAttribute("searchData") SearchDTO searchDto, Model model) {
	        return hotelService.searchHotelDetails(searchDto, model);
	    }
	 
	 @RequestMapping("threeStar")
	    public ModelAndView threeStar() {
	        return hotelService.searchByCategory("Three-Star");
	    }
	    
	    @RequestMapping("fourStar")
	    public ModelAndView fourStar() {
	    	return hotelService.searchByCategory("Four-Star");
	    }
	    
	    @RequestMapping("fiveStar")
	    public ModelAndView fiveStar() {
	    	return hotelService.searchByCategory("Five-Star");
	    }
	    
	    @RequestMapping(value="indexAction",method=RequestMethod.POST)
	    public ModelAndView searchByName(@ModelAttribute("searchByNameData") SearchByNameDTO searchByNameDto,Model model){
	    	return hotelService.searchHotelByName(searchByNameDto.getHotelName());
	    }
	    
}
