package com.dxc.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.ScheduleFlight;
import com.dxc.airline.repository.ScheduleFlightRepository;
@Service
public class ScheduleFlightimp implements IScheduleFlight {
	
	@Autowired
	ScheduleFlightRepository repo;
	
	@Autowired
	ScheduleFlight emptyScheduleFlight;

	@Override
	public ScheduleFlight addFlight(ScheduleFlight flight) {
		
		return repo.save(flight);
	}

	@Override
	public ScheduleFlight updateFlight(ScheduleFlight flight) {
		
		return repo.save(flight);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);

	}

	@Override
	public List<ScheduleFlight> findAll() {
		
		return repo.findAll();
	}

	@Override
	public ScheduleFlight findById(int id) {
		
		return repo.findById(id).orElse(emptyScheduleFlight);
	}

}

