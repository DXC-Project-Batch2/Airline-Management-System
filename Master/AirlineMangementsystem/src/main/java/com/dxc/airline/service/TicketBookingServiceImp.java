package com.dxc.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.repository.TicketBookingRepository;

@Service
public class TicketBookingServiceImp implements ITicketBookingService {
	
	@Autowired
	TicketBookingRepository repo;

	@Override
	public TicketBooking add(TicketBooking booking) {
		return repo.save(booking);
	}

	@Override
	public boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<TicketBooking> getAll() {
		
		return repo.findAll();
	}

	@Override
	public List<TicketBooking> findByTicketId(long id) {
		return repo.findByTicketId(id);
	}

	@Override
	public boolean update(TicketBooking booking) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
