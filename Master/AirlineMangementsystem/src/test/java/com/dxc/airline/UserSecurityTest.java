package com.dxc.airline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.repository.UserSecurityRepository;
import com.dxc.airline.service.UserSecurityServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSecurityTest {
	
	@Autowired
	UserSecurityServiceImp userSecurityServiceImp;

	@MockBean
	UserSecurityRepository userSecurityRepository;
	
	@Test
	public void UserSecurityfindAllTest() {
		when(userSecurityServiceImp.findAll()).thenReturn(Stream
				.of(new UserSecurity("pasupathi@gmail.com", "what is favorite number?", "100"),
						new UserSecurity("p@gmail.com", "what is favorite number?", "100"))
				.collect(Collectors.toList()));
		assertEquals(2, userSecurityServiceImp.findAll().size());
	}

	@Test
	public void UserSecurityfindByUsernameTest() {
		
		UserSecurity userSecurity = new UserSecurity("p@gmail.com", "what is favorite number?", "100");
		when(userSecurityRepository.findById("p@gmail.com")).thenReturn(Optional.of(userSecurity));
		assertEquals(userSecurity, userSecurityServiceImp.findByUsername(userSecurity.getUsername()));
		
	}

	@Test
	public void saveUserSecurityTest() {
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is favorite number?", "100");
		when(userSecurityRepository.save(userSecurity)).thenReturn(userSecurity);
		assertEquals(userSecurity, userSecurityServiceImp.add(userSecurity));
	}

	@Test
	public void deleteUserSecurityTest() {
		String username = "aaa@gmail.com";
		userSecurityServiceImp.deleteById(username);
		verify(userSecurityRepository, times(1)).deleteById(username);
	}


}
