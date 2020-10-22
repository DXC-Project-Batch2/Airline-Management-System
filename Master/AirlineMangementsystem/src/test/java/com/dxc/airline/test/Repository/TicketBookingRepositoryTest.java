package com.dxc.airline.test.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.repository.TicketBookingRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketBookingRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	TicketBookingRepository ticketBookingRepository;
	
	//save
	@Test
	public void testSaveTicketBooking() throws ParseException{

		TicketBooking ticketBooking = new TicketBooking(101,"chennai", "hyderabad", "18-10-2020", 44);
		TicketBooking savedInDb = entityManager.persist(ticketBooking);
		TicketBooking getFromDatabase = ticketBookingRepository.getOne(savedInDb.getTicketId());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetTicketBookingById() throws ParseException{
	
		TicketBooking ticketBooking = new TicketBooking(101,"chennai", "hyderabad", "18-10-2020", 44);
		TicketBooking savedInDb = entityManager.persist(ticketBooking);
		
		Optional<TicketBooking> FromInDb = ticketBookingRepository.findById(ticketBooking.getTicketId());
		assertThat(savedInDb).isEqualTo(FromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllTicketBooking() throws ParseException{
		
		TicketBooking ticketBooking1 = new TicketBooking(101,"chennai", "hyderabad", "18-10-2020", 44);
		TicketBooking ticketBooking2 = new TicketBooking(102,"chennai", "hyderabad", "18-10-2020", 44);
		//Save both ticketBooking in DB
		entityManager.persist(ticketBooking1);
		entityManager.persist(ticketBooking2);
		
		
		List<TicketBooking> ticketBookings = ticketBookingRepository.findAll();
		assertThat(ticketBookings.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeleteByTicketBooking() throws ParseException {
	
		TicketBooking ticketBooking = new TicketBooking(101,"chennai", "hyderabad", "18-10-2020", 44);
		//Save ticketBooking in DB
		entityManager.persist(ticketBooking);
		
		//delete one ticketBooking DB
		entityManager.remove(ticketBooking);
		
		List<TicketBooking> ticketBookings = ticketBookingRepository.findAll();
		assertThat(ticketBookings.size()).isEqualTo(0);
		}
	
	//update
	@Test
	public void testUpdateTicketBooking() throws ParseException{
		
		TicketBooking ticketBooking = new TicketBooking(101,"chennai", "hyderabad", "18-10-2020", 44);
		//save ticketBooking info in DB
		entityManager.persist(ticketBooking);
		
		TicketBooking getFromDb = ticketBookingRepository.findById(ticketBooking.getTicketId()).get();

		getFromDb.setSource("mumbai");
		getFromDb.setDestination("hyderabad");
		
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getSource()).isEqualTo("mumbai");
		assertThat(getFromDb.getDestination()).isEqualTo("hyderabad");
		
	}
	
}
