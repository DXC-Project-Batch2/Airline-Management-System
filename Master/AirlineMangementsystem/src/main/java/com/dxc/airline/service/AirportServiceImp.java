package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.AirLine;
import com.dxc.airline.model.Airport;
import com.dxc.airline.repository.AirportRepository;

@Service
public class AirportServiceImp implements IAirportService {
	@Autowired
	AirportRepository repo;

	@Override
	public Airport add(Airport airport) {
		
		return repo.save(airport);
	}

	@Override
	public Airport update(Airport airport) {
		Optional<Airport> findbyId = repo.findById(airport.getAirportCode());
		if(findbyId.isPresent()) {
			repo.save(airport);
		}
		return airport;
	}

	@Override
	public List<Airport> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Airport findBycode(String airportcode) {
		
		Optional<Airport> res = repo.findById(airportcode);
		Airport airport = null;
		if (res.isPresent()) {
			airport = res.get();
		}
		else {
			throw new RuntimeException("Did not find airport ");
		}
		
		return airport;
	}
	
	public void delete(String airportcode) {
		repo.deleteById(airportcode);
	}

	
}
