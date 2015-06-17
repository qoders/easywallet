package org.qoders.easywallet.controller;

import java.util.List;

import org.qoders.easywallet.domain.Authority;
import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
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
		
		List<User> users = uService.findAllUser();
		
		User u = users.get(0);
		for(GrantedAuthority a : u.getAuthorities()){
			System.out.println(a.getAuthority());
		};
		model.addAttribute("users", users);
		return "testAdd";
	}
	
}
