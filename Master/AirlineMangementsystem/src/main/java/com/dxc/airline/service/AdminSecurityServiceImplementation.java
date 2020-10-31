package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

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

		if(e!=null)
		{
		return adminSecurityRepository.save(e);	
		}
		return null;	}

	@Override
	public AdminSecurity findByid(String username) {
		Optional<AdminSecurity> adminSecurity =adminSecurityRepository.findById(username);
		if(adminSecurity.isPresent())
		{
			return adminSecurity.get();
		}
		return null;
	}

	@Override
	public List<AdminSecurity> findAll() {
		return adminSecurityRepository.findAll();
	}

	@Override
	public AdminSecurity update(AdminSecurity e) {
		
		Optional<AdminSecurity> adminpresent = adminSecurityRepository.findById(e.getUsername());
		if(adminpresent.isPresent()) {
		return adminSecurityRepository.save(e);
		}
		return null;
		}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		adminSecurityRepository.deleteById(username);
		
	}

}
