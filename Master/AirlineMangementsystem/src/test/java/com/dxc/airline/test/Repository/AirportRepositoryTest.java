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

import com.dxc.airline.model.Airport;
import com.dxc.airline.repository.AirportRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AirportRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	AirportRepository airportRepository;
	
	//save
	@Test
	public void testSaveAirport(){

		Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
		Airport savedInDb = entityManager.persist(airport);
		Airport getFromDatabase = airportRepository.getOne(savedInDb.getAirportCode());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetAirportById(){
	
		Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
		//Save airport in DB
		Airport airportSavedInDb = entityManager.persist(airport);
		
		//Get airport from DB
		Optional<Airport> airportFromInDb = airportRepository.findById(airport.getAirportCode());
		assertThat(airportSavedInDb).isEqualTo(airportFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllAirport(){
		
		Airport airport1 = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
		Airport airport2 = new Airport("c102", "chennai international airport", "Meenambakkam, Chennai");
		Airport airport3 = new Airport("c103", "Bandalore international airport", "Devanahalli, Bengaluru");
		//Save both airport in DB
		entityManager.persist(airport1);
		entityManager.persist(airport2);
		entityManager.persist(airport3);
		
		
		List<Airport> airports = airportRepository.findAll();
		assertThat(airports.size()).isEqualTo(3);
	}
	
	//delete
	@Test
	public void testDeleteAirportById() {
	
		Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");	
		//Save airport in DB
		entityManager.persist(airport);
		
		//delete one airport DB
		entityManager.remove(airport);
		
		List<Airport> airports = airportRepository.findAll();
		assertThat(airports.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateAirport() throws ParseException{
		
		Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");	
		//save airport info in DB
		entityManager.persist(airport);
		
		Airport getFromDb = airportRepository.findById(airport.getAirportCode()).get();

		getFromDb.setAirportLocation("Devanahalli, Bengaluru");
		getFromDb.setAirportName("Bandalore international airport");
		
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getAirportLocation()).isEqualTo("Devanahalli, Bengaluru");
		assertThat(getFromDb.getAirportName()).isEqualTo("Bandalore international airport");
	}
	
}
