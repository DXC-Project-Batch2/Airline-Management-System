package com.dxc.airline.test.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.dxc.airline.exception.UserSecurityException;
import com.dxc.airline.model.UserSecurity;

public class UserSecurityExceptionTest {

	@Test
	public void testUsernameIsNull() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setUsername(null);
		});
		assertEquals("Username cannot be blank", exception.getMessage());
	}

	@Test
	public void testUsernameCheckingLength() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setUsername("aa@gmail.com");
		});

		assertEquals("Username is too short", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingLength1() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setUsername("aaaaaaaaaaaaaaaaaa@yahoo.com");
		});

		assertEquals("Username is too long", exception.getMessage());

	}

	@Test
	public void testUsernameCheckingEndSwitch() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setUsername("pasupathi@dxc.com");
		});

		assertEquals("Username should ends with @gmail.com or @yahoo.com", exception.getMessage());

	}

	// if securityQuestion is null
	@Test
	public void testsecurityQuestionIsNull() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setSecurityQuestion(null);
		});

		assertEquals("securityQuestion cannot be blank", exception.getMessage());
	}

	// if adminSecurity is length is less than 6
	@Test
	public void testsecurityQuestionChecking_Min_Len() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setSecurityQuestion("3 + 4");
		});

		assertEquals("securityQuestion is too short or Invalid", exception.getMessage());
	}

	// if adminSecurity is length is greater than 100
	@Test
	public void testsecurityQuestionChecking_Max_Len() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setSecurityQuestion("ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp");
		});

		assertEquals("securityQuestion should not contain any complexity", exception.getMessage());

	}

	// if answer is null
	@Test
	public void testAnswerIsNull() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setAnswer(null);
		});

		    assertEquals("Answer cannot be blank", exception.getMessage());

	}

	// if answer is length is greater than 30
	@Test
	public void testAnswerLength() {

		Throwable exception = assertThrows(UserSecurityException.class, () -> {
			UserSecurity userSecurity = new UserSecurity();
			userSecurity.setAnswer("PASUPATHIIhtapusappasupathiPasupathi");
		});

		    assertEquals("Answer should not be too much complexity because its to remember!!!", exception.getMessage());
	}

}
