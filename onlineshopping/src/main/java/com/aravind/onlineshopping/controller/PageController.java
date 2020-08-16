package com.aravind.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aravind.onlineshopping.exception.ProductNotFoundException;
import com.aravind.shoppingbackend.dao.CategoryDAO;
import com.aravind.shoppingbackend.dao.ProductDAO;
import com.aravind.shoppingbackend.dto.Category;
import com.aravind.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
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
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","All Products");
		
		//Passing categories list
		modelAndView.addObject("categories",categoryDAO.list());
		
		modelAndView.addObject("userClickAllProducts",true);
		return modelAndView;
	}
	
	@RequestMapping(value= "/show/category/{id}/products")
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
	
	/*
	 * Viewing a Single Product
	 */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView modelAndView = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		//Update the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		//----------------
		
		modelAndView.addObject("title",product.getName());
		modelAndView.addObject("product",product);
		modelAndView.addObject("userClickShowProduct",true);
		
		return modelAndView;
	}
}
