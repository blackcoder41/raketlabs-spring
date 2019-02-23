package com.raketlabs.postgresql.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.raketlabs.postgresql.model.AdminUser;
import com.raketlabs.postgresql.service.AdminUserService;

@Controller
public class RegistrationController {

	private AdminUserService adminUserService;
	
	@RequestMapping(value= {"/", "login"}, method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/login");
		return model;
	}
	
	@RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		AdminUser adminUser = new AdminUser();
		model.addObject("adminuser", adminUser);
		model.setViewName("user/signup");
		return model;
	}
	
	@RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	public ModelAndView createUser(@Valid AdminUser adminUser, BindingResult bindingResult){
		ModelAndView model = new ModelAndView();
		AdminUser adminUserExists = adminUserService.findByUsername(adminUser.getUsername());
		
		if(adminUserExists != null){
			bindingResult.rejectValue("username", "error.adminUser", "This username already exists!");
		}
		if(bindingResult.hasErrors()){
			model.setViewName("user/signup");
		}else {
			adminUserService.saveAdminUser(adminUser);
			model.addObject("msg", "User has been registered successfully!");
			model.addObject("adminUser", new AdminUser());
			model.setViewName("user/signup");
		}	
		return model;
	}
	
	@RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
	 public ModelAndView home() {
	  ModelAndView model = new ModelAndView();
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  AdminUser adminUser = adminUserService.findByUsername(auth.getName());
	  
	  model.addObject("userName", adminUser.getFirstname() + " " + adminUser.getLastname());
	  model.setViewName("home/home");
	  return model;
	 }
	 
	 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	 public ModelAndView accessDenied() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("errors/access_denied");
	  return model;
	 }
}
