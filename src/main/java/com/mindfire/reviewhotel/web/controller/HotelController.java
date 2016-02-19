/**
 * 
 */
package com.mindfire.reviewhotel.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewhotel.web.dto.HotelDTO;
import com.mindfire.reviewhotel.web.dto.ReviewDTO;
import com.mindfire.reviewhotel.web.service.HotelService;
/**
 * @author mindfire
 *
 */

@Controller
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	 @RequestMapping(value="adminAction",method = RequestMethod.POST)
	    public String submit(@ModelAttribute("hotelData") HotelDTO hotelDto, Model model) {
	        model.addAttribute("hotelData", new HotelDTO());
	        return hotelService.saveHotelDetails(hotelDto, model);
	    }
	 
	 @RequestMapping(value="hotelTemplate/{id}", method=RequestMethod.GET)
	    public ModelAndView hotelTemplate(@ModelAttribute("reviewData") ReviewDTO reviewDto, Model model,@PathVariable("id") Long hotelId) {
	    	model.addAttribute("reviewData", new ReviewDTO());
	        return hotelService.searchHotelDetailById(hotelId);
	    }
}
