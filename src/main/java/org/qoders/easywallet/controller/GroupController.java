package org.qoders.easywallet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.qoders.easywallet.domain.Group;
import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.service.GroupService;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/group")
public class GroupController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	GroupService groupService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET )
	public String addGroup(Model model)
	{
		return "create_group";
		
	}
	@RequestMapping(value="/add", method=RequestMethod.POST )
	public String saveGroup(@valid @ModelAttribute(value="newgroup") Group newgroup, BindingResult result, RedirectAttributes redirect)
	{
		
		if (result.hasErrors()) {
			return "create_group";
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		Set<User> userList = new HashSet<User>();
		for (User u : newgroup.getMembers()) {
			String email = u.getEmail();
			User tmpUser = userService.findUserByEmail(email);
			
			userList.add(tmpUser);
		}
		newgroup.setOwner(user);
		List<User> list = new ArrayList<User>(userList);
		newgroup.setMembers(list);
		groupService.createGroup(newgroup);
		
		List <Group> groupList = groupService.findGroupByUser(user);
		// get all groups owned or member of that group
		redirect.addFlashAttribute("groupList", groupList);
		return "redirect:/group/list";
		
	}
	@RequestMapping(value="/search-member", method=RequestMethod.GET)
	public @ResponseBody Map <String, Object> searchMember (Model model, @RequestParam(value="q") String query) {
		Map <String, Object> result = new HashMap<String, Object>();
		result.put("userlist", userService.findByUserOrEmail(query));
		
		
		return result;
		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listGroup(Model model, @ModelAttribute (value="newgroup") Group newgroup)
	{
		System.out.println(newgroup.getTitle());
		model.addAttribute("group",newgroup);
		return "list_groups";
		
	}
	

}
