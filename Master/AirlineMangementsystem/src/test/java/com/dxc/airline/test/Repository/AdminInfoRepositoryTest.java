package com.dxc.airline.test.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.repository.AdminInfoRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminInfoRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	AdminInfoRepository adminInfoRepository;
	
	//save
	@Test
	public void testSaveAdminInfo() throws ParseException{
		
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		AdminInfo savedInDb = entityManager.persist(adminInfo);
		AdminInfo getFromDatabase = adminInfoRepository.getOne(savedInDb.getUsername());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetAdminInfoById() throws ParseException{
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		//Save adminInfo in DB
		AdminInfo adminSavedInDb = entityManager.persist(adminInfo);
		
		//Get adminInfo from DB
		Optional<AdminInfo> adminFromInDb = adminInfoRepository.findById(adminInfo.getUsername());
		assertThat(adminSavedInDb).isEqualTo(adminFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllAdminInfos() throws ParseException{
		
		AdminInfo adminInfo1 = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		AdminInfo adminInfo2 = new AdminInfo("anil", "kumar", "male", "18-07-1999", "bhadra", "Anil Kumar", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "anil@dxc.com");	
		
		//Save both adminInfo in DB
		entityManager.persist(adminInfo1);
		entityManager.persist(adminInfo2);
		
		List<AdminInfo> admins = adminInfoRepository.findAll();
		assertThat(admins.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeleteAdminInfoById() throws ParseException{
	
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		
		//Save adminInfo in DB
		entityManager.persist(adminInfo);
		
		//delete one adminInfo DB
		entityManager.remove(adminInfo);
		
		List<AdminInfo> adminInfos = adminInfoRepository.findAll();
		assertThat(adminInfos.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateAdminInfo() throws ParseException{
		
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		
		//save adminInfo info in DB
		entityManager.persist(adminInfo);
		
		AdminInfo getFromDb = adminInfoRepository.findById(adminInfo.getUsername()).get();

		getFromDb.setFathername("Bhadra Rao");
		getFromDb.setLastname("Nadh Aduri");
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getFathername()).isEqualTo("Bhadra Rao");
		assertThat(getFromDb.getLastname()).isEqualTo("Nadh Aduri");
	}
	
}
