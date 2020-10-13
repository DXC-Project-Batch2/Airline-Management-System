package com.dxc.airline.service;

import java.util.List;

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
		return airlineRepository.findAll();
		}

	@Override
	@Transactional
	public AirLine save(AirLine theAirline) {
		
		return airlineRepository.save(theAirline);
	}

	@Override
	@Transactional
	public List<AirLine> findByAirlineid(long id) {
	
		return airlineRepository.findByAirlineid(id);
		
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		airlineRepository.deleteById(id);
	}

	
}