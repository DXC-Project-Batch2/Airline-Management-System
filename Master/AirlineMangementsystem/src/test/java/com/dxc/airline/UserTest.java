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

import com.dxc.airline.model.User;
import com.dxc.airline.repository.UserRepository;
import com.dxc.airline.service.UserServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	public void UserfindAllTest() {
		when(userRepository.findAll()).thenReturn(
				Stream.of(new User("pasupathi@gmail.com", "pasupathi"), new User("p@gmail.com", "pasupathi"))
						.collect(Collectors.toList()));
		assertEquals(2, userServiceImplementation.findAll().size());
	}

	@Test
	public void UserfindByUsernameTest() {
		
		User user = new User("p@gmail.com", "ppp");
		when(userRepository.findById("p@gmail.com")).thenReturn(Optional.of(user));
		assertEquals(user, userServiceImplementation.findById(user.getUsername()));
	}

	@Test
	public void saveUserTest() {
		User user = new User("aaa@gmail.com", "aaa");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userServiceImplementation.save(user));
	}

	@Test
	public void deleteUserTest() {
		String username = "aaa@gmail.com";
		userServiceImplementation.deleteById(username);
		verify(userRepository, times(1)).deleteById(username);
	}


}
