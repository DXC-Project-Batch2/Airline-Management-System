package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dxc.airline.model.UserInfo;
import com.dxc.airline.repository.UserInfoRepository;

public class UserInfoServiceImplementation implements UserInfoService<UserInfo> {

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Override
	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return userInfoRepository.findAll();
	}

	@Override
	public boolean save(UserInfo e) {
		// TODO Auto-generated method stub
		boolean res = false;
		if(res = userInfoRepository.save(e) != null)
		{
			res = true;
		}
		return res;

	}

	/*@Override
	public boolean update(UserInfo e) {
		// TODO Auto-generated method stub
		boolean res = false;
		Optional<UserInfo> userpresent = userInfoRepository.findById(e.getId());
		if(userpresent.isPresent()) {
			res = userInfoRepository.save(e) != null;
		}
		return res;
	}*/
	
	@Override
	public boolean update(UserInfo e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo findById(long id) {
		// TODO Auto-generated method stub
		Optional<UserInfo> res = userInfoRepository.findById(id);
		return res.get();
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userInfoRepository.deleteById(id);
	}

}