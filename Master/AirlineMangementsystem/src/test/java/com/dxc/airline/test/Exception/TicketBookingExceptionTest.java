package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.dxc.airline.exception.TicketBookingException;
import com.dxc.airline.model.TicketBooking;

public class TicketBookingExceptionTest {


	// flightId
	@Test
	public void testFlightIdIsNull() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setFlightId(0);
		});
		assertEquals("flightId cannot be blank", exception.getMessage());
	}

	@Test
	public void testFlightIdChecking() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setFlightId(11111);
		});

		assertEquals("flightId not found", exception.getMessage());

	}

	// source
	@Test
	public void testSourceIsNull() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setSource(null);
		});
		assertEquals("source cannot be blank", exception.getMessage());
	}

	@Test
	public void testSourceCheckingLength() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setSource("ab");
		});

		assertEquals("Invalid city", exception.getMessage());

	}

	// destination
	@Test
	public void testDestinationIsNull() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setDestination(null);
		});
		assertEquals("destination cannot be blank", exception.getMessage());
	}

	@Test
	public void testDestinationCheckingLength() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setDestination("ab");
		});

		assertEquals("Invalid city", exception.getMessage());

	}

	// noOfPassengers
	@Test
	public void testNoOfPassengersIsNull() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setNoOfPassengers(0);
		});
		assertEquals("number Of Ticket a Passenger can book per flight 1-5", exception.getMessage());
	}

	@Test
	public void testNoOfPassengersCheckingLength() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setNoOfPassengers(6);
		});

		assertEquals("number Of Ticket a Passenger can book per flight 1-5", exception.getMessage());

	}
	
	//username
	@Test
	public void testUsernameIsNull() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setUsername(null);
		});
		assertEquals("Username cannot be blank", exception.getMessage());
	}

	@Test
	public void testUsernameCheckingLength() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setUsername("aa@gmail.com");
		});

		assertEquals("Username is too short", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingLength1() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setUsername("aaaaaaaaaaaaaaaaaa@yahoo.com");
		});

		assertEquals("Username is too long", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingEndSwitch() {

		Throwable exception = assertThrows(TicketBookingException.class, () -> {
			TicketBooking ticketBooking = new TicketBooking();
			ticketBooking.setUsername("pasupathi@dxc.com");
		});

		assertEquals("Username should ends with @gmail.com or @yahoo.com", exception.getMessage());

	}

}
