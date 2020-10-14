package com.dxc.airline.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.UserSecurity;

@Service
public interface IUserSecurityService {
	
	public UserSecurity add(UserSecurity security);
	
	public List<UserSecurity> findByUsername(String username);
	
	public List<UserSecurity> findAll();
	
	public UserSecurity update(UserSecurity e);

	public void deleteById(String username);


}
