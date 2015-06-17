package org.qoders.easywallet.service;

import java.util.List;

import org.qoders.easywallet.domain.User;
/**
 * 
 * @author Nhu Trinh
 *
 */
public interface UserService {
	
	public List<User> findAllUser();
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public String encryptPassword(String password);
	public void save(User user);
	
}
