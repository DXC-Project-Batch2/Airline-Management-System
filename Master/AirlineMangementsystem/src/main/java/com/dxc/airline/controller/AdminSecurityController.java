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

import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.service.AdminSecurityServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminSecurityController {

	@Autowired
	AdminSecurityServiceImplementation adminSecurityServiceImplementation;
	
	@GetMapping("AdminSecurity")
	@ResponseBody
	public List<AdminSecurity> getAdminSecurity()
	{
		List<AdminSecurity> adminSecurity = (List<AdminSecurity>) adminSecurityServiceImplementation.findAll();
		return adminSecurity;
	}
	
	@GetMapping(path="AdminSecurity/{username}")
	@ResponseBody
	public AdminSecurity getAdminSecurity(@PathVariable("username") String username) 
	{
		return adminSecurityServiceImplementation.findByid(username);
	}
	
	@PostMapping(path ="AdminSecurity")
	@ResponseBody
	public AdminSecurity save(@RequestBody AdminSecurity adminSecurity)
	{
		return adminSecurityServiceImplementation.save(adminSecurity);
	}
	
	@PutMapping(path = "AdminSecurity")
	@ResponseBody
	public AdminSecurity update(@RequestBody AdminSecurity adminSecurity) {
		
		return adminSecurityServiceImplementation.update(adminSecurity);
		
	}
	
	@DeleteMapping(path = "AdminSecurity/{username}")
	@ResponseBody
	public void delete(@PathVariable("username") String username) {
		
		adminSecurityServiceImplementation.delete(username);
	}
	
	
	
}
