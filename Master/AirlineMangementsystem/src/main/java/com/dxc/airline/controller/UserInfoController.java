package com.dxc.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airline.model.UserInfo;
import com.dxc.airline.service.UserInfoServiceImplementation;

@RestController
public class UserInfoController {
	
	@Autowired
	UserInfoServiceImplementation userInfoServiceImplementation;
	
	@GetMapping(path = "userinfo/{username}")
	@ResponseBody
	public UserInfo getUserInfo(@PathVariable("username") String username) {
		
		return userInfoServiceImplementation.findById(username);
	}
	
	@GetMapping(path = "userinfos")
	@ResponseBody
	public List<UserInfo> getUserInfos(){
		
		return userInfoServiceImplementation.findAll();
	}
	
	@PostMapping(path = "userinfo" )
	@ResponseBody
	public boolean save(@RequestBody UserInfo userInfo) {
		
		return userInfoServiceImplementation.save(userInfo);
	}
	
	@PutMapping(path = "userinfo")
	@ResponseBody
	public UserInfo update(@RequestBody UserInfo userInfo) {
		
		return userInfoServiceImplementation.update(userInfo);
	}
	
	@DeleteMapping(path = "userinfo/{username}")
	@ResponseBody
	public void delete(@PathVariable("username") String username) {
		
		userInfoServiceImplementation.deleteById(username);
	}
}
