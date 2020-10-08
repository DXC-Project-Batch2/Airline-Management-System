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
		return userRepository.findAll();	}

	@Override
	@Transactional
	public void save(User theUser) {
		
		userRepository.save(theUser);
	}

	@Override
	@Transactional
	public User findById(long id) {
		Optional<User> result = userRepository.findById(id);
		
		User theUser = null;
		
		if (result.isPresent()) {
			theUser = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find user id - " + id);
		}
		
		return theUser;
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	
}