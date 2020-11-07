package com.dxc.airline.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.exception.AirlineException;
import com.dxc.airline.model.AirLine;
import com.dxc.airline.model.AirLineDetalis;
@Service
public interface AirlineService {

	public List<AirLine> findAll();

	public AirLine save(AirLineDetalis theAirLine) throws AirlineException, ParseException;
	
	public AirLine update(AirLine theAirLine) throws ParseException;
	
	public List<AirLine> findById(int id);

	public AirLine findBySno(int id);
	
	public void deleteById(int id);
	
	public void deleteByPlane_Id(int plane_id);
	
	public void deleteByDate(String date);

	public List<AirLine> findByCities(String source, String destination);
	
	public List<AirLine> findByUser(String source, String destination,String date);
	
}