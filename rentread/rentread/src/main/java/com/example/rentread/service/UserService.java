package com.example.rentread.service;

import org.springframework.stereotype.Service;

import com.example.rentread.entity.User;
import com.example.rentread.repository.UserRepository;
import com.example.rentread.utils.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (user.getRole() == null) {
			user.setRole(Role.USER);
		}
		return userRepository.save(user);
	}
}
