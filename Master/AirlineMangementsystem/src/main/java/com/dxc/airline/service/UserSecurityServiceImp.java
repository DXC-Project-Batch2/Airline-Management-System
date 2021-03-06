package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

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
		
		if(security!=null)
		{
			return repo.save(security);			
		}
		return null;
	}

	@Override
	@Transactional
	public UserSecurity findByUsername(String username) {
		Optional<UserSecurity> present = repo.findById(username);
		if(present.isPresent()) {
			return present.get();
		}
		return null;
	}

	@Override
	@Transactional
	public List<UserSecurity> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	@Transactional
	public UserSecurity update(UserSecurity e) {
		// TODO Auto-generated method stub
		Optional<UserSecurity> findUserById = repo.findById(e.getUsername());
		if (findUserById.isPresent()) {
			return repo.save(e);
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		repo.deleteById(username);
		
	}

}
