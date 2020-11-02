package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import org.springframework.scheduling.SchedulingException;

import com.dxc.airline.model.ScheduleFlight;

public class ScheduleFlightExceptionTest {

	// flightId
	@Test
	public void testFlightIdIsNull() {

		Throwable exception = assertThrows(SchedulingException.class, () -> {
			ScheduleFlight scheduleFlight = new ScheduleFlight();
			scheduleFlight.setFlightId(0);
		});
		assertEquals("flightId cannot be blank", exception.getMessage());
	}

	// source
	@Test
	public void testSourceIsNull() {

		Throwable exception = assertThrows(SchedulingException.class, () -> {
			ScheduleFlight scheduleFlight = new ScheduleFlight();
			scheduleFlight.setSource(null);
		});
		assertEquals("source cannot be blank", exception.getMessage());
	}

	@Test
	public void testSourceCheckingLength() {

		Throwable exception = assertThrows(SchedulingException.class, () -> {
			ScheduleFlight scheduleFlight = new ScheduleFlight();
			scheduleFlight.setSource("ab");
		});

		assertEquals("Invalid city", exception.getMessage());

	}

	// destination
	@Test
	public void testDestinationIsNull() {

		Throwable exception = assertThrows(SchedulingException.class, () -> {
			ScheduleFlight scheduleFlight = new ScheduleFlight();
			scheduleFlight.setDestination(null);
		});
		assertEquals("destination cannot be blank", exception.getMessage());
	}

	@Test
	public void testDestinationCheckingLength() {

		Throwable exception = assertThrows(SchedulingException.class, () -> {
			ScheduleFlight scheduleFlight = new ScheduleFlight();
			scheduleFlight.setDestination("ab");
		});

		assertEquals("Invalid city", exception.getMessage());

	}

	// seatingCapacity
	@Test
	public void testDurationIsNull() {

		Throwable exception = assertThrows(SchedulingException.class, () -> {
			ScheduleFlight scheduleFlight = new ScheduleFlight();
			scheduleFlight.setSeatingCapacity(0);
			
		});
		assertEquals("seatingCapacity cannot be blank", exception.getMessage());
	}

	// amount
	@Test
	public void testStarting_timeIsNull() {

		Throwable exception = assertThrows(SchedulingException.class, () -> {
			ScheduleFlight scheduleFlight = new ScheduleFlight();
			scheduleFlight.setAmount(0);
		});
		assertEquals("amount cannot be blank", exception.getMessage());
	}

}
