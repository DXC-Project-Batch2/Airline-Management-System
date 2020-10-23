package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.UserInfo;
import com.dxc.airline.repository.UserInfoRepository;

@Service
public class UserInfoServiceImplementation implements UserInfoService<UserInfo> {

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Override
	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return userInfoRepository.findAll();
	}

	@Override
	public UserInfo save(UserInfo e) {
		// TODO Auto-generated method stub
		return userInfoRepository.save(e);
	}
	
	@Override
	public UserInfo update(UserInfo e) {
		// TODO Auto-generated method stub
		Optional<UserInfo> findUserById = userInfoRepository.findById(e.getUsername());
		if (findUserById.isPresent()) {
			return userInfoRepository.save(e);
		}
		return null;
	}

	@Override
	public UserInfo findByUsername(String username) {
		// TODO Auto-generated method stub
		Optional<UserInfo> userInfo =userInfoRepository.findById(username);
		if(userInfo.isPresent())
		{
			return userInfo.get();
		}
		return null;
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		userInfoRepository.deleteById(username);
	}

}
