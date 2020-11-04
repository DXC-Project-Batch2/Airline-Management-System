package com.dxc.airline.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.dxc.airline.model.Admin;
import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.model.Registration;
import com.dxc.airline.model.User;
import com.dxc.airline.model.UserInfo;
import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.service.AdminInfoServiceImplementation;
import com.dxc.airline.service.AdminSecurityServiceImplementation;
import com.dxc.airline.service.AdminServiceImplementation;
import com.dxc.airline.service.UserInfoServiceImplementation;
import com.dxc.airline.service.UserSecurityServiceImp;
import com.dxc.airline.service.UserServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

	@Autowired
	UserInfoServiceImplementation userInfoServiceImplementation;

	@Autowired
	UserServiceImplementation userServiceImplementation;

	@Autowired
	AdminInfoServiceImplementation adminInfoServiceImplementation;

	@Autowired
	AdminServiceImplementation adminServiceImplementation;

	@Autowired
	AdminSecurityServiceImplementation adminSecurityServiceImplementation;

	@Autowired
	UserSecurityServiceImp userSecurityServiceImp;

	User user;
	UserInfo userinfo;
	UserSecurity userSecurity;
	Admin admin;
	AdminInfo adminInfo;
	AdminSecurity adminSecurity;

	@GetMapping(path = "Registration/{username}")
	@ResponseBody
	public List<?> getInfo(@PathVariable("username") String username) {

		if (username.endsWith("@dxc.com")) {
			return (List<AdminInfo>) adminInfoServiceImplementation.findByUsername(username);
		} else {
			return (List<UserInfo>) userInfoServiceImplementation.findByUsername(username);
		}
	}

	@PostMapping("Registration")
	@ResponseBody
	public Boolean addUser(@RequestBody Registration e) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = dateFormat.format(e.getDob());
		String strExpiry = dateFormat.format(e.getExpiry());

		if (e.getUsername().endsWith("@dxc.com")) {
			admin = new Admin(e.getUsername(), e.getPassword());
		
			adminInfo = new AdminInfo(e.getName(), e.getLastname(), e.getGender(), strDate, e.getFathername(),
					e.getPassportname(), e.getPassportnumber(), strExpiry, e.getDoorNumber(), e.getStreet(),
					e.getArea(), e.getCountry(), e.getState(), e.getCity(), e.getPostalCode(), e.getLandMark(),
					e.getMobile(), e.getUsername());
		
			adminSecurity = new AdminSecurity(e.getUsername(), e.getSecurityQuestion(), e.getAnswer());
		
			adminInfoServiceImplementation.save(adminInfo);
			adminServiceImplementation.save(admin);
			adminSecurityServiceImplementation.save(adminSecurity);

		} else {
			user = new User(e.getUsername(), e.getPassword());

			userinfo = new UserInfo(e.getName(), e.getLastname(), e.getGender(), strDate, e.getFathername(),
					e.getPassportname(), e.getPassportnumber(), strExpiry, e.getDoorNumber(), e.getStreet(),
					e.getArea(), e.getCountry(), e.getState(), e.getCity(), e.getPostalCode(), e.getLandMark(),
					e.getMobile(), e.getUsername());

			userSecurity = new UserSecurity(e.getUsername(), e.getSecurityQuestion(), e.getAnswer());

			userInfoServiceImplementation.save(userinfo);
			userServiceImplementation.save(user);
			userSecurityServiceImp.add(userSecurity);
		}

		return true;
	}

	@PutMapping("Registration")
	@ResponseBody
	public Boolean update(@RequestBody Registration e) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = dateFormat.format(e.getDob());
		String strExpiry = dateFormat.format(e.getExpiry());

		if (e.getUsername().endsWith("@dxc.com")) {
			admin = new Admin(e.getUsername(), e.getPassword());
		
			adminInfo = new AdminInfo(e.getName(), e.getLastname(), e.getGender(), strDate, e.getFathername(),
					e.getPassportname(), e.getPassportnumber(), strExpiry, e.getDoorNumber(), e.getStreet(),
					e.getArea(), e.getCountry(), e.getState(), e.getCity(), e.getPostalCode(), e.getLandMark(),
					e.getMobile(), e.getUsername());
		
			adminSecurity = new AdminSecurity(e.getUsername(), e.getSecurityQuestion(), e.getAnswer());
		
			adminInfoServiceImplementation.save(adminInfo);
			adminServiceImplementation.save(admin);
			adminSecurityServiceImplementation.save(adminSecurity);

		} else {
			user = new User(e.getUsername(), e.getPassword());

			userinfo = new UserInfo(e.getName(), e.getLastname(), e.getGender(), strDate, e.getFathername(),
					e.getPassportname(), e.getPassportnumber(), strExpiry, e.getDoorNumber(), e.getStreet(),
					e.getArea(), e.getCountry(), e.getState(), e.getCity(), e.getPostalCode(), e.getLandMark(),
					e.getMobile(), e.getUsername());

			userSecurity = new UserSecurity(e.getUsername(), e.getSecurityQuestion(), e.getAnswer());

			userInfoServiceImplementation.save(userinfo);
			userServiceImplementation.save(user);
			userSecurityServiceImp.add(userSecurity);
		}

		return true;
	}
}
