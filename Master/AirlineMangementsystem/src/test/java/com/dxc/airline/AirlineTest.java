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

import com.dxc.airline.model.AirLine;
import com.dxc.airline.repository.AirLineRepository;
import com.dxc.airline.service.AirlineServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirlineTest {

	
	@Autowired
	AirlineServiceImplementation airlineServiceImplementation;

	@MockBean
	AirLineRepository airLineRepository;

	@Test
	public void AirlinefindAllTest() throws ParseException {
		when(airLineRepository.findAll()).thenReturn(Stream.of(
				new AirLine(110, "airindia","chennai", "destination", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0),
				new AirLine(110, "airindia","chennai", "destination", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0)
				)
				.collect(Collectors.toList()));
		assertEquals(2, airlineServiceImplementation.findAll().size());
	}

	@Test
	public void AirlinefindByUsernameTest() throws ParseException {

		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
		when(airLineRepository.findById(110)).thenReturn(Optional.of(airLine));
		assertEquals(airLine, airlineServiceImplementation.findById(airLine.getPlaneId()));
	}

	@Test
	public void saveAirlineTest() throws ParseException {
		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
		when(airLineRepository.save(airLine)).thenReturn(airLine);
		assertEquals(airLine, airlineServiceImplementation.save(airLine));
	}

	@Test
	public void deleteAirlineTest() throws ParseException {
		int id = 111;
		airlineServiceImplementation.deleteById(id);
		verify(airLineRepository, times(1)).deleteById(id);
	}

}
