package com.dxc.airline.test.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
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

		User user = new User("pasupathi@gmail.com", "Pasupathi123@");
		
	    Mockito.when(userRepository.save(user)).thenReturn(user);
	    
	    assertThat(userServiceImplementation.save(user)).isEqualTo(user);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		User user = new User("pasupathi@gmail.com", "Pasupathi123@");
	    Mockito.when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));
	    assertThat(userServiceImplementation.findById(user.getUsername())).isEqualTo(user);
	}
	
	//findAll
	@Test
	public void findallTest(){

		User user1 = new User("pasupathi@gmail.com", "P123@asupathi");		
		
		User user2 = new User("krishna@gmail.com", "kR123@ishna");		
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		
		Mockito.when(userRepository.findAll()).thenReturn(users);
		
		assertThat(userServiceImplementation.findAll()).isEqualTo(users);
	}
	
	//findByUsernameAndPassword
	@Test
	public void findByUsernameAndPasswordTest(){
			
		User user = new User("pasupathi@gmail.com", "Pasupathi123@");
			    Mockito.when(userRepository.findByUsernameAndPassword("pasupathi@gmail.com", "Pasupathi123@")).thenReturn(user);
		    assertThat(userServiceImplementation.findByUsernameAndPassword("pasupathi@gmail.com", "Pasupathi123@")).isEqualTo(user);
	
	}

	
	//delete
	@Test
	public void deleteTest(){

		User user = new User("pasupathi@gmail.com", "Pasupathi123@");
		
	    Mockito.when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));
	    Mockito.when(userRepository.existsById(user.getUsername())).thenReturn(false);
	   
	    assertFalse(userRepository.existsById(user.getUsername()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		User user = new User("krishna@gmail.com", "krishnA123@");

	    Mockito.when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));
		
	    user.setPassword("kRishna9897#");
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		
		assertThat(userServiceImplementation.update(user)).isEqualTo(user);
		
	}
	
	//negative cases
	
			@Test
			public void NotsaveTest() throws ParseException{
				
				User user = null;
						
				Mockito.when(userRepository.save(user)).thenReturn(user);
		    
				assertThat(userServiceImplementation.save(user)).isEqualTo(user);
				}
			
			@Test
			public void userfindByUsername_NoFoundTest() throws ParseException{
				User user = new User("pasupathi@gmail.com", "Pasupathi123@");
			    Mockito.when(userRepository.findById("anil@gmail.com")).thenReturn(Optional.of(user));
			    assertThat(userServiceImplementation.findById("anil@gmail.com")).isEqualTo(user);
			}

			@Test
			public void NotupdateTest() throws ParseException{
				
				User user = new User("pasupathi@gmail.com", "Pasupathi123@");
								
				Mockito.when(userRepository.findById("anil@gmail.com")).thenReturn(Optional.of(user));
				
				user.setPassword("pasupathi1234@A");
				
				Mockito.when(userRepository.save(user)).thenReturn(user);
				
				assertThat(userServiceImplementation.update(user)).isNotEqualTo(user);
				
			}
			
			@Test
			public void NotfindByUsernameAndPasswordTest(){
					
				User user = new User("pasupathi@gmail.com", "Pasupathi123@");
				Mockito.when(userRepository.findByUsernameAndPassword("pasupathi@gmail.com", "pppppP123@")).thenReturn(user);
				assertThat(userServiceImplementation.findByUsernameAndPassword("pasupathi@gmail.com", "Pasupathi123@")).isNotEqualTo(user);
			
			}

	
}
