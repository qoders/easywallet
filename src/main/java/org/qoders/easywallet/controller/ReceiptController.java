package org.qoders.easywallet.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.qoders.easywallet.domain.Companion;
import org.qoders.easywallet.domain.Group;
import org.qoders.easywallet.domain.Receipt;
import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.service.GroupService;
import org.qoders.easywallet.service.ReceiptService;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/receipt")
public class ReceiptController {
	@Autowired
	UserService userService;
	
	@Autowired
	ReceiptService receiptService;
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET )
	public String addReceipt(Model model)
	{
		return "add_receipt";
		
	}
	@RequestMapping(value="/add", method=RequestMethod.POST )
	public String saveReceipt(@ModelAttribute(value="newreceipt") Receipt newreceipt, BindingResult result)
	{
		for(FieldError fe: result.getFieldErrors()){
			System.out.println(fe.getField());
			System.out.println(fe.getDefaultMessage());
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		List<Companion> compList = newreceipt.getCompanions();
		//newreceipt.setCompanions(new LinkedList<Companion>());
		newreceipt.setOwner(user);
		//receiptService.createReceipt(newreceipt);
		
		for (Companion c : compList) {
			User tmpUser = c.getCompanion();
			String email = tmpUser.getEmail();
			User cUser = userService.findUserByEmail(email);
			c.setCompanion(cUser);
			c.setOwner(user);
			
			
		} 
		newreceipt.setCompanions(compList);
		receiptService.createReceipt(newreceipt);
		
		// get all groups owned or member of that group
		//redirect.addFlashAttribute("groupList", groupList);
		return "redirect:/dashboard";
		
	}
	@RequestMapping(value="")
	public String requestReceiptPage()
	{
		return "add_receipt";
	}

}
