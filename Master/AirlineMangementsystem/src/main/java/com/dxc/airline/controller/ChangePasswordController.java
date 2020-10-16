package com.dxc.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airline.model.Admin;
import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.model.User;
import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.service.AdminSecurityServiceImplementation;
import com.dxc.airline.service.AdminServiceImplementation;
import com.dxc.airline.service.UserSecurityServiceImp;
import com.dxc.airline.service.UserServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ChangePasswordController {
	
	@Autowired
	AdminServiceImplementation adminServiceImplementation;
	
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@Autowired
	AdminSecurityServiceImplementation adminSecurityServiceImplementation;
	
	@Autowired
	UserSecurityServiceImp userSecurityServiceImp;
	
	Admin admin;
	User user;
	AdminSecurity adminSecurity;
	UserSecurity userSecurity;
	
	@PutMapping(path = "changepassword")
	@ResponseBody
	public Boolean checking(@RequestBody User e)
	{
		admin = new Admin(e.getUsername(), e.getPassword());
		 
		if(e.getUsername().endsWith("@dxc.com") && adminServiceImplementation.update(admin))
		{
			return true;
		}
		else 
			{
			return userServiceImplementation.update(e);
		}
	}

	@GetMapping(path = "Security")
	@ResponseBody
	public Boolean checkingQuestion(@RequestBody UserSecurity e)
	{
		adminSecurity = new AdminSecurity(e.getUsername(), e.getSecurityQuestion(),e.getAnswer());
		 
		AdminSecurity adminSecuritydb = adminSecurityServiceImplementation.findByid(e.getUsername());
		
		UserSecurity userSecuritydb = userSecurityServiceImp.findByUsername(e.getUsername());
	
		if(e.getUsername().endsWith("@dxc.com") && adminSecuritydb.getSecurityQuestion()== adminSecurity.getSecurityQuestion() && adminSecuritydb.getAnswer() == adminSecurity.getAnswer())
		{
			return true;
		}
		else 
			{
			return userSecuritydb.getSecurityQuestion()== e.getSecurityQuestion() && userSecuritydb.getAnswer() == e.getAnswer();
		}
	
	}


}
