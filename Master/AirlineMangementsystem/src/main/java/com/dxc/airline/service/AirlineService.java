package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.AirLine;
@Service
public interface AirlineService {

	public List<AirLine> findAll();

	public AirLine save(AirLine theAirLine);
	
	public AirLine update(AirLine theAirLine);
	
	public AirLine findById(int id);

	public void deleteById(int id);
	
	public List<AirLine> findByCities(String source, String destination);
	
	public List<AirLine> findByUser(String source, String destination,String date);
	
}