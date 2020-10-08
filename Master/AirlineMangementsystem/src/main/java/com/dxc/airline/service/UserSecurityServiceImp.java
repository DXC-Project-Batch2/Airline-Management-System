package com.dxc.airline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.repository.UserSecurityRepository;

@Service
public class UserSecurityServiceImp implements IUserSecurityService {
	
	@Autowired
	UserSecurityRepository repo;

	@Override
	public UserSecurity add(UserSecurity security) {
		
		return repo.save(security);
	}

	@Override
	public UserSecurity findById(long id) {
		Optional<UserSecurity> users = repo.findById(id);
		return users.get();
	}

}
