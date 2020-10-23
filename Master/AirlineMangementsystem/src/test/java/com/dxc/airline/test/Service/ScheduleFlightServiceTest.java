package com.dxc.airline.test.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

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

import com.dxc.airline.model.ScheduleFlight;
import com.dxc.airline.repository.ScheduleFlightRepository;
import com.dxc.airline.service.ScheduleFlightimp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleFlightServiceTest {

	@Autowired
	private ScheduleFlightimp scheduleFlightimp;
	
	@MockBean
	private ScheduleFlightRepository scheduleFlightRepository;
	
	//save
	@Test
	public void saveTest(){

		ScheduleFlight scheduleFlight = new ScheduleFlight(101, "chennai`", "goa", 44, 1000);
		
	    Mockito.when(scheduleFlightRepository.save(scheduleFlight)).thenReturn(scheduleFlight);
	    
	    assertThat(scheduleFlightimp.addFlight(scheduleFlight)).isEqualTo(scheduleFlight);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		ScheduleFlight scheduleFlight = new ScheduleFlight(101, "chennai`", "goa", 44, 1000);
		Mockito.when(scheduleFlightRepository.findById(scheduleFlight.getFlightId())).thenReturn(Optional.of(scheduleFlight));
	    assertThat(scheduleFlightimp.findById(scheduleFlight.getFlightId())).isEqualTo(scheduleFlight);
	}
	
	//findAll
	@Test
	public void findallTest(){

		ScheduleFlight scheduleFlight1 = new ScheduleFlight(101, "chennai`", "bangalore", 44, 1000);
		ScheduleFlight scheduleFlight2 = new ScheduleFlight(102, "bangalore`", "mumbai", 44, 1000);
		ScheduleFlight scheduleFlight3 = new ScheduleFlight(103, "chennai`", "hyderabad", 44, 1000);
		
		List<ScheduleFlight> scheduleFlights = new ArrayList<>();
		scheduleFlights.add(scheduleFlight1);
		scheduleFlights.add(scheduleFlight2);
		scheduleFlights.add(scheduleFlight3);
		
		Mockito.when(scheduleFlightRepository.findAll()).thenReturn(scheduleFlights);
		
		assertThat(scheduleFlightimp.findAll()).isEqualTo(scheduleFlights);
	}
	
	//delete
	@Test
	public void deleteTest(){

		ScheduleFlight scheduleFlight = new ScheduleFlight(101, "chennai`", "goa", 44, 1000);
		
	    Mockito.when(scheduleFlightRepository.findById(scheduleFlight.getFlightId())).thenReturn(Optional.of(scheduleFlight));
	    Mockito.when(scheduleFlightRepository.existsById(scheduleFlight.getFlightId())).thenReturn(false);
	   
	    assertFalse(scheduleFlightRepository.existsById(scheduleFlight.getFlightId()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		ScheduleFlight scheduleFlight = new ScheduleFlight(101, "chennai`", "goa", 44, 1000);
		
	    Mockito.when(scheduleFlightRepository.findById(scheduleFlight.getFlightId())).thenReturn(Optional.of(scheduleFlight));
		
	    scheduleFlight.setSource("mumbai");
	    scheduleFlight.setDestination("hyderabad");
	    scheduleFlight.setAmount(2000);
	
		Mockito.when(scheduleFlightRepository.save(scheduleFlight)).thenReturn(scheduleFlight);
		
		assertThat(scheduleFlightimp.updateFlight(scheduleFlight)).isEqualTo(scheduleFlight);
		
	}
	
}
