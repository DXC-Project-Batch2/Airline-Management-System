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

import com.dxc.airline.model.Admin;
import com.dxc.airline.service.AdminServiceImplementation;



@RestController
public class AdminController {

	@Autowired
	AdminServiceImplementation adminServiceImplementation;
	
	@GetMapping(path = "Admin/{username}")
	@ResponseBody
	public Admin getUserInfo(@PathVariable("username") String username) {
		
		return adminServiceImplementation.findById(username);
	}
	
	@GetMapping(path = "admin")
	@ResponseBody
	public List<Admin> getUsers(){
		
		return adminServiceImplementation.findAll();
	}
	
	@PostMapping("/Admin")
	public Admin addUser(@RequestBody Admin e) {
		
		adminServiceImplementation.save(e);
		
		return e;
	}

	
	@PutMapping("/Admin")
	@ResponseBody
	public Admin update(@RequestBody Admin e) {
		
		 adminServiceImplementation.save(e);
		 return e;
	}
	
	@DeleteMapping(path = "admin/{username}")
	@ResponseBody
	public void delete(@PathVariable("username") String username) {
		
		adminServiceImplementation.deleteById(username);
	}
}
