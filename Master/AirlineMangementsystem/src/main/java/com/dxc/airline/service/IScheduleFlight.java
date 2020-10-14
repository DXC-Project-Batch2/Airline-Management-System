package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.ScheduleFlight;

@Service
public interface IScheduleFlight {
	
	public ScheduleFlight addFlight(ScheduleFlight flight);
	
	public ScheduleFlight updateFlight(ScheduleFlight flight);
	
	public void delete(int id);
	
	public List<ScheduleFlight> findAll();
	
	public ScheduleFlight findById(int id);

}