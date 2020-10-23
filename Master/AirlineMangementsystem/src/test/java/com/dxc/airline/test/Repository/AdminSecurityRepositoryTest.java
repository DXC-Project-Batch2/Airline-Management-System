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

import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.repository.AdminSecurityRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminSecurityRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	AdminSecurityRepository adminSecurityRepository;
	
	//save
	@Test
	public void testSaveAdminSecurity(){
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		AdminSecurity savedInDb = entityManager.persist(adminSecurity);
		AdminSecurity getFromDatabase = adminSecurityRepository.getOne(savedInDb.getUsername());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetAdminSecurityById(){
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");

		//Save adminSecurity in DB
		AdminSecurity adminSecuritySavedInDb = entityManager.persist(adminSecurity);
		
		//Get adminSecurity from DB
		Optional<AdminSecurity> adminSecurityFromInDb = adminSecurityRepository.findById(adminSecurity.getUsername());
		assertThat(adminSecuritySavedInDb).isEqualTo(adminSecurityFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllAdminSecuritys(){
		
		AdminSecurity adminSecurity1 = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		AdminSecurity adminSecurity2 = new AdminSecurity("anil@dxc.com", "what is your favorite colour?","red");
		
		//Save both adminSecurity in DB
		entityManager.persist(adminSecurity1);
		entityManager.persist(adminSecurity2);
		
		List<AdminSecurity> adminSecurities = adminSecurityRepository.findAll();
		assertThat(adminSecurities.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeleteAdminSecurityById(){
	
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");

		//Save adminSecurity in DB
		entityManager.persist(adminSecurity);
		
		//delete one adminSecurity DB
		entityManager.remove(adminSecurity);
		
		List<AdminSecurity> adminSecurities = adminSecurityRepository.findAll();
		assertThat(adminSecurities.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateAdminSecurity(){
		
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");

		
		//save adminSecurity info in DB
		entityManager.persist(adminSecurity);
		
		AdminSecurity getFromDb = adminSecurityRepository.findById(adminSecurity.getUsername()).get();

		getFromDb.setSecurityQuestion("what is your favorite place?");
		getFromDb.setAnswer("chennai");
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getSecurityQuestion()).isEqualTo("what is your favorite place?");
		assertThat(getFromDb.getAnswer()).isEqualTo("chennai");
	}
	
}
