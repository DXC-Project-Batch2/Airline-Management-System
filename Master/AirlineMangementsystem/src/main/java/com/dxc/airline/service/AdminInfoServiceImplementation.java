package com.dxc.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.repository.AdminInfoRepository;
@Service
public class AdminInfoServiceImplementation implements AdminInfoService<AdminInfo>{

	@Autowired
	AdminInfoRepository adminInfoRepository;
	
	@Override
	public AdminInfo save(AdminInfo e) {
		
		return adminInfoRepository.save(e);
	}

	@Override
	public AdminInfo findByUsername(String username) {
		return adminInfoRepository.findById(username).orElse(new AdminInfo());
	}

	@Override
	public List<AdminInfo> findAll() {
		return adminInfoRepository.findAll();
	}

	@Override
	public boolean update(AdminInfo e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		adminInfoRepository.deleteById(username);
		return true;
	}

}
