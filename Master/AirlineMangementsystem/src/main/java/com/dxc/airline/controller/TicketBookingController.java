package com.dxc.airline.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
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

import com.dxc.airline.model.Sample_model;
import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.service.TicketBookingServiceImp;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping("sampleJasper")
	@ResponseBody
	public List<Sample_model> getSampleJasper()
	{
		List<Sample_model> bookings = (List<Sample_model>) ticketBookingServiceImp.sampleModel();
		
		 
	       
	       
	        System.out.println("----->>>>>>"+bookings);
		
		return bookings;
	}
	
	@GetMapping("ticketId")
	@ResponseBody
	@CrossOrigin
	public long getLastTicketId()
	{
		return ticketBookingServiceImp.LastEnteredTicket();
		
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
		
		return ticketBookingServiceImp.update(ticketBooking) != null;
	}
	
	@CrossOrigin
	@DeleteMapping(path = "TicketBooking/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") Long id) {
		
		ticketBookingServiceImp.delete(id);
	}
	
	@GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, IOException {
        return ticketBookingServiceImp.exportReport(format);
    }



}