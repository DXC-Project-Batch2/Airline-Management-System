package com.dxc.airline.test.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.Passenger;
import com.dxc.airline.repository.PassengerRepository;
import com.dxc.airline.service.PassengerServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassengerServiceTest {

	@Autowired
	private PassengerServiceImplementation passengerServiceImplementation;
	
	@MockBean
	private PassengerRepository passengerRepository;
	
	//save
	@Test
	public void saveTest(){

		Passenger passenger = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);

	    Mockito.when(passengerRepository.save(passenger)).thenReturn(passenger);
	    
	    assertThat(passengerServiceImplementation.save(passenger)).isEqualTo(passenger);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		Passenger passenger = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		Mockito.when(passengerRepository.findById(passenger.getGovt_id())).thenReturn(Optional.of(passenger));
	    assertThat(passengerServiceImplementation.findById(passenger.getGovt_id())).isEqualTo(passenger);
	}
	
	//findAll
	@Test
	public void findallTest(){

		Passenger passenger1 = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		Passenger passenger2 = new Passenger("anil@gmail.com", "anil kumar", "male", 22,11111, 101);
		
		List<Passenger> passengers = new ArrayList<>();
		passengers.add(passenger1);
		passengers.add(passenger2);
		
		Mockito.when(passengerRepository.findAll()).thenReturn(passengers);
		
		assertThat(passengerServiceImplementation.findAll()).isEqualTo(passengers);
	}

	//findByUserName
		@Test
		public void findByUserNameTest(){

			Passenger passenger1 = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
			Passenger passenger2 = new Passenger("anil@gmail.com", "anil kumar", "male", 22,11111, 101);
			
			List<Passenger> passengers = new ArrayList<>();
			passengers.add(passenger1);
			passengers.add(passenger2);
			
			Mockito.when(passengerRepository.findByUserName(passenger1.getUsername())).thenReturn(passengers);
			
			assertThat(passengerServiceImplementation.findByUserName(passenger1.getUsername())).isEqualTo(passengers);
		}

		//findByUser
		@Test
		public void findByUserTest(){

			Passenger passenger1 = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
			Passenger passenger2 = new Passenger("anil@gmail.com", "anil kumar", "male", 22,11111, 101);
			
			List<Passenger> passengers = new ArrayList<>();
			passengers.add(passenger1);
			passengers.add(passenger2);
			
			Mockito.when(passengerRepository.findByUser(passenger2.getUsername(), passenger2.getFlight_id())).thenReturn(passengers);
			
			assertThat(passengerServiceImplementation.findByUser(passenger2.getUsername(), passenger2.getFlight_id())).isEqualTo(passengers);
		}

	//delete
	@Test
	public void deleteTest(){

		Passenger passenger = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);

	    Mockito.when(passengerRepository.findById(passenger.getGovt_id())).thenReturn(Optional.of(passenger));
	    Mockito.when(passengerRepository.existsById(passenger.getGovt_id())).thenReturn(false);
	   
	    assertFalse(passengerRepository.existsById(passenger.getGovt_id()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		Passenger passenger = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		
	    Mockito.when(passengerRepository.findById(passenger.getGovt_id())).thenReturn(Optional.of(passenger));
		
		passenger.setAge(25);
		
		Mockito.when(passengerRepository.save(passenger)).thenReturn(passenger);
		
		assertThat(passengerServiceImplementation.update(passenger)).isEqualTo(passenger);
		
	}

	//negative cases
	
	//Notsave
		@Test
		public void NotsaveTest(){

			Passenger passenger = null;

		    Mockito.when(passengerRepository.save(passenger)).thenReturn(passenger);
		    
		    assertThat(passengerServiceImplementation.save(passenger)).isEqualTo(passenger);
		
		}
		
		
		//NotfindbyId
		@Test
		public void NotfindByIdTest(){
			
			Passenger passenger = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
			Random random = new Random(); 
			long id=random.nextLong();
			Mockito.when(passengerRepository.findById(id)).thenReturn(Optional.of(passenger));
		    assertThat(passengerServiceImplementation.findById(id)).isEqualTo(passenger);
		}
		
		//NotfindAll
		@Test
		public void NotfindallTest(){

			Passenger passenger1 = null;
			Passenger passenger2 = null;
			
			List<Passenger> passengers = new ArrayList<>();
			passengers.add(passenger1);
			passengers.add(passenger2);
			
			Mockito.when(passengerRepository.findAll()).thenReturn(passengers);
			
			assertThat(passengerServiceImplementation.findAll()).isEqualTo(passengers);
		}

		//NotfindByUserName
			@Test
			public void NotfindByUserNameTest(){

				Passenger passenger1 = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
				Passenger passenger2 = new Passenger("anil@gmail.com", "anil kumar", "male", 22,11111, 101);
				
				List<Passenger> passengers = new ArrayList<>();
				passengers.add(passenger1);
				passengers.add(passenger2);
				
				Mockito.when(passengerRepository.findByUserName("satish@gmail.com")).thenReturn(passengers);
				
				assertThat(passengerServiceImplementation.findByUserName("satish@gmail.com")).isEqualTo(passengers);
			}

			//NotfindByUser
			@Test
			public void NotfindByUserTest(){

				Passenger passenger1 = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
				Passenger passenger2 = new Passenger("anil@gmail.com", "anil kumar", "male", 22,11111, 101);
				
				List<Passenger> passengers = new ArrayList<>();
				passengers.add(passenger1);
				passengers.add(passenger2);
				
				Random random = new Random(); 
				int id=random.nextInt();
				
				Mockito.when(passengerRepository.findByUser("satish@gmail.com", id)).thenReturn(passengers);
				
				assertThat(passengerServiceImplementation.findByUser("satish@gmail.com", id)).isEqualTo(passengers);
			}
		
		//Notupdate
		@Test
		public void NotupdateTest(){
			
			Passenger passenger = new Passenger("pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
			
			Random random = new Random(); 
			long id=random.nextLong();
			
			
		    Mockito.when(passengerRepository.findById(id)).thenReturn(Optional.of(passenger));
			
			passenger.setAge(25);
			
			Mockito.when(passengerRepository.save(passenger)).thenReturn(passenger);
			
			assertThat(passengerServiceImplementation.update(passenger)).isNotEqualTo(passenger);
			
		}

}
