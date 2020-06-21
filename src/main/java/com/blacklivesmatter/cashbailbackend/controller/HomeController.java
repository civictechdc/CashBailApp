package com.blacklivesmatter.cashbailbackend.controller;

import com.blacklivesmatter.cashbailbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@GetMapping("/base")
	public String base(){
		return "base";
	}

	@GetMapping("/index")
	public String index(){
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "aboutus";
	}
	
	@GetMapping("/resources")
	public String resources() {
		return "media";
	}

	@GetMapping("/donate")
	public String donate(Principal principal, Model model){
		String username = principal.getName();
		model.addAttribute("user", userRepository.findByUsername(username));
		//model.addAttribute("email", userRepository.findByEmail(email));

		return "donate";}

	@GetMapping("/donateConfirm")
	public String donateConfirm(Principal principal, Model model){
		String username = principal.getName();
		model.addAttribute("user", userRepository.findByUsername(username));

		return "donateConfirm";
	}
}
