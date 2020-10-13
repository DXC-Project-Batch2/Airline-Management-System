package com.dxc.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.repository.UserSecurityRepository;

@Service
public class UserSecurityServiceImp implements IUserSecurityService {
	
	@Autowired
	UserSecurityRepository repo;

	@Override
	@Transactional
	public UserSecurity add(UserSecurity security) {
		
		return repo.save(security);
	}

	@Override
	@Transactional
	public List<UserSecurity> findByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	@Transactional
	public List<UserSecurity> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	@Transactional
	public boolean update(UserSecurity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		repo.deleteById(username);
		
	}

}
