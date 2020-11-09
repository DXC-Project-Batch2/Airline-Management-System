package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.TicketBooking;

@Service
public interface ITicketBookingService {
	
public TicketBooking add(TicketBooking booking);
	
	public void delete(long id);
	
	public List<TicketBooking> getAll();

	public TicketBooking findById(long id);

	public TicketBooking update(TicketBooking booking);
	public long LastEnteredTicket();
}