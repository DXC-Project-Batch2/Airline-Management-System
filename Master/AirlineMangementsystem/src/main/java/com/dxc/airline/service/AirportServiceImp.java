package com.dxc.airline.service;

import java.util.List;

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
		
		return repo.save(airport);
	}

	@Override
	public Airport update(Airport airport) {
		
		return repo.save(airport);
	}

	@Override
	public List<Airport> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Airport findByAirportCode(String airportcode) {
		
		return repo.findByAirportCode(airportcode);
	}

	
}
