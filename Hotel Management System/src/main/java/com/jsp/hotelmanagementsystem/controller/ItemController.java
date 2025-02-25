package com.jsp.hotelmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotelmanagementsystem.dao.ItemDao;
import com.jsp.hotelmanagementsystem.dao.ProductDao;
import com.jsp.hotelmanagementsystem.entities.Item;
import com.jsp.hotelmanagementsystem.entities.Product;


@Controller
public class ItemController {

	
	@Autowired
	ItemDao itemDao; 
	
	@Autowired
	ProductDao productDao; 
	
	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id") int productId) {
		Product product = productDao.findById(productId);
		Item item = new Item();
		item.setName(product.getName());
		item.setType(product.getType());
		item.setCost(product.getCost());
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemobj",item);
		mav.setViewName("itemform");
		return mav;
	}
	
	@RequestMapping("/saveItemtoorder")
	public ModelAndView saveItemtoOrder(@ModelAttribute("itemobj") Item item, HttpSession session) {
		item.setCost(item.getQuantity() * item.getCost());
		
		if(session.getAttribute("itemslist") == null) {
			List<Item> items = new ArrayList<>();
			items.add(item);
			session.setAttribute("itemslist", items);
		} else {
			List<Item> items = (List<Item>) session.getAttribute("itemslist");
			items.add(item);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "added successfully");
		mav.setViewName("redirect://fetchallproducts");
		return mav;
	}
}
