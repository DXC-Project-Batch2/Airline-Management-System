package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.AirLine;
@Service
public interface AirlineService {

	public List<AirLine> findAll();

	public AirLine save(AirLine theAirLine);

	public List<AirLine> findByAirlineid(long id);

	public void deleteById(long id);
	
}