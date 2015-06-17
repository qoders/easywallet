package org.qoders.easywallet.controller;

import java.util.Locale;
import java.util.Map;

import org.qoders.easywallet.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 * @author Nhu Trinh
 */
@Controller
public class HomeController {
	
	/*
	 * Get single instance of language service using auto wire
	 */
	@Autowired
	LanguageService languageService;
	

	/**
	 * Serve request from home, index page /
	 * @param locale
	 * @param model
	 * @return index
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {			
		Map<String, String> languages = languageService.getAvailableLanguage();
		
		model.addAttribute("languages", languages);
		model.addAttribute("language", locale.getDisplayLanguage(locale));
		
		return "index";
	}
	
	@RequestMapping(value="/upload/")
	public String upload(){
		return "upload";
	}
	
}