package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dxc.airline.model.City;
import com.dxc.airline.repository.CityRepository;

public class CityServiceImplementation implements CityService<City>{

	@Autowired
	CityRepository cityRepository;
	
	@Override
	public boolean save(City e) {
		boolean res=false;
		if(cityRepository.save(e) != null)
		{
			res=true;
		}
		return res;
	}

	@Override
	public City find(String city) {
		Optional<City> c = cityRepository.findById(city);
		return c.get();
	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public boolean update(City e) {
		boolean res=false;
		Optional<City> city = cityRepository.findById(e.getCity());
		if (city.isPresent()) {
			cityRepository.save(e);
			return true;
		}
		return res;
	}

	@Override
	public boolean delete(String city) {
		cityRepository.deleteById(city);
		return true;
	}

}
