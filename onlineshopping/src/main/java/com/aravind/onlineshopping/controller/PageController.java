package com.aravind.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aravind.shoppingbackend.dao.CategoryDAO;
import com.aravind.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","Home");
		
		//Passing categories list
		modelAndView.addObject("categories",categoryDAO.list());
		
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

	/*
	 * Methods to load all the products and based on category
	 * */
	
	@RequestMapping(value= "show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","All Products");
		
		//Passing categories list
		modelAndView.addObject("categories",categoryDAO.list());
		
		modelAndView.addObject("userClickAllProducts",true);
		return modelAndView;
	}
	
	@RequestMapping(value= "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
		ModelAndView modelAndView = new ModelAndView("page");
		//categoryDAO to fetch single category
		
		Category category = null;
		category = categoryDAO.get(id);
		
		modelAndView.addObject("title",category.getName());
		
		//Passing categories list
		modelAndView.addObject("categories",categoryDAO.list());
		
		//Passing single category
		modelAndView.addObject("category",category);
		
		modelAndView.addObject("userClickCategoryProducts",true);
		return modelAndView;
	}
}
