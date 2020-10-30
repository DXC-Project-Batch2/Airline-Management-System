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

import com.dxc.airline.model.City;
import com.dxc.airline.service.CityServiceImplementation;

@RestController
public class CityController {

	@Autowired
	CityServiceImplementation cityServiceImplementation;
	
	@CrossOrigin
	@GetMapping("cities")
	@ResponseBody
	public List<City> getCities()
	{
		List<City> cities = (List<City>) cityServiceImplementation.findAll();
		return cities;
	}
	
	@GetMapping(path="city/{cityname}")
	public City getCity(@PathVariable("cityname") String cityname) 
	{
		return cityServiceImplementation.findBycity(cityname);
	}
	
	@PostMapping(path ="city")
	@ResponseBody
	public City save(@RequestBody City city)
	{
		return cityServiceImplementation.save(city);
	}
	
	@PutMapping(path = "city")
	@ResponseBody
	public City update(@RequestBody City city) {
		
		return cityServiceImplementation.update(city);
		
	}
	
	@DeleteMapping(path = "city/{username}")
	@ResponseBody
	public void delete(@PathVariable("city") String city) {
		//
		cityServiceImplementation.delete(city);
	}
	
	
	
}
