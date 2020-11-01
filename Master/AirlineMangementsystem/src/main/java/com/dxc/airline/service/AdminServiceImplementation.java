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
		List<Admin> admins = adminRepository.findAll();
		if(admins!=null)
		{
			return admins;
		}
		return null;
	}

	@Override
	public Admin save(Admin e) {
		// TODO Auto-generated method stub
		if(e!=null) {
		return adminRepository.save(e);
		}
		return null;
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
		Optional<Admin> admin =adminRepository.findById(username);
		if(admin.isPresent())
		{
			return admin.get();
		}
		return null;

	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(username);
	}

	@Override
	public Admin findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		if(username!=null && password!=null) {
			return adminRepository.findByUsernameAndPassword(username, password);
		}
			return null;
	
	}
	
	

}
