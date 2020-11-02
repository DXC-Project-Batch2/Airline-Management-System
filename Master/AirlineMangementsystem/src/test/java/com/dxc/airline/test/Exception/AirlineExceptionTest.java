package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.dxc.airline.exception.AirlineException;
import com.dxc.airline.model.AirLine;

public class AirlineExceptionTest {

	// planeId
	@Test
	public void testFlightIdIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setPlaneId(0);
		});
		assertEquals("planeId cannot be blank", exception.getMessage());
	}

	// carrierName
	@Test
	public void testCarrierNameIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setCarrierName(null);
		});
		assertEquals("carrierName cannot be blank", exception.getMessage());
	}

	@Test
	public void testcarrierNameCheckingLength() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setCarrierName("ab");
		});

		assertEquals("Invalid carrierName", exception.getMessage());

	}

	// source
	@Test
	public void testSourceIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setSource(null);
		});
		assertEquals("source cannot be blank", exception.getMessage());
	}

	@Test
	public void testSourceCheckingLength() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setSource("ab");
		});

		assertEquals("Invalid city", exception.getMessage());

	}

	// destination
	@Test
	public void testDestinationIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setDestination(null);
		});
		assertEquals("destination cannot be blank", exception.getMessage());
	}

	@Test
	public void testDestinationCheckingLength() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setDestination("ab");
		});

		assertEquals("Invalid city", exception.getMessage());

	}

	// duration
	@Test
	public void testDurationIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setDuration(null);
		});
		assertEquals("duration cannot be blank", exception.getMessage());
	}

	// starting_time
	@Test
	public void testStarting_timeIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setStarting_time(null);
		});
		assertEquals("starting_time cannot be blank", exception.getMessage());
	}

	// ending_time
	@Test
	public void testEnding_timeIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setEnding_time(null);
		});
		assertEquals("ending_time cannot be blank", exception.getMessage());
	}

	// prize
	@Test
	public void testPrizeIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setPrize(0);
		});
		assertEquals("prize cannot be blank", exception.getMessage());
	}

	// avaliable_seats
	@Test
	public void testavaliable_seatsIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setAvaliable_seats(0);
		});
		assertEquals("avaliable_seats cannot be blank", exception.getMessage());
	}

	// sold_out
	@Test
	public void testsold_outIsNull() {

		Throwable exception = assertThrows(AirlineException.class, () -> {
			AirLine airLine = new AirLine();
			airLine.setSold_out(-1);
		});
		assertEquals("sold_out cannot be blank", exception.getMessage());
	}

}
