package com.valtech.assignment.inventory_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.assignment.inventory_management.services.CustomerService;
import com.valtech.assignment.inventory_management.vos.CustomerVO;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public ModelAndView test() {
	ModelAndView view = new ModelAndView("register");
	view.addObject("message","Register Page");
	return view;
	}

	
	
	@GetMapping("/customer")
	public String registerPage() {
		return "registercustomer";
	}
	
	@PostMapping("/customer")
	public String registrationForm(@ModelAttribute CustomerVO customer,Model model) {
		model.addAttribute("customer",customer);
		customerService.saveOrUpdate(customer);
		return "registercustomer";
		
	}
	
	
}
