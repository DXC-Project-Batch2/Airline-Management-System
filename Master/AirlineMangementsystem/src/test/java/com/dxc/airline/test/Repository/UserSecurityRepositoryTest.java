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

import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.repository.UserSecurityRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserSecurityRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	UserSecurityRepository userSecurityRepository;
	
	//save
	@Test
	public void testSaveAdminSecurity(){
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		UserSecurity savedInDb = entityManager.persist(userSecurity);
		UserSecurity getFromDatabase = userSecurityRepository.getOne(savedInDb.getUsername());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetAdminSecurityById(){
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");

		//Save userSecurity in DB
		UserSecurity adminSecuritySavedInDb = entityManager.persist(userSecurity);
		
		//Get userSecurity from DB
		Optional<UserSecurity> adminSecurityFromInDb = userSecurityRepository.findById(userSecurity.getUsername());
		assertThat(adminSecuritySavedInDb).isEqualTo(adminSecurityFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllAdminSecuritys(){
		
		UserSecurity userSecurity1 = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		UserSecurity userSecurity2 = new UserSecurity("anil@gmail.com", "what is your favorite colour?","red");
		
		//Save both userSecurity in DB
		entityManager.persist(userSecurity1);
		entityManager.persist(userSecurity2);
		
		List<UserSecurity> userSecurities = userSecurityRepository.findAll();
		assertThat(userSecurities.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeleteAdminSecurityById(){
	
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");

		//Save userSecurity in DB
		entityManager.persist(userSecurity);
		
		//delete one userSecurity DB
		entityManager.remove(userSecurity);
		
		List<UserSecurity> userSecurities = userSecurityRepository.findAll();
		assertThat(userSecurities.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateAdminSecurity(){
		
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");

		
		//save userSecurity info in DB
		entityManager.persist(userSecurity);
		
		UserSecurity getFromDb = userSecurityRepository.findById(userSecurity.getUsername()).get();

		getFromDb.setSecurityQuestion("what is your favorite place?");
		getFromDb.setAnswer("chennai");
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getSecurityQuestion()).isEqualTo("what is your favorite place?");
		assertThat(getFromDb.getAnswer()).isEqualTo("chennai");
	}
	
}
