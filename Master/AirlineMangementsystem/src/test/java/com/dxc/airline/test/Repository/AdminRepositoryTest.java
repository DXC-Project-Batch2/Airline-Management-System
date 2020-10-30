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

import com.dxc.airline.model.Admin;
import com.dxc.airline.repository.AdminRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	AdminRepository adminRepository;
	
	//save
	@Test
	public void testSaveAdmin(){
		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");
		Admin savedInDb = entityManager.persist(admin);
		Admin getFromDatabase = adminRepository.getOne(savedInDb.getUsername());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetAdminById(){
		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");
		//Save admin in DB
		Admin adminSavedInDb = entityManager.persist(admin);
		
		//Get admin from DB
		Optional<Admin> adminFromInDb = adminRepository.findById(admin.getUsername());
		assertThat(adminSavedInDb).isEqualTo(adminFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllAdmins(){
		
		Admin admin1 = new Admin("pasupathi@dxc.com", "pasupathi");		
		Admin admin2 = new Admin("anil@dxc.com", "anil");
		
		//Save both admin in DB
		entityManager.persist(admin1);
		entityManager.persist(admin2);
		
		List<Admin> admins = adminRepository.findAll();
		assertThat(admins.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeleteAdminById(){
	
		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");		
		
		//Save admin in DB
		entityManager.persist(admin);
		
		//delete one admin DB
		entityManager.remove(admin);
		
		List<Admin> admins = adminRepository.findAll();
		assertThat(admins.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateAdmin(){
		
		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");				
		
		//save admin info in DB
		entityManager.persist(admin);
		
		Admin getFromDb = adminRepository.findById(admin.getUsername()).get();

		getFromDb.setPassword("pasupathi143");
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getPassword()).isEqualTo("pasupathi143");
	}
	
}
