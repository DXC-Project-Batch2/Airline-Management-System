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
	public City findBycity(String city) {
		return cityRepository.findById(city).orElse(new City());
 	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public City update(City e) {
	
		Optional<City> city = cityRepository.findById(e.getCity());
		if (city.isPresent()) {
			return cityRepository.save(e);
		}
		return null;
	}

	@Override
	public boolean delete(String city) {
		cityRepository.deleteById(city);
		return true;
	}

}
