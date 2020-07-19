package com.niit.indigo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.indigo.model.Users;
import com.niit.indigo.service.UserService;

@Controller
public class ApplicationController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String indexView()
	{
		return "index";
	}

	
	
	@GetMapping("/registration")
	public String signUpForm(ModelMap theSignUpModel)
	{
		theSignUpModel.addAttribute("customer",new Users());
		return "registration";
	}
	
	@PostMapping("/signup")
	public ModelAndView signUpProcess(@ModelAttribute("customer") Users newUser)
	{
		
		ModelAndView model=new ModelAndView("index");
		newUser.setRegisteredDate(new Date());
		//newUser.setLoginDate(new Date());
		userService.save(newUser);
		return model;
		
				
	}
	
	
	@GetMapping("/login")
	public String loginForm(ModelMap theLoginModel)
	{
		theLoginModel.addAttribute("customer", new Users());
		return "login";
	}
	@PostMapping("/signIn")
	public ModelAndView loginProcess(HttpServletRequest request,@ModelAttribute("customer") Users loginUser)
	{
		ModelAndView model=null;
		
		Users activeUser=userService.login(loginUser);
		if(activeUser==null)
		{
			model=new ModelAndView("login");
			model.addObject("error","Email or Password Incorrect");
		}
		else
		{
			request.getSession().setAttribute("userDetails", activeUser);
			model=new ModelAndView("searchCustomer");
			model.addObject("customerlist",userService.findAll());
		}
		return model;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		Users user=(Users)req.getSession().getAttribute("userDetails");
		user.setLoginDate(new Date());
		userService.save(user);
		req.getSession().invalidate();
		return "redirect:/";
	}
}
