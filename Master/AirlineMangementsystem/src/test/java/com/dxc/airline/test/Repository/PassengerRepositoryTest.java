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

import com.dxc.airline.model.Passenger;
import com.dxc.airline.repository.PassengerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PassengerRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	//save
	@Test
	public void testSavePassenger(){
		
		Passenger passenger = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		Passenger savedInDb = entityManager.persist(passenger);
		Passenger getFromDatabase = passengerRepository.getOne(savedInDb.getGovt_id());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetPassengerById(){
		
		Passenger passenger = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		//Save passenger in DB
		Passenger SavedInDb = entityManager.persist(passenger);
		
		//Get passenger from DB
		Optional<Passenger> FromInDb = passengerRepository.findById(passenger.getGovt_id());
		assertThat(SavedInDb).isEqualTo(FromInDb.get());
	}
	
	//findByUserName
	@Test
	public void testGetPassengerByUserName(){
		
		Passenger passenger = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		//Save passenger in DB
		entityManager.persist(passenger);
		
		//Get passenger from DB
		List<Passenger> passengers = passengerRepository.findByUserName(passenger.getUsername());
		assertThat(passengers.size()).isEqualTo(1);
}

	
	//findByUser
	@Test
	public void testGetPassengerByUser(){
		
		Passenger passenger = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		//Save passenger in DB
		entityManager.persist(passenger);
		
		//Get passenger from DB
		List<Passenger> passengers = passengerRepository.findByUser(passenger.getUsername(),passenger.getFlight_id());
		assertThat(passengers.size()).isEqualTo(1);
}

	
	//findAll
	@Test
	public void testGetAllPassengers(){
		
		Passenger passenger1 = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		Passenger passenger2 = new Passenger(1110,"anil@gmail.com", "anil kumar", "male", 22,11111, 101);
		
		//Save both passenger in DB
		entityManager.persist(passenger1);
		entityManager.persist(passenger2);
		
		List<Passenger> passengers = passengerRepository.findAll();
		assertThat(passengers.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeletePassengerById(){
	
		Passenger passenger = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		
		//Save passenger in DB
		entityManager.persist(passenger);
		
		//delete one passenger DB
		entityManager.remove(passenger);
		
		List<Passenger> passengers = passengerRepository.findAll();
		assertThat(passengers.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdatePassenger(){
		
		Passenger passenger = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
			
		//save passenger info in DB
		entityManager.persist(passenger);
		
		Passenger getFromDb = passengerRepository.findById(passenger.getGovt_id()).get();

		getFromDb.setAge(25);
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getAge()).isEqualTo(25);
	}
	
}
