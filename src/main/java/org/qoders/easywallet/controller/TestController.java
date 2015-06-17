package org.qoders.easywallet.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.service.EmailService;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Just for testing purpose
 * @author Nhu Trinh
 *
 */

@Controller
public class TestController {
	@Autowired
	UserService uService;
	
	@Autowired
	ServletContext context;
	
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
	
	//Use this when user activate their email
	@RequestMapping(value="/autoLogin")
	public String testAutoLogin(Model model){
		User james = uService.findUserByEmail("spyjamesbond0072003@gmail.com");
		Authentication authentication =  new UsernamePasswordAuthenticationToken(james, null, james.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/";
	}
	
	@Autowired
	EmailService mail;
	
	@RequestMapping(value="/testMail")
	public String testSendMail(){
		mail.sendMail("spyjamesbond0072003@gmail.com", "Hello", "From Nhu Trinh");
		return "redirect:/";
	}
	
	@RequestMapping(value="/testHtmlMail")
	public String testSendHtmlMail(){
		HashMap<String, Object> mailModel = new HashMap<String, Object>();
		mailModel.put("firstName", "Nhu");
		mailModel.put("lastName", "Trinh");
		mail.sendHtmlMail("spyjamesbond0072003@gmail.com", "Hi new member", "", 
				"emails/welcome.vm", mailModel );
		return "redirect:/";
	}
	
	@RequestMapping(value="/testBcrypt")
	public @ResponseBody String testBcrypt(){
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		//Check match
		//b.matches(rawPassword, encodedPassword)
		System.out.print(b.encode("admin"));
		return b.encode("admin");
	}
	
}
