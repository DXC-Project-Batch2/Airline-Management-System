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

import com.dxc.airline.model.Airport;
import com.dxc.airline.repository.AirportRepository;
import com.dxc.airline.service.AirportServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirPortTest {
	
	@Autowired
	AirportServiceImp airportServiceImp;

	@MockBean
	AirportRepository airportRepository;

	@Test
	public void AirportfindAllTest() throws ParseException {
		when(airportRepository.findAll()).thenReturn(
				Stream.of(new Airport("c101", "chennai", "chennai"),new Airport("g101", "goa", "goa"))
						.collect(Collectors.toList()));
		assertEquals(2, airportServiceImp.findAll().size());
	}

	@Test
	public void AirportfindByUsernameTest() throws ParseException {
		
		Airport airport =new Airport("c101", "chennai", "chennai");
		when(airportRepository.findById("c101")).thenReturn(Optional.of(airport));
		assertEquals(airport, airportServiceImp.findBycode(airport.getAirportCode()));
	}

	@Test
	public void saveAirportTest() throws ParseException {
		Airport airport =new Airport("c101", "chennai", "chennai");
		when(airportRepository.save(airport)).thenReturn(airport);
		assertEquals(airport, airportServiceImp.add(airport));
	}

	@Test
	public void deleteAirportTest() {
		String airportcode ="c101";
		airportServiceImp.delete(airportcode);
		verify(airportRepository, times(1)).deleteById(airportcode);
	}


}
