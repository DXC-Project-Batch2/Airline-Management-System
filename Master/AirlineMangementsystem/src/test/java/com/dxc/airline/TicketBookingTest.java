package com.dxc.airline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.repository.TicketBookingRepository;
import com.dxc.airline.service.TicketBookingServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketBookingTest {
	
	@Autowired
	TicketBookingServiceImp ticketBookingServiceImp;

	@MockBean
	TicketBookingRepository TicketBookingRepository;

	@Test
	public void TicketBookingfindAllTest() throws ParseException {
		when(TicketBookingRepository.findAll()).thenReturn(
				Stream.of(new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 10),new TicketBooking(102, "pasupathi@gmail.com", 102,"chennai", "hyderabad", "29-10-2020", 1))
						.collect(Collectors.toList()));
		assertEquals(2, ticketBookingServiceImp.getAll().size());
	}

	@Test
	public void TicketBookingfindByUsernameTest() throws ParseException {
		
		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 10);		
		when(TicketBookingRepository.findById((long) 0)).thenReturn(Optional.of(ticketBooking));
		assertEquals(ticketBooking, ticketBookingServiceImp.findById(ticketBooking.getTicketId()));
	}

	@Test
	public void saveTicketBookingTest() throws ParseException {
		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 10);		
		when(TicketBookingRepository.save(ticketBooking)).thenReturn(ticketBooking);
		assertEquals(ticketBooking, ticketBookingServiceImp.add(ticketBooking));
	}

	@Test
	public void deleteTicketBookingTest() {
		int ticketid =101;
		ticketBookingServiceImp.delete(ticketid);
		verify(TicketBookingRepository, times(1)).deleteById((long) ticketid);
	}

}
