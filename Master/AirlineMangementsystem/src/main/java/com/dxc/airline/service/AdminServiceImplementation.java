package com.dxc.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.Admin;
import com.dxc.airline.repository.AdminRepository;

@Service
public class AdminServiceImplementation implements AdminService<Admin> {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		
		System.out.println(adminRepository.findAll());
		return adminRepository.findAll();
	}

	@Override
	public Admin save(Admin e) {
		// TODO Auto-generated method stub
		return adminRepository.save(e);
		}

	/*@Override
	public boolean update(Admin e) {
		// TODO Auto-generated method stub
		boolean res = false;
		Optional<Admin> adminpresent = adminRepository.findById(e.getId());
		if(adminpresent.isPresent()) {
			res = adminRepository.save(e) != null;
		}
		return res;
	}*/
	
	@Override
	public boolean update(Admin e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Admin> findByUsername(String username) {
		// TODO Auto-generated method stub
		return adminRepository.findByUsername(username);
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(username);
	}
	

}
