package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.exception.ScheduleFlightException;
import com.dxc.airline.model.ScheduleFlight;
import com.dxc.airline.repository.ScheduleFlightRepository;

@Service
public class ScheduleFlightimp implements IScheduleFlight {
	
	@Autowired
	ScheduleFlightRepository repo;
	
	@Autowired
	ScheduleFlight emptyScheduleFlight;

	@Override
	public ScheduleFlight addFlight(ScheduleFlight flight) throws ScheduleFlightException{
		
		ScheduleFlight isValid=validateScheduleFlight(flight);
		
		if(isValid!=null) {
			
			return repo.save(flight);
		}else {
			
			throw new ScheduleFlightException("Scheduling flight is faild");
		}
		
		
	}
	
	public ScheduleFlight validateScheduleFlight(ScheduleFlight flight) {
		
		if((flight.getFlightId()>0) && (flight.getSeatingCapacity()>0) &&(flight.getAmount()>0)) {
			
			return flight;
		}
		
		return null;
	}

	@Override
	public ScheduleFlight updateFlight(ScheduleFlight flight) {
		
		Optional<ScheduleFlight> present = repo.findById(flight.getFlightId());
		if(present.isPresent())
		{
			return repo.save(flight);
		}
		return null;
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

