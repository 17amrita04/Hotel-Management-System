package com.jsp.hotelmanagementsystem.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotelmanagementsystem.dao.AdminDao;
import com.jsp.hotelmanagementsystem.entities.Admin;

@Controller
public class AdminController {

	@Autowired
	AdminDao dao;
	
	@RequestMapping("/addadmin")
	// handler used to create admin object
	public ModelAndView addAdmin() {
		Admin admin = new Admin();
		ModelAndView mav = new ModelAndView();
		mav.addObject("adminobj", admin);
		mav.setViewName("Adminform");
		return mav;
	}
	
	
	@RequestMapping("/saveadmin")
	// handler used to save admin details into database
	public ModelAndView saveAdmin(@ModelAttribute("adminobj")  Admin admin) {
		dao.saveAdmin(admin);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "account created successfully ");
		mav.setViewName("Adminlogin");
		return mav;
		
	}
	
	@RequestMapping("/adminloginvalidate")
	// handler used to perform login validation for admin
	public ModelAndView loginValidate(ServletRequest req, HttpSession session) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Admin admin = dao.login (email, password);
		
		if(admin != null) {
			session.setAttribute("admininfo", admin);
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "logged in successfully");
			mav.setViewName("adminoptions");
	
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "invalid credentials");
			mav.setViewName("Adminlogin");
			return mav;
		
	}
	}
	
	 @RequestMapping("/adminlogout")
     // handler is used to delete the admin data in HttpSession
     public ModelAndView logout(HttpSession session) {
     	session.invalidate();
     	ModelAndView mav = new ModelAndView();
     	mav.addObject("message","Logged out successfully");
     	mav.setViewName("Adminhome");
     	return mav;
	
     }	
}
