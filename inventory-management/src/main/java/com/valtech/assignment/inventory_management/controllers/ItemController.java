package com.valtech.assignment.inventory_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.assignment.inventory_management.services.InventoryService;
import com.valtech.assignment.inventory_management.services.ItemService;
import com.valtech.assignment.inventory_management.vos.ItemVO;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

//	public ModelAndView test() {
//		ModelAndView view = new ModelAndView("register");
//		view.addObject("message","Item Page");
//		return view;
//	}
	
	
	
	@GetMapping("/order")
	public String orderRegisterPage(Model model) {
//		System.out.println("______________----544444445555888"+ item);
		System.out.println("----------------------------------------------------------");
		model.addAttribute("item", itemService.getAll());
		return "order";
	}
	
	
	@GetMapping("/item")
	public String itemRegisterPage() {
		return "registeritem";
	}
	
	@PostMapping("/item")
	public String itemRegistrationForm(@ModelAttribute ItemVO item,Model model) {
		model.addAttribute("item", item);
		itemService.saveOrUpdate(item) ;
		return  "redirect:/order";
	}
	
	
	
}
