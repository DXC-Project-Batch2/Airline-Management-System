package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.City;
import com.dxc.airline.repository.CityRepository;
@Service
public class CityServiceImplementation implements CityService<City>{

	@Autowired
	CityRepository cityRepository;
	
	@Override
	public City save(City e) {
		return cityRepository.save(e);
		}

	@Override
	public List<City> findBycity(String city) {
		return cityRepository.findBycity(city);
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
