package com.dxc.airline;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
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
class AirlineMangementsystemApplicationTests {

	@Autowired
	 UserServiceImplementation userServiceImplementation;

	@MockBean
	 UserRepository userRepository;

	@Test
	public void getUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream
				.of(new User("pasupathi@gmail.com", "pasupathi")).collect(Collectors.toList()));
		assertEquals(1, userServiceImplementation.findAll().size());
	}

//	@Test
//	public void getUserbyUsernameTest() {
//		String username = "aaaa@gmail.com";
//		when(userRepository.findById(username))
//		.thenReturn(Stream
//				.of(new User("pasupathi@gmail.com", "pasupathi")).collect(Collectors.toList()));
//		assertEquals(1, service.getUserbyAddress(address).size());
//	}

	@Test
	public void saveUserTest() {
		User user = new User("aaa@gmail.com", "aaa");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userServiceImplementation.save(user));
	}

//	@Test
//	public void deleteUserTest() {
//		User user = new User(999, "Pranya", 33, "Pune");
//		service.deleteUser(user);
//		verify(repository, times(1)).delete(user);
//	}


}
