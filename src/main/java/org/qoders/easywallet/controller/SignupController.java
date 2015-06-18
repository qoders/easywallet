package org.qoders.easywallet.controller;

import java.util.HashMap;
import java.util.UUID;

import javax.validation.Valid;

import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.domain.Verification;
import org.qoders.easywallet.service.EmailService;
import org.qoders.easywallet.service.UserService;
import org.qoders.easywallet.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {
	@Autowired UserService userservice;
	@Autowired VerificationService verificationService;
	@Autowired
	EmailService mail;
	
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupRequest()
	{
		
		return "signup";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addNewUser(@Valid @ModelAttribute("userDetail") User user,BindingResult result, 
			Model model)
	{
		if(result.hasErrors())
		{
			return "signup";	
		}
		User existUser = userservice.findUserByEmail(user.getEmail());
		if (existUser != null){
			result.rejectValue("email", "error.user", "An account already exists for this email.");
			return "signup";
		}
		existUser = userservice.findUserByUsername(user.getUsername());
		if (existUser != null){
			result.rejectValue("username", "error.user", "An account already exists for this username.");
			return "signup";
		}
		user.setPassword(userservice.encryptPassword(user.getPassword()));
		
		userservice.save(user);
		model.addAttribute("email",user.getEmail());
		// verification code 
		String code=UUID.randomUUID().toString();
		 verificationService.save(new Verification(user.getEmail(),code));
		//send email
		 HashMap<String, Object> mailModel = new HashMap<String, Object>();
		mailModel.put("user",user);
		mailModel.put("code",code);
		mail.sendHtmlMail(user.getEmail(), "Hi new member", "", 
				"emails/verification.vm", mailModel );
		
		return "verification";
	}
	
	

}
