package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.airline.exception.AirlineException;
import com.dxc.airline.exception.TicketBookingException;
import com.dxc.airline.model.AirLine;
import com.dxc.airline.model.TicketBooking;
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
	public AirLine save(AirLine theAirline) throws AirlineException {
		


		AirLine isValid= validateAirLine(theAirline);
		
		if(isValid!=null) {
			
			return airlineRepository.save(theAirline);
		}else {
			
			throw new AirlineException("Airline addition failed, try again...");
		}
	}
	public AirLine validateAirLine(AirLine theAirline) {
		
		if(((theAirline.getStarting_time()!= theAirline.getEnding_time())) && (theAirline.getAvaliable_seats()!=0) && (theAirline.getPrize()!=0)) 
		{
			
			return theAirline;
		}
		
		return null;
	}
		
	
	@Override
	@Transactional
	public AirLine update(AirLine theAirline) {
		Optional<AirLine> findbyId = airlineRepository.findById(theAirline.getPlaneId());
		if(findbyId.isPresent()) {
			airlineRepository.save(theAirline);
		}
		return theAirline;
	}
	
	@Override
	@Transactional
	public List<AirLine> findByAirlineid(int id) {
	
		return airlineRepository.findByplaneId(id);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		airlineRepository.deleteById(id);
	}
	

	@Override
	public List<AirLine> findByCities(String source, String destination) {
		List<AirLine> theAirline = airlineRepository.findByCities(source, destination);
		return theAirline;
	}

	
}