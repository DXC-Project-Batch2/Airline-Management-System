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
import com.dxc.airline.model.security;
import com.dxc.airline.model.u;
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
	public Boolean checking(@RequestBody u e)
	{	 
		if(e.getUsername().endsWith("@dxc.com")) 
		{
			admin = new Admin(e.getUsername(), e.getPassword());
			if(adminServiceImplementation.update(admin)!=null)
			{
			return true;
			}
		}
		else if(e.getUsername().endsWith("@gmail.com") || e.getUsername().endsWith("@yahoo.com"))
			{
			user = new User(e.getUsername(), e.getPassword());
			if(userServiceImplementation.update(user)!=null)
			{
			return true;
			}
		}
		return null;
	}

	@GetMapping(path = "Security")
	@ResponseBody
	public Boolean checkingQuestion(@RequestBody security e)
	{
		if(e.getUsername().endsWith("@dxc.com")) {
			adminSecurity = new AdminSecurity(e.getUsername(), e.getSecurityQuestion(),e.getAnswer());
			AdminSecurity adminSecuritydb = adminSecurityServiceImplementation.findByid(e.getUsername());
			if(adminSecuritydb.getSecurityQuestion()== adminSecurity.getSecurityQuestion() && adminSecuritydb.getAnswer() == adminSecurity.getAnswer())
			{
			return true;
			}
		}
		else if(e.getUsername().endsWith("@gmail.com") || e.getUsername().endsWith("@yahoo.com"))
		{
			userSecurity = new UserSecurity(e.getUsername(), e.getSecurityQuestion(),e.getAnswer());
			UserSecurity userSecuritydb = userSecurityServiceImp.findByUsername(e.getUsername());		
			if(userSecuritydb.getSecurityQuestion()== userSecurity.getSecurityQuestion() && userSecuritydb.getAnswer() == userSecurity.getAnswer())
			{
			return true;
			}
		}
		return null;
	
	}


}
