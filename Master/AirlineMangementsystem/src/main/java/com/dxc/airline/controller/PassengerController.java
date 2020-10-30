package com.dxc.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airline.model.Passenger;
import com.dxc.airline.service.PassengerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PassengerController {
	
	@Autowired
	PassengerService service;
	
	@CrossOrigin
	@GetMapping(path="/passenger")
	public List<Passenger> findAll(){
		
		return service.findAll();
	}
	
	
	@PostMapping(path="/passenger/add")
	public Passenger save(@RequestBody Passenger thePassenger ) {
		
		return service.save(thePassenger);
	}
	
	
	@CrossOrigin
	@GetMapping("/passenger/{username}")
	public List<Passenger> getPassenger(@PathVariable String username) {
		
		List<Passenger> thePassenger = service.findByUserName(username);
		
		if (thePassenger == null) {
			throw new RuntimeException("username  not found - ");
		}
		
		return thePassenger;
	}
	

	@GetMapping("/passenger/{username}/{flightId}")
	public List<Passenger> getPassengers(@PathVariable String username, @PathVariable int flightId) {
		
		
		
		List<Passenger> thePassenger = service.findByUser(username, flightId);
		
		if (thePassenger == null) {
			throw new RuntimeException("passenger  not found - ");
		}
		
		return thePassenger;
	}
	
	

}
