package com.dxc.airline.test.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.User;
import com.dxc.airline.repository.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	UserRepository userRepository;
	
	//save
	@Test
	public void testSaveUser(){
		User user = new User("pasupathi@gmail.com", "Pasupathi123@");
		User savedInDb = entityManager.persist(user);
		User getFromDatabase = userRepository.getOne(savedInDb.getUsername());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetUserById(){
		User user = new User("pasupathi@gmail.com", "Pasupathi123@");
		//Save user in DB
		User userSavedInDb = entityManager.persist(user);
		
		//Get user from DB
		Optional<User> userFromInDb = userRepository.findById(user.getUsername());
		assertThat(userSavedInDb).isEqualTo(userFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllUsers(){
		
		User user1 = new User("pasupathi@gmail.com", "pasupath123A@i");		
		User user2 = new User("anil@gmail.com", "an111@Ail");
		
		//Save both user in DB
		entityManager.persist(user1);
		entityManager.persist(user2);
		
		List<User> users = userRepository.findAll();
		assertThat(users.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeleteUserById(){
	
		User user = new User("pasupathi@yahoo.com", "Pasupathi123@");
		
		//Save user in DB
		entityManager.persist(user);
		
		//delete one user DB
		entityManager.remove(user);
		
		List<User> users = userRepository.findAll();
		assertThat(users.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateUser(){
		
		User user = new User("pasupathi@gmail.com", "Pasupathi123@");
		
		//save user info in DB
		entityManager.persist(user);
		
		User getFromDb = userRepository.findById(user.getUsername()).get();

		getFromDb.setPassword("pasuPathi143@");
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getPassword()).isEqualTo("pasuPathi143@");
	}
	
}
