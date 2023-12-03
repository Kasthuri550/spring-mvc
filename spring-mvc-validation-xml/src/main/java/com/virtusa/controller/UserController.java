package com.virtusa.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.virtusa.exception.UserNotFoundException;
import com.virtusa.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ServletContext servletContext;
	
	@ModelAttribute("roles")
	private Map<String,String> populatedRoles()
	{
		Map<String,String> roleMap=new HashMap<String,String>();
		roleMap.put("Admin","Admin");
		roleMap.put("DBA","DBA");
		return roleMap;
	}
	
	@GetMapping("/add")
	public String getUserForm(@ModelAttribute("newUser") User user,Model model)
	{
		return "userForm";
	}
	
	@PostMapping("/add")
	public String saveUser(@Valid @ModelAttribute("newUser") User user,BindingResult bindingResult,RedirectAttributes redirectAttributes)
	{
		if(bindingResult.hasErrors())
		{
			return "userForm";
		}
		
		MultipartFile multipartFile=user.getProfileImage();
		if(multipartFile!=null || !multipartFile.isEmpty())
		{
			String fileName=servletContext.getRealPath("/")+"resources\\images\\"+multipartFile.getOriginalFilename();
			try {
				multipartFile.transferTo(new File(fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		redirectAttributes.addFlashAttribute("savedUser",user);
		return "redirect:/user/userDetails";
	}
	
	@GetMapping("/userDetails")
	public String success()
	{
		return "success";
	}
	
	@GetMapping("/retrieveUser")
	public String retrieveUser(@RequestParam(required = false,value = "email") String email,Model model)
	{
		if(!"".equals(email))
		{
			User user=new User();
			user.setName("Arun Kumar Paramasivan");
			user.setEmail(email);
			model.addAttribute("savedUser",user);			
			return "forward:/user/userDetails";
		}
		else
		{
			throw new UserNotFoundException("User not found");
		}
	}
	
//	@ExceptionHandler(value = UserNotFoundException.class)
//	public String handleUserNotFoundException(UserNotFoundException e,Model model)
//	{
//		model.addAttribute("msg", e.getMessage());
//		return "error";
//	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder)
	{
		webDataBinder.setDisallowedFields(new String[] {"name"});
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
		webDataBinder.registerCustomEditor(LocalDate.class,"birthday",new CustomDateEditor(dateFormat, false));
	}

}
