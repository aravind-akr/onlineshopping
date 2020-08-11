package com.aravind.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","Home");
		modelAndView.addObject("userClickHome",true);
		return modelAndView;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","About Us");
		modelAndView.addObject("userClickAbout",true);
		return modelAndView;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","Contact Us");
		modelAndView.addObject("userClickContact",true);
		return modelAndView;
	}
	
}
