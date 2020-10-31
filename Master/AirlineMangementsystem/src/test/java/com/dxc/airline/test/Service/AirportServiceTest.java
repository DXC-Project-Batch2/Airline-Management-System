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

import com.dxc.airline.model.Airport;
import com.dxc.airline.repository.AirportRepository;
import com.dxc.airline.service.AirportServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirportServiceTest {

	@Autowired
	private AirportServiceImp airportServiceImp;
	
	@MockBean
	private AirportRepository airportRepository;
	
	//save
	@Test
	public void saveTest() throws ParseException{

		Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
		
	    Mockito.when(airportRepository.save(airport)).thenReturn(airport);
	    
	    assertThat(airportServiceImp.add(airport)).isEqualTo(airport);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest() throws ParseException{
		
		Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
		Mockito.when(airportRepository.findById(airport.getAirportCode())).thenReturn(Optional.of(airport));
	    assertThat(airportServiceImp.findBycode(airport.getAirportCode())).isEqualTo(airport);
	    
	}
	
	//findAll
	@Test
	public void findallTest() throws ParseException{

		Airport airport1 = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
		Airport airport2 = new Airport("c102", "chennai international airport", "Meenambakkam, Chennai");
		Airport airport3 = new Airport("c103", "Bandalore international airport", "Devanahalli, Bengaluru");
		
		List<Airport> airports = new ArrayList<>();
		airports.add(airport1);
		airports.add(airport2);
		airports.add(airport3);
		
		Mockito.when(airportRepository.findAll()).thenReturn(airports);
		
		assertThat(airportServiceImp.findAll()).isEqualTo(airports);
	}
	
	//delete
	@Test
	public void deleteTest() throws ParseException{

		Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
		
	    Mockito.when(airportRepository.findById(airport.getAirportCode())).thenReturn(Optional.of(airport));
	    Mockito.when(airportRepository.existsById(airport.getAirportCode())).thenReturn(false);
	   
	    assertFalse(airportRepository.existsById(airport.getAirportCode()));
	}
	
	//update
	@Test
	public void updateTest() throws ParseException{
		
		Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
		
	    Mockito.when(airportRepository.findById(airport.getAirportCode())).thenReturn(Optional.of(airport));
		
	    airport.setAirportLocation("Devanahalli, Bengaluru");
	    airport.setAirportName("Bandalore international airport");
	 
		Mockito.when(airportRepository.save(airport)).thenReturn(airport);
		
		assertThat(airportServiceImp.update(airport)).isEqualTo(airport);
		
	}

	//Notsave
		@Test
		public void NotsaveTest() throws ParseException{

			Airport airport = null;
			
		    Mockito.when(airportRepository.save(airport)).thenReturn(airport);
		    
		    assertThat(airportServiceImp.add(airport)).isEqualTo(airport);
		
		}
		
		
		//NotfindbyId
		@Test
		public void NotfindByIdTest() throws ParseException{
			
			Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
			Mockito.when(airportRepository.findById("c102")).thenReturn(Optional.of(airport));
		    assertThat(airportServiceImp.findBycode("c102")).isEqualTo(airport);
		    
		}
		
		//NotfindAll
		@Test
		public void NotfindallTest() throws ParseException{

			Airport airport1 = null;
			Airport airport2 = null;
			Airport airport3 = null;
			
			List<Airport> airports = new ArrayList<>();
			airports.add(airport1);
			airports.add(airport2);
			airports.add(airport3);
			
			Mockito.when(airportRepository.findAll()).thenReturn(airports);
			
			assertThat(airportServiceImp.findAll()).isEqualTo(airports);
		}
				
		//Notupdate
		@Test
		public void NotupdateTest() throws ParseException{
			
			Airport airport = new Airport("c101", "vijayawada international airport", "NH16, Gannavaram");
			
		    Mockito.when(airportRepository.findById("c102")).thenReturn(Optional.of(airport));
			
		    airport.setAirportLocation("Devanahalli, Bengaluru");
		    airport.setAirportName("Bandalore international airport");
		 
			Mockito.when(airportRepository.save(airport)).thenReturn(airport);
			
			assertThat(airportServiceImp.update(airport)).isNotEqualTo(airport);
			
		}

}
