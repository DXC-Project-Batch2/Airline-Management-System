package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.dxc.airline.exception.AdminSecurityException;
import com.dxc.airline.model.AdminSecurity;

public class AdminSecurityExceptionTest {

	@Test
	public void testUsernameIsNull() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setUsername(null);
		});
		assertEquals("Username cannot be blank", exception.getMessage());
	}

	@Test
	public void testUsernameCheckingLength() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setUsername("aa@dxc.com");
		});

		assertEquals("Username is too short", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingLength1() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setUsername("aaaaaaaaaaaaaaaaaa@dxc.com");
		});

		assertEquals("Username is too long", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingEndSwitch() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setUsername("pasupathi@gmail.com");
		});

		assertEquals("Username should ends with @dxc.com", exception.getMessage());

	}

	// if securityQuestion is null
	@Test
	public void testsecurityQuestionIsNull() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setSecurityQuestion(null);
		});

		assertEquals("securityQuestion cannot be blank", exception.getMessage());
	}

	// if adminSecurity is length is less than 6
	@Test
	public void testsecurityQuestionChecking_Min_Len() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setSecurityQuestion("3 + 4");
		});

		assertEquals("securityQuestion is too short or Invalid", exception.getMessage());
	}

	// if adminSecurity is length is greater than 100
	@Test
	public void testsecurityQuestionChecking_Max_Len() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setSecurityQuestion("ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp");
		});

		assertEquals("securityQuestion should not contain any complexity", exception.getMessage());

	}

	// if answer is null
	@Test
	public void testAnswerIsNull() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setAnswer(null);
		});

		    assertEquals("Answer cannot be blank", exception.getMessage());

	}

	// if answer is length is greater than 30
	@Test
	public void testAnswerLength() {

		Throwable exception = assertThrows(AdminSecurityException.class, () -> {
			AdminSecurity adminSecurity = new AdminSecurity();
			adminSecurity.setAnswer("PASUPATHIIhtapusappasupathiPasupathi");
		});

		    assertEquals("Answer should not be too much complexity because its to remember!!!", exception.getMessage());
	}

}
