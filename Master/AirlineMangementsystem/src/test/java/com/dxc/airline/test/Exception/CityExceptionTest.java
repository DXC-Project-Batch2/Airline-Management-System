package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.dxc.airline.exception.CityException;
import com.dxc.airline.model.City;

public class CityExceptionTest {
	
	@Test
	public void testUsernameIsNull() {

		Throwable exception = assertThrows(CityException.class, () -> {
			City city = new City();
			city.setCity(null);
		});
		assertEquals("city cannot be blank", exception.getMessage());
	}

	@Test
	public void testUsernameCheckingLength() {

		Throwable exception = assertThrows(CityException.class, () -> {
			City city = new City();
			city.setCity("ab");
		});

		assertEquals("Invalid city", exception.getMessage());

	}
}
