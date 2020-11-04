package com.dxc.airline.test.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.repository.TicketBookingRepository;
import com.dxc.airline.service.TicketBookingServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketBookingServiceTest {

	@Autowired
	private TicketBookingServiceImp ticketBookingServiceImp;
	
	@MockBean
	private TicketBookingRepository ticketBookingRepository;
	
	//save
	@Test
	public void saveTest() throws ParseException{

		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 1);		
		
	    Mockito.when(ticketBookingRepository.save(ticketBooking)).thenReturn(ticketBooking);
	    
	    assertThat(ticketBookingServiceImp.add(ticketBooking)).isEqualTo(ticketBooking);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest() throws ParseException{
		
		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 2);		
		Mockito.when(ticketBookingRepository.findById(ticketBooking.getTicketId())).thenReturn(Optional.of(ticketBooking));
	    assertThat(ticketBookingServiceImp.findById(ticketBooking.getTicketId())).isEqualTo(ticketBooking);
	}
	
	//findAll
	@Test
	public void findallTest() throws ParseException{

		TicketBooking ticketBooking1 = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 2);		
		TicketBooking ticketBooking2 = new TicketBooking(102, "ram@gmail.com", 102,"chennai", "hyderabad", "29-10-2020", 2);		
		
		
		List<TicketBooking> ticketBookings = new ArrayList<>();
		ticketBookings.add(ticketBooking1);
		ticketBookings.add(ticketBooking2);
		
		Mockito.when(ticketBookingRepository.findAll()).thenReturn(ticketBookings);
		
		assertThat(ticketBookingServiceImp.getAll()).isEqualTo(ticketBookings);
	}
	
	//delete
	@Test
	public void deleteTest() throws ParseException{

		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 4);		
		
	    Mockito.when(ticketBookingRepository.findById(ticketBooking.getTicketId())).thenReturn(Optional.of(ticketBooking));
	    Mockito.when(ticketBookingRepository.existsById(ticketBooking.getTicketId())).thenReturn(false);
	   
	    assertFalse(ticketBookingRepository.existsById(ticketBooking.getTicketId()));
	}
	
	//update
	@Test
	public void updateTest() throws ParseException{
		
		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 4);		
		
	    Mockito.when(ticketBookingRepository.findById(ticketBooking.getTicketId())).thenReturn(Optional.of(ticketBooking));
		
	    ticketBooking.setSource("mumbai");
	    ticketBooking.setDestination("hyderabad");
	
		Mockito.when(ticketBookingRepository.save(ticketBooking)).thenReturn(ticketBooking);
		
		assertThat(ticketBookingServiceImp.update(ticketBooking)).isEqualTo(ticketBooking);
		
	}
	
}
