package com.dxc.airline.test.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.User;
import com.dxc.airline.repository.UserRepository;
import com.dxc.airline.service.UserServiceImplementation;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	@MockBean
	private UserRepository userRepository;
	
	//save
	@Test
	public void saveTest(){

		User user = new User("pasupathi@gmail.com", "pasupathi");
		
	    Mockito.when(userRepository.save(user)).thenReturn(user);
	    
	    assertThat(userServiceImplementation.save(user)).isEqualTo(user);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		User user = new User("pasupathi@gmail.com", "pasupathi");
	    Mockito.when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));
	    assertThat(userServiceImplementation.findById(user.getUsername())).isEqualTo(user);
	}
	
	//findAll
	@Test
	public void findallTest(){

		User user1 = new User("pasupathi@gmail.com", "pasupathi");		
		
		User user2 = new User("krishna@gmail.com", "krishna");		
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		
		Mockito.when(userRepository.findAll()).thenReturn(users);
		
		assertThat(userServiceImplementation.findAll()).isEqualTo(users);
	}
	
	//delete
	@Test
	public void deleteTest(){

		User user = new User("pasupathi@gmail.com", "pasupathi");
		
	    Mockito.when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));
	    Mockito.when(userRepository.existsById(user.getUsername())).thenReturn(false);
	   
	    assertFalse(userRepository.existsById(user.getUsername()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		User user = new User("krishna@gmail.com", "krishna");

	    Mockito.when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));
		
	    user.setPassword("krishna9897");
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		
		assertThat(userServiceImplementation.update(user)).isEqualTo(user);
		
	}
	
}
