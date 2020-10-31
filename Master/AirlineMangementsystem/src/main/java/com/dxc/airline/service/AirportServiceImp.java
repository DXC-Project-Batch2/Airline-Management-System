package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.Airport;
import com.dxc.airline.repository.AirportRepository;

@Service
public class AirportServiceImp implements IAirportService {
	@Autowired
	AirportRepository repo;

	@Override
	public Airport add(Airport airport) {
		
		if(airport!=null) {
		return repo.save(airport);
		}
		return null;
	}

	@Override
	public Airport update(Airport airport) {
		Optional<Airport> findbyId = repo.findById(airport.getAirportCode());
		if(findbyId.isPresent()) {
			return repo.save(airport);
		}
		return null;
	}

	@Override
	public List<Airport> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Airport findBycode(String airportcode) {
		
		Optional<Airport> res = repo.findById(airportcode);
		if (res.isPresent()) {
			return res.get();
		}
//		else {
//			throw new RuntimeException("Did not find airport ");
//		}
		
		return null;
	}
	
	public void delete(String airportcode) {
		repo.deleteById(airportcode);
	}

	
}
