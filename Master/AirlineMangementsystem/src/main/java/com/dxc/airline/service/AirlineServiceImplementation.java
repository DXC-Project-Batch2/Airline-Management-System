package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.airline.model.AirLine;
import com.dxc.airline.repository.AirLineRepository;



@Service
public class AirlineServiceImplementation implements AirlineService{

	public AirlineServiceImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private AirLineRepository airlineRepository;
	
	@Override
	@Transactional
	public List<AirLine> findAll() {
		return airlineRepository.findAll()	}

	@Override
	@Transactional
	public void save(AirLine theAirline) {
		
		airlineRepository.save(theAirline);
	}

	@Override
	@Transactional
	public AirLine findById(long id) {
		Optional<AirLine> result = airLineRepository.findById(id);
		
		AirLine theAirLine = null;
		
		if (result.isPresent()) {
			theAirLine = result.get();
		}
		else {
			throw new RuntimeException("Did not find AirLine id - " + id);
		}
		
		return theAirLine;
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		airlineRepository.deleteById(id);
	}

	
}