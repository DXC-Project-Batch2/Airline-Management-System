package com.dxc.airline.test.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.ScheduleFlight;
import com.dxc.airline.repository.ScheduleFlightRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ScheduleFlightRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	ScheduleFlightRepository scheduleFlightRepository;
	
	//save
	@Test
	public void testSaveScheduleFlight(){

		ScheduleFlight scheduleFlight = new ScheduleFlight(101, "chennai`", "goa", 44, 1000);
		ScheduleFlight savedInDb = entityManager.persist(scheduleFlight);
		ScheduleFlight getFromDatabase = scheduleFlightRepository.getOne(savedInDb.getFlightId());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetScheduleFlightById(){
	
		ScheduleFlight scheduleFlight = new ScheduleFlight(101, "chennai`", "goa", 44, 1000);
		//Save scheduleFlight in DB
		ScheduleFlight scheduleFlightSavedInDb = entityManager.persist(scheduleFlight);
		
		//Get scheduleFlight from DB
		Optional<ScheduleFlight> scheduleFlightFromInDb = scheduleFlightRepository.findById(scheduleFlight.getFlightId());
		assertThat(scheduleFlightSavedInDb).isEqualTo(scheduleFlightFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllScheduleFlight(){
		
		ScheduleFlight scheduleFlight1 = new ScheduleFlight(101, "chennai`", "bangalore", 44, 1000);
		ScheduleFlight scheduleFlight2 = new ScheduleFlight(102, "bangalore`", "mumbai", 44, 1000);
		ScheduleFlight scheduleFlight3 = new ScheduleFlight(103, "chennai`", "hyderabad", 44, 1000);
		//Save both scheduleFlight in DB
		entityManager.persist(scheduleFlight1);
		entityManager.persist(scheduleFlight2);
		entityManager.persist(scheduleFlight3);
		
		
		List<ScheduleFlight> scheduleFlights = scheduleFlightRepository.findAll();
		assertThat(scheduleFlights.size()).isEqualTo(3);
	}
	
	//delete
	@Test
	public void testDeleteByScheduleFlight() {
	
		ScheduleFlight scheduleFlight = new ScheduleFlight(101, "chennai`", "bangalore", 44, 1000);
		//Save scheduleFlight in DB
		entityManager.persist(scheduleFlight);
		
		//delete one scheduleFlight DB
		entityManager.remove(scheduleFlight);
		
		List<ScheduleFlight> scheduleFlights = scheduleFlightRepository.findAll();
		assertThat(scheduleFlights.size()).isEqualTo(0);
		}
	
	//update
	@Test
	public void testUpdateScheduleFlight(){
		
		ScheduleFlight scheduleFlight = new ScheduleFlight(101, "chennai`", "bangalore", 44, 1000);
		//save scheduleFlight info in DB
		entityManager.persist(scheduleFlight);
		
		ScheduleFlight getFromDb = scheduleFlightRepository.findById(scheduleFlight.getFlightId()).get();

		getFromDb.setSource("mumbai");
		getFromDb.setDestination("hyderabad");
		getFromDb.setAmount(2000);
		
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getSource()).isEqualTo("mumbai");
		assertThat(getFromDb.getDestination()).isEqualTo("hyderabad");
		assertThat(getFromDb.getAmount()).isEqualTo(2000);
	}
	
}
