package com.dojojobportal.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojojobportal.models.User;
import com.dojojobportal.services.UserService;

@Controller
public class Users {
	
	private final UserService userService;
	
	public Users(UserService uS) {
		userService = uS;
	}

	@RequestMapping("/")
	public String loginreg(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/process_registration")
	public String process_registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		
		System.out.println("\n\n<<-------------Processing User Registration------------->>\n\n");
		
		System.out.println("Username: " + user.getUsername());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Password: " + user.getPassword());
		
//		for validation

		if ( result.hasErrors() ) {
			return "registration";
		}
		
		if ( userService.findByEmail( user.getEmail() ) != null ) {
			model.addAttribute( "exists", "A user with this email already exists." );
			model.addAttribute( "user", new User() );
			return "registration";
		}
		
		if ( !user.getPassword().equals( user.getConfirmation() ) ) {
			model.addAttribute( "regError", "Passwords must match.");
			model.addAttribute( "user", new User() );
			return "registration";
		}
		
//		creating user
		
		userService.createUser(user);
		session.setAttribute("username", user.getUsername());
		session.setAttribute("id", user.getId());
		session.setAttribute("user", userService.findById(user.getId()));
		return "redirect:/dashboard";
	}
	
	@PostMapping("process_login")
	public String process_login(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		
		System.out.println("\n\n<<-------------Processing User Login------------->>\n\n");
		System.out.println("Email: " + user.getEmail());
		System.out.println("Password: "  +user.getPassword());
		
		if (result.hasErrors()) {
			System.out.println("Problem found in login.");
			return "login_registration";
		}
		
		else if (userService.authenticateUser(user.getEmail(), user.getPassword())) {
			System.out.println("Authenticating User");
			
			session.setAttribute("name", userService.findByEmail(user.getEmail()).getUsername());
			session.setAttribute("id", userService.findByEmail(user.getEmail()).getId());
			
			System.out.println(session.getAttribute("id"));
			System.out.println("Name: " + session.getAttribute("name"));
			return "redirect:/dashboard";
		}
		
		else {
			System.out.println("Email and password does not match.");
			return "login";
		}
	}
	
	
}
