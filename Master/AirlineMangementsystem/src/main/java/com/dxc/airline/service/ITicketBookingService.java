package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.TicketBooking;

@Service
public interface ITicketBookingService {
	
	public TicketBooking add(TicketBooking booking);
	
	public boolean delete(long id);
	
	public List<TicketBooking> getAll();

	public TicketBooking find(long id);

	public boolean update(TicketBooking booking);
}
