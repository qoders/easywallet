package org.qoders.easywallet.controller;

import java.util.List;

import org.qoders.easywallet.domain.Companion;
import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.service.CompanionService;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Dashboard
 * @author Nhu Trinh
 *
 */
@Controller
@RequestMapping(value="/dashboard")
public final class DashboardController {
	
	@Autowired
	CompanionService comService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String dashboard(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		List<Companion> ownList = comService.findActiveByUser(user);
		List<Companion> haveList = comService.findActiveByOwner(user);
		
		Double totalOwn = comService.getTotalAmount(ownList);
		Double totalHave = comService.getTotalAmount(haveList);		
		Double total = totalHave - totalOwn;
		
		model.addAttribute("totalOwn", totalOwn);
		model.addAttribute("totalHave", totalHave);
		model.addAttribute("total", total);
		model.addAttribute("ownList", ownList);
		model.addAttribute("haveList", haveList);
		return "dashboard";
	}
	
	
}
