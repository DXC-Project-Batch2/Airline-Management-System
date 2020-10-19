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

import com.dxc.airline.model.ScheduleFlight;
import com.dxc.airline.repository.ScheduleFlightRepository;
import com.dxc.airline.service.ScheduleFlightimp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleFlightTest {
	
	@Autowired
	ScheduleFlightimp scheduleFlightimp;

	@MockBean
	ScheduleFlightRepository schFlightRepository;

	@Test
	public void ScheduleFlightfindAllTest() throws ParseException {
		when(schFlightRepository.findAll()).thenReturn(
				Stream.of(new ScheduleFlight(101, "chennai`", "goa", 44, 1000),new ScheduleFlight(102, "chennai`", "goa", 44, 1000))
						.collect(Collectors.toList()));
		assertEquals(2, scheduleFlightimp.findAll().size());
	}

	@Test
	public void ScheduleFlightfindByUsernameTest() throws ParseException {
		
		ScheduleFlight ScheduleFlight =new ScheduleFlight(101, "chennai`", "goa", 44, 1000);
		when(schFlightRepository.findById(101)).thenReturn(Optional.of(ScheduleFlight));
		assertEquals(ScheduleFlight, scheduleFlightimp.findById(ScheduleFlight.getFlightId()));
	}

	@Test
	public void saveScheduleFlightTest() throws ParseException {
		ScheduleFlight ScheduleFlight =new ScheduleFlight(101, "chennai`", "goa", 44, 1000);
		when(schFlightRepository.save(ScheduleFlight)).thenReturn(ScheduleFlight);
		assertEquals(ScheduleFlight, scheduleFlightimp.addFlight(ScheduleFlight));
	}

	@Test
	public void deleteScheduleFlightTest() {
		int flightid =101;
		scheduleFlightimp.delete(flightid);
		verify(schFlightRepository, times(1)).deleteById(flightid);
	}

}
