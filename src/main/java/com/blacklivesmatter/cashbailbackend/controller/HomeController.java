package com.blacklivesmatter.cashbailbackend.controller;

import com.blacklivesmatter.cashbailbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public ModelAndView home(Principal principal, Model model)
	{
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String currentUserName= authentication.getName();

		if(userRepository.findByUsername(currentUserName)!=null){
		String username = currentUserName;
		model.addAttribute("username", currentUserName);
		model.addAttribute("user", userRepository.findByUsername(username));
		model.addAttribute("email", userRepository.findAll());}
		return new ModelAndView("index");
	}

	@GetMapping("/base")
	public String base(Principal principal, Model model){
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String currentUserName= authentication.getName();

		if(userRepository.findByUsername(currentUserName)!=null){
			String username = currentUserName;
			model.addAttribute("username", currentUserName);
			model.addAttribute("user", userRepository.findByUsername(username));
			model.addAttribute("email", userRepository.findAll());}

		return "base";
	}

	@GetMapping("/index")
	public String index(Principal principal, Model model){
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String currentUserName= authentication.getName();

		if(userRepository.findByUsername(currentUserName)!=null){
			String username = currentUserName;
			model.addAttribute("username", currentUserName);
			model.addAttribute("user", userRepository.findByUsername(username));
			model.addAttribute("email", userRepository.findAll());}
		return "index";
	}
	
	@GetMapping("/about")
	public String about(Principal principal, Model model) {
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String currentUserName= authentication.getName();

		if(userRepository.findByUsername(currentUserName)!=null){
			String username = currentUserName;
			model.addAttribute("username", currentUserName);
			model.addAttribute("user", userRepository.findByUsername(username));
			model.addAttribute("email", userRepository.findAll());}
		return "aboutus";
	}
	
	@GetMapping("/resources")
	public String resources(Principal principal, Model model) {
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String currentUserName= authentication.getName();

		if(userRepository.findByUsername(currentUserName)!=null){
			String username = currentUserName;
			model.addAttribute("username", currentUserName);
			model.addAttribute("user", userRepository.findByUsername(username));
			model.addAttribute("email", userRepository.findAll());}

		return "media";
	}

	@GetMapping("/donate")
	public String donate(Principal principal, Model model){
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String currentUserName= authentication.getName();

		if(userRepository.findByUsername(currentUserName)!=null){
			String username = currentUserName;
			model.addAttribute("username", currentUserName);
			model.addAttribute("user", userRepository.findByUsername(username));
			model.addAttribute("email", userRepository.findAll());}
		return "donate";}

	@GetMapping("/donateConfirm")
	public String donateConfirm(Principal principal, Model model){
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String currentUserName= authentication.getName();

		if(userRepository.findByUsername(currentUserName)!=null){
			String username = currentUserName;
			model.addAttribute("username", currentUserName);
			model.addAttribute("user", userRepository.findByUsername(username));
			model.addAttribute("email", userRepository.findAll());}

		return "donateConfirm";
	}
}
