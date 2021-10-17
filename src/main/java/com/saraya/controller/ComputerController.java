package com.saraya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.saraya.model.Computer;

import com.saraya.service.ComputerService;
import com.saraya.service.UserValidation;

@Controller
@SessionAttributes("username")
public class ComputerController {

	
	@Autowired
	ComputerService cs;
	@Autowired
	UserValidation uv;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginCrampon() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String homeCrampon(ModelMap model, @RequestParam String username,
			@RequestParam String pswrd) {
		model.addAttribute("user", username);
		boolean valid = uv.isValid(username, pswrd);
		if(valid) {
			return "home";
		}else {
			model.addAttribute("errorMessage", "Wrong credential");
			return "redirect:/login";	
		}
	}
	
	@RequestMapping(value="/list-computer", method=RequestMethod.GET)
	public String cramponList(ModelMap model) {
		model.addAttribute("computers", cs.getAllComputer());
		return "computerList";
	}
	
	@RequestMapping(value="/add-computer", method=RequestMethod.GET)
	public String addCrampon(ModelMap model) {
		model.addAttribute("computer", new Computer());
		return "addComputer";
	}
	@RequestMapping(value="/add-computer", method=RequestMethod.POST)
	public String addCrampo(ModelMap model, @Valid @ModelAttribute("computer") Computer computer, BindingResult result) {
		if(result.hasErrors())
			return "addComputer";
		cs.addComputer(computer.getMake(), computer.getModel(), computer.getPrice(), computer.getImage());
		model.clear();
		return "redirect:/list-computer";
	}
	
	@RequestMapping(value="/delete-computer", method=RequestMethod.GET)
	public String deleteCrampon(ModelMap model, @RequestParam int id) {
		cs.deleteComputer(id);
		model.clear();
		return "redirect:/list-computer";
	}
	
	@RequestMapping(value="/image-computer", method=RequestMethod.GET)
	public String seeCrampon(ModelMap model, @RequestParam int id) {
		model.addAttribute("imge", cs.getById(id));
		return "seeCompputer";
	}
	
	@RequestMapping(value="/update-computer", method=RequestMethod.GET)
	public String updateCrampon(@RequestParam int id, ModelMap model) {
		model.addAttribute("crampon", cs.getById(id));
		return "addComputer";
	}
	
	@RequestMapping(value="/update-computer", method=RequestMethod.POST)
	public String updatedCrampon(ModelMap model, @Valid @ModelAttribute("computer") Computer computer,
			BindingResult result) {
		if(result.hasErrors())
			return "addComputer";
		cs.updateComputer(computer);
		model.clear();
		return "redirect:/list-computer";
	}
}







