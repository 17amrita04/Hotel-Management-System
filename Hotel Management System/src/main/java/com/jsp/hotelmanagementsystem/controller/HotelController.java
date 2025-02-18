package com.jsp.hotelmanagementsystem.controller;

import java.util.List;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotelmanagementsystem.dao.HotelDao;
import com.jsp.hotelmanagementsystem.entities.Hotel;




@Controller
public class HotelController {

	
	@Autowired
	HotelDao dao; 
	
	
	@RequestMapping("/addhotel")
	//handler used to create Hotel class Object and pass it to HotelForm.jsp
	public ModelAndView addHotel() {
		Hotel hotel = new Hotel();
		 ModelAndView mav = new  ModelAndView();
		 mav.addObject("hotelobj",hotel);
		 mav.setViewName("HotelForm");
		 return mav;
	}
	
	@RequestMapping("/savehotel")
	////handler used to save Hotel information in database
	public ModelAndView saveHotel(@ModelAttribute("hotelobj") Hotel hotel) {
		hotel.setStatus("Not approved");
		dao.saveHotel(hotel);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("messege", "your account is in review, please wait for sometimes");
		mav.setViewName("Hotellogin");
		return mav;
		
	}

	@RequestMapping("/hotelloginvalidate")
	////handler used to perform hotel login validation and return appropriate response 
	public ModelAndView hotelLoginValidation(ServletRequest request,HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Hotel hotel = dao.login (email, password);
		
		if(hotel != null) {
			if(hotel.getStatus().equals("Not approved")) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "your account is in review, please wait for sometimes");
			mav.setViewName("displaymessage");
			return mav;
			
			}else if(hotel.getStatus().equals("blocked")) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "your account is blocked");
			mav.setViewName("displaymessage");
			return mav;
			
	        }else {
	        	//storing hotel entity object into session
	        	//storing hotel logged in hotel into session
	        	session.setAttribute("hotelinfo",hotel.getId() );
		    ModelAndView mav = new ModelAndView();
		    mav.addObject("message", "logged in successfully");
		    mav.setViewName("hoteloptions");
		    return mav;
	       }
       }else {
	   ModelAndView mav = new ModelAndView();
	   mav.addObject("message", "invalid credentials");
	   mav.setViewName("Hotellogin");
	   return mav;
       }
	
     }
	
	     @RequestMapping("/fetchunapproveddhotels")
	     // handler is used to find unapproved hotels
	     public ModelAndView fetchUnapprovedHotels() {
	     	List<Hotel> hotels = dao.findUnapprovedHotels();
	     	ModelAndView mav = new ModelAndView();
	     	mav.addObject("unapprovedhotels", hotels);
	     	mav.setViewName("displayunapprovedhotels");
	     	return mav;
	     }
	
	     @RequestMapping("/approvehotel")
	     // handler is used to modify the hotel status as approved
	     public ModelAndView approveHotel(@RequestParam("id") int id) {
	     	Hotel h = dao.findHotelById(id);
	     	h.setStatus("approved");
	     	dao.updateHotel(h);
		
	     	ModelAndView mav = new ModelAndView();
	     	mav.setViewName("redirect://fetchunapprovedhotels");
	     	return mav;
		
	     }
	
	     @RequestMapping("/hotellogout")
	    
	     public ModelAndView HotelLogout(HttpSession session) {
	     	session.invalidate();
	     	ModelAndView mav = new ModelAndView();
	     	mav.addObject("message","Logged out successfully");
	     	mav.setViewName("HotelHomepage");
	     	return mav;
		
	     }	
	
      }
	
	