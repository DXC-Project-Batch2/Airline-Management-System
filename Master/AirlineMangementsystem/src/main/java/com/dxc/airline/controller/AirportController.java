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
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airline.model.Airport;
import com.dxc.airline.service.IAirportService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AirportController {
	
	@Autowired
	IAirportService service;
	
	@Autowired
	Airport airport;
	
	@PostMapping(path="/airport/add")
	public Airport add(@RequestBody Airport airport) {
		
		return service.add(airport);
	}
	
	@PutMapping(path="/airport/update")
	public Airport update(@RequestBody Airport airport) {
		
		return service.update(airport);
	}
	
	@GetMapping(path="/airport")
	public List<Airport> findAll(){
		
		return service.findAll();
	}
	
	/*@GetMapping(path="/airport/{airportcode}")
	public Airport findByAirportCode(@PathVariable String airportcode) {
		
		return service.findByAirportCode(airportcode);
	}*/
	
	@GetMapping(path="/airport/{airportcode}")
	public Airport findBycode(@PathVariable String airportcode) {
		
		return service.findBycode(airportcode);
	}
	
	@DeleteMapping(path="/airportDelete/{airportcode}")
	public void deleteById(@PathVariable("airportcode")String airportcode) {
		
		service.delete(airportcode);
	}
	
	

}
