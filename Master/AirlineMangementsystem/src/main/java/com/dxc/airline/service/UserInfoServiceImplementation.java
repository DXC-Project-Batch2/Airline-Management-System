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
	public UserInfo update(UserInfo e) {
		// TODO Auto-generated method stub
		Optional<UserInfo> findUserById = userInfoRepository.findById(e.getUsername());
		if (findUserById.isPresent()) {
			userInfoRepository.save(e);
		}
		return e;
	}

	@Override
	public UserInfo findByUsername(String username) {
		// TODO Auto-generated method stub
		return userInfoRepository.findById(username).orElse(new UserInfo());
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		userInfoRepository.deleteById(username);
	}

}
