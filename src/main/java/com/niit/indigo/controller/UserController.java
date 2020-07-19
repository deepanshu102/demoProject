package com.niit.indigo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.indigo.model.Users;
import com.niit.indigo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/search")
	public ModelAndView customerSearch(HttpServletRequest request) throws ParseException {
		ModelAndView model = new ModelAndView("searchCustomer");
		String fromDateStr = request.getParameter("fromDate");
		String toDateStr = request.getParameter("toDate");
		Date fromDate = new SimpleDateFormat("yyyy-mm-dd").parse(fromDateStr);
		Date toDate = new SimpleDateFormat("yyyy-mm-dd").parse(toDateStr);
		List<Users> userList = userService.findByFromDateTODate(fromDate, toDate);
		model.addObject("customerlist", userList);

		return model;

	}

	@GetMapping("/searchCustomer")
	public String customerSearch(ModelMap model) {
		model.addAttribute("customerlist", userService.findAll());
		return "searchCustomer";
	}

}
