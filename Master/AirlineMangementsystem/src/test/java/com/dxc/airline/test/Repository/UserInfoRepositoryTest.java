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

import com.dxc.airline.model.UserInfo;
import com.dxc.airline.repository.UserInfoRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserInfoRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	//save
	@Test
	public void testSaveUserInfo() throws ParseException{
		
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		UserInfo savedInDb = entityManager.persist(userInfo);
		UserInfo getFromDatabase = userInfoRepository.getOne(savedInDb.getUsername());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetUserInfoById() throws ParseException{
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		//Save userInfo in DB
		UserInfo userInfoSavedInDb = entityManager.persist(userInfo);
		
		//Get userInfo from DB
		Optional<UserInfo> userInfoFromInDb = userInfoRepository.findById(userInfo.getUsername());
		assertThat(userInfoSavedInDb).isEqualTo(userInfoFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllUserInfos() throws ParseException{
		
		UserInfo userInfo1 = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		UserInfo userInfo2 = new UserInfo("anil", "kumar", "male", "18-07-1999", "bhadra", "Anil Kumar", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "anil@gmail.com");	
		
		//Save both userInfo in DB
		entityManager.persist(userInfo1);
		entityManager.persist(userInfo2);
		
		List<UserInfo> userInfos = userInfoRepository.findAll();
		assertThat(userInfos.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeleteUserInfoById() throws ParseException{
	
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		
		//Save userInfo in DB
		entityManager.persist(userInfo);
		
		//delete one userInfo DB
		entityManager.remove(userInfo);
		
		List<UserInfo> userInfos = userInfoRepository.findAll();
		assertThat(userInfos.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateUserInfo() throws ParseException{
		
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		
		//save userInfo info in DB
		entityManager.persist(userInfo);
		
		UserInfo getFromDb = userInfoRepository.findById(userInfo.getUsername()).get();

		getFromDb.setFathername("Bhadra Rao");
		getFromDb.setLastname("Nadh Aduri");
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getFathername()).isEqualTo("Bhadra Rao");
		assertThat(getFromDb.getLastname()).isEqualTo("Nadh Aduri");
	}
	
}
