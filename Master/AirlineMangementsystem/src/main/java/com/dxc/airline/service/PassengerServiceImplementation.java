package com.dxc.airline.service;
import java.util.List;
import java.util.Optional;

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
		List<Passenger> thePassenger = passengerRepository.findAll();
		if(thePassenger!=null)
		{
		return thePassenger;
		}
		return null;
	}

	@Override
	@Transactional
	public Passenger save(Passenger thePassenger)  {

			if(thePassenger!=null) {
			return passengerRepository.save(thePassenger);
			}
			return null;
	}
	
	@Override
	public List<Passenger> findByUserName(String username) {
		List<Passenger> thePassenger = passengerRepository.findByUserName(username);
		if(thePassenger!=null)
		{
		return thePassenger;
		}
		return null;
	}

	@Override
	public List<Passenger> findByUser(String username, int flightId) {
		List<Passenger> thePassenger = passengerRepository.findByUser(username, flightId);
		if(thePassenger!=null)
		{
		return thePassenger;
		}
		return null;
	}

	@Override
	public Passenger update(Passenger thePassenger) {
		// TODO Auto-generated method stub
		Optional<Passenger> present = passengerRepository.findById(thePassenger.getGovt_id());
		if(present.isPresent()) {
		return passengerRepository.save(thePassenger);
		}
		return null;
	}

	@Override
	public Passenger findById(long id) {
		// TODO Auto-generated method stub
		Optional<Passenger> present = passengerRepository.findById(id);
		if(present.isPresent()) {
		return present.get();
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		passengerRepository.deleteById(id);
	}

}

