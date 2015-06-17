package org.qoders.easywallet.service.impl;

import java.util.List;

import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.repository.UserRepository;
import org.qoders.easywallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> findAllUser() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public void save(User user) {
		userRepo.save(user);
		
	}

	@Override
	public String encryptPassword(String password) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		//Check match
		//b.matches(rawPassword, encodedPassword)
		System.out.print(b.encode(password));
		return b.encode(password);
	}

}
