package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.dxc.airline.exception.AdminException;
import com.dxc.airline.model.Admin;

public class AdminExceptionTest {

	@Test
	public void testUsernameIsNull() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setUsername(null);
		});
		assertEquals("Username cannot be blank", exception.getMessage());
	}

	@Test
	public void testUsernameCheckingLength() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setUsername("aa@dxc.com");
		});

		assertEquals("Username is too short", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingLength1() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setUsername("aaaaaaaaaaaaaaaaaa@dxc.com");
		});

		assertEquals("Username is too long", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingEndSwitch() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setUsername("pasupathi@gmail.com");
		});

		assertEquals("Username should ends with @dxc.com", exception.getMessage());

	}

	// if password is null
	@Test
	public void testpasswordIsNull() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setPassword(null);
		});

		assertEquals("Password cannot be blank", exception.getMessage());
	}

	// if password is length is less than 8
	@Test
	public void testpasswordChecking_Min_Len() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setPassword("ppppp");
		});

		assertEquals("Password must be more than 8 characters in length", exception.getMessage());
	}

	// if password is length is greater than 20
	@Test
	public void testpasswordChecking_Max_Len() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setPassword("ppppppppppppppppppppppppp");
		});

		assertEquals("Password must be less than 20characters in length", exception.getMessage());

	}

	// if password don't have any uppercase
	@Test
	public void testpassword_with_UpperCase() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setPassword("pasupathi");
		});

		    assertEquals("Password must have atleast one uppercase character", exception.getMessage());

	}

	// if password don't have any lowercasse
	@Test
	public void testpassword_with_LowerCase() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setPassword("PASUPATHI");
		});

		    assertEquals("Password must have atleast one lowercase character", exception.getMessage());
	}

	// if password don't have atleast one number
	@Test
	public void testpassword_contains_Number() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setPassword("Pasupathi");
		});

	    assertEquals("Password must have atleast one number", exception.getMessage());
	}

	// if password don't have atleast one special character
	@Test
	public void testpassword_contains_specialcharacter() {

		Throwable exception = assertThrows(AdminException.class, () -> {
			Admin admin = new Admin();
			admin.setPassword("Pasupathi1");
		});

	    assertEquals("Password must have atleast one special character among @#$%", exception.getMessage());
	}

}
