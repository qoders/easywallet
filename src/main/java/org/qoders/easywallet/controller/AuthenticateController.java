package org.qoders.easywallet.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticateController {
	
	@Autowired  
    private MessageSource messageSource;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 
	@RequestMapping(value="/login-fail/{reason}", method = RequestMethod.GET)
	public String loginerror(Locale locale, Model model, @PathVariable final String reason) {
		String errorMessage = messageSource.getMessage("Form.Login.BadCredentials", null, locale);
		if(reason != null){
			try{
				errorMessage = messageSource.getMessage("Form.Login."+reason, null, locale);
			}catch(Exception ex){
				
			}
		}
		model.addAttribute("error", errorMessage);
		return "login";
 
	}
 
	@RequestMapping(value="/loggedout", method = RequestMethod.GET)
	public String logout(Model model) {
 		return "redirect:/";
 	}
	
}
