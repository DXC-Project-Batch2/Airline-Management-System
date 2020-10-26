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

import com.dxc.airline.model.User;
import com.dxc.airline.service.UserServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@GetMapping(path = "user/{username}")
	@ResponseBody
	public User getUserInfo(@PathVariable("username") String username) {
		
		return userServiceImplementation.findById(username);
	}
	
	@GetMapping(path = "user")
	@ResponseBody
	public List<User> getUsers(){
		
		return userServiceImplementation.findAll();
	}
	
	@PostMapping("user")
	public User addUser(@RequestBody User theUser) {
		
		userServiceImplementation.save(theUser);
		
		return theUser;
	}

	
	@PutMapping("user")
	@ResponseBody
	public User update(@RequestBody User theUser) {
		
		 userServiceImplementation.save(theUser);
		 return theUser;
	}
	
	@DeleteMapping(path = "user/{username}")
	@ResponseBody
	public void delete(@PathVariable("username") String username) {
		
		userServiceImplementation.deleteById(username);
	}
	
	@PostMapping("/login")
	public User LOgin(@RequestBody User user) throws Exception {

		String tempEmail=user.getUsername();

		 String tempPassword=user.getPassword();


		 User userObj=null;


		 if(tempEmail!=null && tempPassword!=null)
		 {
			 userObj=userServiceImplementation.findByUsernameAndPassword(tempEmail, tempPassword); 
		 }

		 if(userObj == null)
		 {
			 throw new Exception("Bad Credentials");
		 }
		 return userObj;
	}
}
