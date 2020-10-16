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

import com.dxc.airline.model.AdminInfo;

import com.dxc.airline.service.AdminInfoServiceImplementation;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminInfoController {
	
	@Autowired
	AdminInfoServiceImplementation adminInfoServiceImplementation;
	
	@GetMapping(path = "admininfo/{username}")
	@ResponseBody
	public AdminInfo getUserInfo(@PathVariable("username") String username) {
		
		return adminInfoServiceImplementation.findByUsername(username);
	}
	
	@GetMapping(path = "admininfo")
	@ResponseBody
	public List<AdminInfo> getAdminInfos(){
		
		return adminInfoServiceImplementation.findAll();
	}
	
	@PostMapping(path = "admininfo" )
	@ResponseBody
	public AdminInfo save(@RequestBody AdminInfo adminInfo) {
		
		return adminInfoServiceImplementation.save(adminInfo);
	}
	
	@PutMapping(path = "admininfo")
	@ResponseBody
	public boolean update(@RequestBody AdminInfo adminInfo) {
		
		return adminInfoServiceImplementation.update(adminInfo);
	}
	
	@DeleteMapping(path = "admininfo/{username}")
	@ResponseBody
	public void delete(@PathVariable("username") String username) {
		
		adminInfoServiceImplementation.delete(username);
	}

}
