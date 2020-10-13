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
	
	@GetMapping(path="TicketBooking/{id}")
	public List<TicketBooking> getBooking(@PathVariable("id") Long id) 
	{
		return ticketBookingServiceImp.findByTicketId(id);
	}
	
	@CrossOrigin
	@PostMapping(path ="TicketBooking")
	@ResponseBody
	public TicketBooking save(@RequestBody TicketBooking ticketBooking)
	{
		return ticketBookingServiceImp.add(ticketBooking);
	}
	
	@PutMapping(path = "TicketBooking")
	@ResponseBody
	public boolean update(@RequestBody TicketBooking ticketBooking) {
		
		return ticketBookingServiceImp.update(ticketBooking);
	}
	
	@DeleteMapping(path = "TicketBooking/{username}")
	@ResponseBody
	public void delete(@PathVariable("id") Long id) {
		
		ticketBookingServiceImp.delete(id);
	}
	


}
