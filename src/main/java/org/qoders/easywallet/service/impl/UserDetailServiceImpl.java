package org.qoders.easywallet.service.impl;

import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService uService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = uService.findUserByUsername(username);
		if (user==null){
			throw new UsernameNotFoundException("Invalid User");
		}
		return user;
	}

}
