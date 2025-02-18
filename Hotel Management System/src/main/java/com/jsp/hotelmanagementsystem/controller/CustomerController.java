package com.jsp.hotelmanagementsystem.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotelmanagementsystem.dao.CustomerDao;
import com.jsp.hotelmanagementsystem.entities.Customer;

@Controller
public class CustomerController {

	
	@Autowired
	CustomerDao customerdao; 
	
	
	@RequestMapping("/addcustomer")
	// handler used to create customer object
	public ModelAndView addCustomer() {
		Customer customer = new Customer();
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerobj", customer);
		mav.setViewName("customerform");
		return mav;
	}
	
	@RequestMapping("/savecustomer")
	// handler used to save customer details into database
	public ModelAndView saveCustomer(@ModelAttribute("customerobj")  Customer customer) {
		customerdao.saveCustomer(customer);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Registered successfully ");
		mav.setViewName("customerlogin");
		return mav;
		
	}
	
	
	@RequestMapping("/customerloginvalidate")
	// handler used to perform login validation for Customer
	public ModelAndView loginValidate(ServletRequest req, HttpSession session) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Customer customer = customerdao.login (email, password);
		
		if(customer != null) {
			session.setAttribute("customerinfo", customer.getId());
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "logged in successfully");
			mav.setViewName("customeroptions");
	
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "invalid credentials");
			mav.setViewName("customerlogin");
			return mav;
		
	}
	}
}
