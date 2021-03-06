package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.dxc.airline.exception.UserInfoException;
import com.dxc.airline.model.UserInfo;

public class UserInfoExceptionTest {
	
	// name
	@Test
	public void testNameIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setName(null);
		});
		assertEquals("name cannot be blank", exception.getMessage());
	}
	
	// lastname
	@Test
	public void testlastnameIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setLastname(null);
		});
		assertEquals("lastname cannot be blank", exception.getMessage());
	}

	// gender
	@Test
	public void testGenderIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setGender(null);
		});
		assertEquals("gender cannot be blank", exception.getMessage());
	}

	// fathername
	@Test
	public void testFathernameIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setFathername(null);
		});
		assertEquals("fathername cannot be blank", exception.getMessage());
	}
	
	// passportname
	@Test
	public void testPassportnameIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setPassportname(null);
		});
		assertEquals("passportname cannot be blank", exception.getMessage());
	}

	// passportnumber
	@Test
	public void testPassportnumberIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setPassportnumber(0);
		});
		assertEquals("passportnumber cannot be blank", exception.getMessage());
	}
	
	@Test
	public void testPassportnumberCheckingLength() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setPassportnumber(123456789);
		});

		assertEquals("passportnumber number is Invalid or its should contains 8 digits", exception.getMessage());

	}

	// doorNumber
	@Test
	public void testDoorNumberIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setDoorNumber(null);
		});
		assertEquals("doorNumber cannot be blank", exception.getMessage());
	}
	
	// Street
	@Test
	public void testStreetIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setStreet(null);
		});
		assertEquals("street cannot be blank", exception.getMessage());
	}
	
	// Area
	@Test
	public void testAreaIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setArea(null);;
		});
		assertEquals("area cannot be blank", exception.getMessage());
	}
	
	// Country
	@Test
	public void testCountryIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setCountry(null);;
		});
		assertEquals("country cannot be blank", exception.getMessage());
	}

	// State
	@Test
	public void testStateIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setState(null);
		});
		assertEquals("state cannot be blank", exception.getMessage());
	}

	// City
	@Test
	public void testCityIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setCity(null);
		});
		assertEquals("city cannot be blank", exception.getMessage());
	}

	// postalCode
	@Test
	public void testPostalCodeIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setPostalCode(0);
		});
		assertEquals("postalCode cannot be blank", exception.getMessage());
	}

	@Test
	public void testPostalCodeCheckingLength() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setPostalCode(534101101);
		});

		assertEquals("postalCode number is Invalid or its should contains 6 digits", exception.getMessage());

	}

	// mobile
	@Test
	public void testMobileIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setMobile(null);
		});
		assertEquals("mobile cannot be blank", exception.getMessage());
	}

	@Test
	public void testMobileCheckingLength() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setMobile("534101101");
		});

		assertEquals("mobile number is Invalid or its should contains 10 digits", exception.getMessage());

	}

	// username
	@Test
	public void testUsernameIsNull() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(null);
		});
		assertEquals("Username cannot be blank", exception.getMessage());
	}

	@Test
	public void testUsernameCheckingLength() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername("aa@gmail.com");
		});

		assertEquals("Username is too short", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingLength1() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername("aaaaaaaaaaaaaaaaaa@yahoo.com");
		});

		assertEquals("Username is too long", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingEndSwitch() {

		Throwable exception = assertThrows(UserInfoException.class, () -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername("pasupathi@dxc.com");
		});

		assertEquals("Username should ends with @gmail.com or @yahoo.com", exception.getMessage());

	}

}
