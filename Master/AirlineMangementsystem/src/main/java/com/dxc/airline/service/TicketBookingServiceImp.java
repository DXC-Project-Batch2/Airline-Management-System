package com.dxc.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.airline.exception.TicketBookingException;
import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.repository.TicketBookingRepository;

@Service
public class TicketBookingServiceImp implements ITicketBookingService {

	@Autowired
	TicketBookingRepository repo;

	@Override
	public TicketBooking add(TicketBooking booking) throws TicketBookingException {

		TicketBooking isValid = validateTicketBooking(booking);

		if (isValid != null) {

			return repo.save(booking);
		} else {

			throw new TicketBookingException("Ticket booking failed, try again...");
		}
	}

	public TicketBooking validateTicketBooking(TicketBooking booking) {

		if ((booking.getNoOfPassengers() >= 0) && (booking.getSource() != booking.getDestination())) {

			return booking;
		}

		return null;
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	@Override
	public List<TicketBooking> getAll() {

		return repo.findAll();
	}

	@Override
	public TicketBooking findById(long id) {
		TicketBooking theTicket = null;
		Optional<TicketBooking> result = repo.findById(id);
		if (result.isPresent()) {
			theTicket = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find ticket ");
		}

		return theTicket;
	}

	@Override
	public TicketBooking update(TicketBooking booking) {
		Optional<TicketBooking> updateBooking = repo.findById(booking.getTicketId());
		if(updateBooking.isPresent())
		{
			return repo.save(booking);
		}
		return null;
	}

}