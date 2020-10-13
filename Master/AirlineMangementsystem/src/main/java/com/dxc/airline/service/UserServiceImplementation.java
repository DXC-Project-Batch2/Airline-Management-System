package com.dxc.airline.service;

import java.util.List;

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
	public Boolean save(User theUser) {
		
		Boolean res=false;
		
		if(userRepository.save(theUser) != null)
		{
			res=true;
			return res;
		}
		return res;
	}

	@Override
	@Transactional
	public User findById(String username) {
		
		User user = userRepository.findById(username).orElse(new User());
		return user;
	}

	@Override
	@Transactional
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		userRepository.deleteById(username);
	}

	
}