package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

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
			
		if(e!=null)
		{
		return adminInfoRepository.save(e);	
		}
		return null;
	}

	@Override
	public AdminInfo findByUsername(String username) {
		Optional<AdminInfo> adminInfo =adminInfoRepository.findById(username);
		if(adminInfo.isPresent())
		{
			return adminInfo.get();
		}
		return null;
	}

	@Override
	public List<AdminInfo> findAll() {
		return adminInfoRepository.findAll();
	}

	@Override
	public AdminInfo update(AdminInfo e) {
		Optional<AdminInfo> adminInfo =adminInfoRepository.findById(e.getUsername());
		if(adminInfo.isPresent())
		{
			return adminInfoRepository.save(e);
		}
		return null;
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		adminInfoRepository.deleteById(username);
	}

}
