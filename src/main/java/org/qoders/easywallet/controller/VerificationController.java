package org.qoders.easywallet.controller;

import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.domain.Verification;
import org.qoders.easywallet.service.UserService;
import org.qoders.easywallet.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VerificationController {
	@Autowired VerificationService verificationService;
	@Autowired UserService userservice;
	
	@RequestMapping(value="/verifyUser/{email}/{code}", method=RequestMethod.GET)
	public String verificationCode(@PathVariable(value="email")String email,@PathVariable(value="code")String code,final RedirectAttributes redirectAttributes)
	{
		
		Verification var=verificationService.verify(email, code);
		if(var!=null)
		{
			User user =userservice.findUserByEmail(email);
			user.setEnabled(true);
			userservice.save(user);
			Authentication authentication =  new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:/";
			
		}
		return "error";
		
	}
	
	
//	@RequestMapping(value="/verifyUser/{email}/{code}")
//	public String verificationCode(@Valid @ModelAttribute("verificationDetail")Verification verify,BindingResult result,Model model)
//	{
//		if(result.hasErrors())
//		{
//			return "verification";
//		}
//		
//		return "verified";
//	}

}
