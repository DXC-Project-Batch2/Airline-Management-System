package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.repository.AdminInfoRepository;

public class AdminInfoServiceImplementation implements AdminInfoService<AdminInfo>{

	@Autowired
	AdminInfoRepository adminInfoRepository;
	
	@Override
	public boolean save(AdminInfo e) {
		
		boolean res=false;
		if(adminInfoRepository.save(e) != null)
		{
			res=true;
		}
		return res;
	}

	@Override
	public AdminInfo find(long id) {
		Optional<AdminInfo> adminInfo = adminInfoRepository.findById(id);
		return adminInfo.get();
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
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		adminInfoRepository.deleteById(id);
		return true;
	}

}
