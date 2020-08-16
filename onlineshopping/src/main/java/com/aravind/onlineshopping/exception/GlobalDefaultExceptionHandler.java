package com.aravind.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundExpception() {
		
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("errorTitle","The Page is not constructred");
		
		modelAndView.addObject("errorDescription","The page you are looking for is not available now!!!");
		
		modelAndView.addObject("title","404 Error Page");
		
		return modelAndView;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("errorTitle","Product Not available!!");
		
		modelAndView.addObject("errorDescription","The product you are looking for is not available right now!!!");
		
		modelAndView.addObject("title","Product unavailable");
		
		return modelAndView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("errorTitle","Contact your administrator!!!");
		
		modelAndView.addObject("errorDescription",ex.toString());
		
		modelAndView.addObject("title","Contact your administrator");
		
		return modelAndView;
	}
	
}
