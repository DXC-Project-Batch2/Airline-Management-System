package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.airline.model.User;
import com.dxc.airline.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

	public UserServiceImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public List<User> findAll() {
		
		return userRepository.findAll();	
		
	}

	@Override
	@Transactional
	public User save(User theUser) {
		
	return userRepository.save(theUser);
	
	}

	@Override
	@Transactional
	public User findById(String username) {
		return userRepository.findById(username).orElse(new User());
	}

	@Override
	@Transactional
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		userRepository.deleteById(username);
	}

	@Override
	public User update(User e) {
		
		Optional<User> userpresent = userRepository.findById(e.getUsername());
		if(userpresent.isPresent()) {
			return userRepository.save(e);
		}
		return null;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	
	
}