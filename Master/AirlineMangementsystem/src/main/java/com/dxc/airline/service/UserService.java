package com.dxc.airline.service;

import java.util.List;

import com.dxc.airline.model.User;

public interface UserService {

	public List<User> findAll();

	public void save(User theUser);

	public User findById(String username);

	public void deleteById(String username);
	
}