package com.dxc.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.service.UserSecurityServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserSecurityController {
	
	@Autowired
	UserSecurityServiceImp userSecurityServiceImp;
	
	@GetMapping(path = "usersecurity/{username}")
	@ResponseBody
	public UserSecurity getuserSecurity(@PathVariable("username") String username) {
		
		return userSecurityServiceImp.findByUsername(username);
	}
	
	@GetMapping(path = "usersecurity")
	@ResponseBody
	public List<UserSecurity> getUserSecurities(){
		
		return userSecurityServiceImp.findAll();
	}
	
	@PostMapping(path = "usersecurity")
	@ResponseBody
	public UserSecurity save(@RequestBody UserSecurity userSecurity) {
		
		return userSecurityServiceImp.add(userSecurity);
	}
	
	@PutMapping(path = "usersecurity")
	@ResponseBody
	public UserSecurity update(@RequestBody UserSecurity userSecurity) {
		
		return userSecurityServiceImp.update(userSecurity);
	}
	
	@DeleteMapping(path = "usersecurity/{username}")
	@ResponseBody
	public void delete(@PathVariable("username") String username) {
		
		userSecurityServiceImp.deleteById(username);
	}
	
	
}
