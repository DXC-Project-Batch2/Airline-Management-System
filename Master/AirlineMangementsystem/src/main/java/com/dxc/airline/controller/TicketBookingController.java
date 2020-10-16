package com.dxc.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airline.model.AirLine;
import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.service.TicketBookingServiceImp;

@RestController
public class TicketBookingController {
	
	@Autowired
	TicketBookingServiceImp ticketBookingServiceImp;
	
	@GetMapping("TicketBookings")
	@ResponseBody
	public List<TicketBooking> getBookings()
	{
		List<TicketBooking> bookings = (List<TicketBooking>) ticketBookingServiceImp.getAll();
		return bookings;
	}
	
	@CrossOrigin
	@GetMapping(path="TicketBooking/{id}")
	public TicketBooking getBooking(@PathVariable("id") Long id) 
	{
		TicketBooking theTicket = ticketBookingServiceImp.findById(id);
		
		if (theTicket == null) {
			throw new RuntimeException("Ticket not found - ");
		}
		
		return theTicket;
	}
	
	@CrossOrigin
	@PostMapping(path ="TicketBooking")
	@ResponseBody
	public TicketBooking save(@RequestBody TicketBooking ticketBooking)
	{
		return ticketBookingServiceImp.add(ticketBooking);
	}
	
	@CrossOrigin
	@PutMapping(path = "TicketBooking")
	@ResponseBody
	public boolean update(@RequestBody TicketBooking ticketBooking) {
		
		return ticketBookingServiceImp.update(ticketBooking);
	}
	
	@CrossOrigin
	@DeleteMapping(path = "TicketBooking/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") Long id) {
		
		ticketBookingServiceImp.delete(id);
	}
	


}