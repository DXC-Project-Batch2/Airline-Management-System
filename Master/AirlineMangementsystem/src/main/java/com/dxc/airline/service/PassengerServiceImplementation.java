package com.dxc.airline.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dxc.airline.model.Passenger;

import com.dxc.airline.repository.PassengerRepository;

@Service
public class PassengerServiceImplementation implements PassengerService{

	public PassengerServiceImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	@Transactional
	public List<Passenger> findAll() {
		return passengerRepository.findAll();
	}

	@Override
	@Transactional
	public Passenger save(Passenger thePassenger)  {

		
			return passengerRepository.save(thePassenger);
		
	}
	
	@Override
	public List<Passenger> findByUserName(String username) {
		List<Passenger> thePassenger = passengerRepository.findByUserName(username);
		return thePassenger;
	}

	@Override
	public List<Passenger> findByUser(String username, int flightId) {
		List<Passenger> thePassenger = passengerRepository.findByUser(username, flightId);
		return thePassenger;
	}

	@Override
	public Passenger update(Passenger thePassenger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}

