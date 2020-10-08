package com.dxc.airline.service;

import java.util.List;

import com.dxc.airline.model.AirLine;

public interface AirlineService {

	public List<AirLine> findAll();

	public void save(AirLine theAirLine);

	public AirLine findById(long id);

	public void deleteById(long id);
	
}