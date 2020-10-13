package com.dxc.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airline.model.AirLine;
import com.dxc.airline.service.AirlineService;

@RestController
public class AirlineController {
	
	@Autowired
	AirLine airline;
	
	@Autowired
	AirlineService service;
	
	@GetMapping(path="/airline")
	public List<AirLine> findAll(){
		
		return service.findAll();
	}
	
	@PostMapping(path="/airline/add")
	public AirLine save(@RequestBody AirLine theairline ) {
		
		return service.save(theairline);
	}
	
	@GetMapping(path="/airlineId/{id}")
	public List<AirLine> findByAirlineid(@PathVariable("id")int id) {
		
		return service.findByAirlineid(id);
	}
	
	@DeleteMapping(path="/airlineDelete/{id}")
	public void deleteById(@PathVariable("id")int id) {
		
		service.deleteById(id);
	}
	
	

}
