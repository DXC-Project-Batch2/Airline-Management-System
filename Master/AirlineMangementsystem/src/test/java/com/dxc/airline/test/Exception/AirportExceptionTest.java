package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.dxc.airline.exception.AirportException;
import com.dxc.airline.model.Airport;

public class AirportExceptionTest {
	
	@Test
	public void testAirportNameIsNull() {

		Throwable exception = assertThrows(AirportException.class, () -> {
			Airport airport =new Airport();
			airport.setAirportName(null);
		});
		assertEquals("AirportName cannot be blank", exception.getMessage());
	}

	@Test
	public void testAirportCodeIsNull() {

		Throwable exception = assertThrows(AirportException.class, () -> {
			Airport airport =new Airport();
			airport.setAirportCode(null);
		});
		
		assertEquals("AirportCode cannot be blank", exception.getMessage());

	}

	@Test
	public void testAirportLocationIsNull() {

		Throwable exception = assertThrows(AirportException.class, () -> {
			Airport airport =new Airport();
			airport.setAirportLocation(null);
		});
		
		assertEquals("AirportLocation cannot be blank", exception.getMessage());

	}

}
