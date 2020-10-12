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
	public boolean save(AdminSecurity e) {

		boolean res=false;
		if(adminSecurityRepository.save(e) != null)
		{
			res=true;
		}
		return res;
	}

	@Override
	public AdminSecurity find(String username) {
		Optional<AdminSecurity> adminInfo = adminSecurityRepository.findById(username);
		return adminInfo.get();
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
