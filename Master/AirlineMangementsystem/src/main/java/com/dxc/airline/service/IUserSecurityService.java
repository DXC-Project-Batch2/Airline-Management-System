package com.dxc.airline.service;



import org.springframework.stereotype.Service;

import com.dxc.airline.model.UserSecurity;

@Service
public interface IUserSecurityService {
	
	public UserSecurity add(UserSecurity security);
	
	public UserSecurity findById(long id);

}
