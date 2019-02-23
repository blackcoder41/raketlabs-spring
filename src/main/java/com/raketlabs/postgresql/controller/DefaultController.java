package com.raketlabs.postgresql.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raketlabs.postgresql.model.User;
import com.raketlabs.postgresql.repository.UserRepository;

@Controller
public class DefaultController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String index(@RequestParam(name="name", required=false, defaultValue="there") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(name="name", required=false, defaultValue="there") String name, Model model) {
		model.addAttribute("name", name);
		return "login";
	}
	

	@PostMapping("/register")
    public void register (User user) {
		
		
		System.out.println(user);
//		System.out.println(model);
		
		//userRepository.save(user);
		
//    	return "register";
    }
	
	@GetMapping("/view_questions")
	public String viewQuestions() {
		return "view_questions";
	}
}
