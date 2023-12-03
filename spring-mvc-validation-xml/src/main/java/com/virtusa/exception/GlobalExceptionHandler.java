package com.virtusa.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ModelAttribute("name")
	public String name()
	{
		return "A.Kasthuri";
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public String handleUserNotFoundException(UserNotFoundException e,Model model)
	{
		model.addAttribute("msg", e.getMessage());
		return "error";
	}
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e,Model model)
	{
		model.addAttribute("msg", e.getMessage());
		return "error";
	}

}
