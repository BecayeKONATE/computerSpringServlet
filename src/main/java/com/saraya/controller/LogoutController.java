package com.saraya.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LogoutController {
 	
 	@RequestMapping(value="/logout-computer", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) { 
 				request.getSession().invalidate();
		return "redirect:/login";
	}

}
