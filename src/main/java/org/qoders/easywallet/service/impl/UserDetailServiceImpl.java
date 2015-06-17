package org.qoders.easywallet.service.impl;

import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Custom User Detail service, used for Authentication
 * @author Nhu Trinh
 *
 */
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService uService;

	/**
	 * Custom user authenticate, First use email, then fallback to username
	 * @param loginCredential Either username or email
	 */
	@Override
	public UserDetails loadUserByUsername(String loginCredential)
			throws UsernameNotFoundException {
		User user = uService.findUserByEmail(loginCredential);
		if (user==null){
			user = uService.findUserByUsername(loginCredential);
		}
		if (user==null){
			throw new UsernameNotFoundException("Invalid User");
		}
		return user;
	}

}
