package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.dxc.airline.exception.PassengerException;
import com.dxc.airline.model.Passenger;

public class PassengerExceptionTest {

	// flightId
	@Test
	public void testFlightIdIsNull() {

		Throwable exception = assertThrows(PassengerException.class, () -> {
			Passenger passenger = new Passenger();
			passenger.setFlight_id(0);
		});
		assertEquals("flightId cannot be blank", exception.getMessage());
	}

	// gender
	@Test
	public void testGenderIsNull() {

		Throwable exception = assertThrows(PassengerException.class, () -> {
			Passenger passenger = new Passenger();
			passenger.setGender(null);
		});
		assertEquals("gender cannot be blank", exception.getMessage());
	}

	// age
	@Test
	public void testAgeIsNull() {

		Throwable exception = assertThrows(PassengerException.class, () -> {
			Passenger passenger = new Passenger();
			passenger.setAge(0);
		});
		assertEquals("age cannot be blank", exception.getMessage());
	}

	// govt_id
	@Test
	public void testDurationIsNull() {

		Throwable exception = assertThrows(PassengerException.class, () -> {
			Passenger passenger = new Passenger();
			passenger.setGovt_id(0);
		});
		assertEquals("govt_id cannot be blank", exception.getMessage());
	}
	
	// name
		@Test
		public void testNameIsNull() {

			Throwable exception = assertThrows(PassengerException.class, () -> {
				Passenger passenger = new Passenger();
				passenger.setName(null);
			});
			assertEquals("name cannot be blank", exception.getMessage());
		}
//username
		@Test
		public void testUsernameIsNull() {

			Throwable exception = assertThrows(PassengerException.class, () -> {
				Passenger passenger = new Passenger();
				passenger.setUsername(null);
			});
			assertEquals("Username cannot be blank", exception.getMessage());
		}

		@Test
		public void testUsernameCheckingLength() {

			Throwable exception = assertThrows(PassengerException.class, () -> {
				Passenger passenger = new Passenger();
				passenger.setUsername("aa@gmail.com");
			});

			assertEquals("Username is too short", exception.getMessage());

		}

		@Test
		public void testUsernameCheckingLength1() {

			Throwable exception = assertThrows(PassengerException.class, () -> {
				Passenger passenger = new Passenger();
				passenger.setUsername("aaaaaaaaaaaaaaaaaa@yahoo.com");
			});

			assertEquals("Username is too long", exception.getMessage());

		}

		@Test
		public void testUsernameCheckingEndSwitch() {

			Throwable exception = assertThrows(PassengerException.class, () -> {
				Passenger passenger = new Passenger();
				passenger.setUsername("pasupathi@dxc.com");
			});

			assertEquals("Username should ends with @gmail.com or @yahoo.com", exception.getMessage());

		}

}
