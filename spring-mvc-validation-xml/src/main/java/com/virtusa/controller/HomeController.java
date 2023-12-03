package com.virtusa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.virtusa.exception.UserNotFoundException;

@Controller
public class HomeController {
	
	@GetMapping("/user/getError")
	public String getError()
	{
		throw new UserNotFoundException("This is home controller. Not working your external error page");
	}

}
