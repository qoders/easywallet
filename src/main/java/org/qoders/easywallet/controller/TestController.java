package org.qoders.easywallet.controller;

import java.util.List;

import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Just for testing purpose
 * @author Nhu Trinh
 *
 */

@Controller
public class TestController {
	@Autowired
	UserService uService;
	
	@RequestMapping(value="/testUserAdd")
	public String testAddUser(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		System.out.println(user.getEmail());
		
		List<User> users = uService.findAllUser();
		
		for(GrantedAuthority a : auth.getAuthorities()){
			System.out.println(a.getAuthority());
		};
		model.addAttribute("users", users);
		return "testAdd";
	}
	
}
