package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.User;
@Service
public interface UserService {

	public List<User> findAll();

	public User update(User e);
	
	public User save(User theUser);

	public User findById(String username);

	public void deleteById(String username);
	
	public User findByUsernameAndPassword(String username,String password);
	
}