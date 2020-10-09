package com.dxc.airline.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.UserSecurity;

@Service
public interface IUserSecurityService {
	
	public UserSecurity add(UserSecurity security);
	
	public UserSecurity findById(String username);
	
	public List<UserSecurity> findAll();
	
	public boolean update(UserSecurity e);

	public void deleteById(String username);


}
