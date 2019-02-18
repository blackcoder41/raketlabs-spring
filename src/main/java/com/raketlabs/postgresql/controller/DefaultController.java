package com.raketlabs.postgresql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

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
	
	@GetMapping("/view_questions")
	public String viewQuestions() {
		return "view_questions";
	}
}
