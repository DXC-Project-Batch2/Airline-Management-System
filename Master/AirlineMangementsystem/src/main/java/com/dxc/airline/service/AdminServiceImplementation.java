package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Admin update(Admin e) {
		// TODO Auto-generated method stub
		Optional<Admin> adminpresent = adminRepository.findById(e.getUsername());
		if(adminpresent.isPresent()) {
		return adminRepository.save(e);
		}
		return null;
	}
	
	@Override
	public Admin findById(String username) {
		// TODO Auto-generated method stub
		return adminRepository.findById(username).orElse(new Admin());
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(username);
	}
	

}
