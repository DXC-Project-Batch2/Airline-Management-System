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
	public boolean save(AdminInfo e) {
			
		boolean res=false;
		
		if(adminInfoRepository.save(e) != null)
		{
			return true;
		}
		return res;
			
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
