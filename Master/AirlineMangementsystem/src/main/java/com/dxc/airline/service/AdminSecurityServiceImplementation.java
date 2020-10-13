package com.dxc.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.repository.AdminSecurityRepository;
@Service
public class AdminSecurityServiceImplementation  implements AdminSecurityService<AdminSecurity> {

	@Autowired
	AdminSecurityRepository adminSecurityRepository;
	
	@Override
	public AdminSecurity save(AdminSecurity e) {

		return adminSecurityRepository.save(e);
	}

	@Override
	public List<AdminSecurity> findByUsername(String username) {
	return adminSecurityRepository.findByUsername(username);
	}

	@Override
	public List<AdminSecurity> findAll() {
		return adminSecurityRepository.findAll();
	}

	@Override
	public boolean update(AdminSecurity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		adminSecurityRepository.deleteById(username);
		return true;
	}

}
