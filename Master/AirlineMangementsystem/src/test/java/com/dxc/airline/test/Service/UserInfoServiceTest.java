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

import com.dxc.airline.model.UserInfo;
import com.dxc.airline.repository.UserInfoRepository;
import com.dxc.airline.service.UserInfoServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

	@Autowired
	private UserInfoServiceImplementation userInfoServiceImplementation;
	
	@MockBean
	private UserInfoRepository userInfoRepository;
	
	//save
	@Test
	public void saveTest() throws ParseException{

		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		
	    Mockito.when(userInfoRepository.save(userInfo)).thenReturn(userInfo);
	    
	    assertThat(userInfoServiceImplementation.save(userInfo)).isEqualTo(userInfo);
	
	}
	
	//findbyId
	@Test
	public void findByIdTest() throws ParseException{
		
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		Mockito.when(userInfoRepository.findById(userInfo.getUsername())).thenReturn(Optional.of(userInfo));
	    assertThat(userInfoServiceImplementation.findByUsername(userInfo.getUsername())).isEqualTo(userInfo);
	}
	
	//findAll
	@Test
	public void findallTest() throws ParseException{

		UserInfo userInfo1 = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		UserInfo userInfo2 = new UserInfo("anil", "kumar", "male", "18-07-1999", "bhadra", "Anil Kumar", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "anil@gmail.com");	

		List<UserInfo> userInfos = new ArrayList<>();
		userInfos.add(userInfo1);
		userInfos.add(userInfo2);
		
		Mockito.when(userInfoRepository.findAll()).thenReturn(userInfos);
		
		assertThat(userInfoServiceImplementation.findAll()).isEqualTo(userInfos);
	}
	
	//delete
	@Test
	public void deleteTest() throws ParseException{

		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		
	    Mockito.when(userInfoRepository.findById(userInfo.getUsername())).thenReturn(Optional.of(userInfo));
	    Mockito.when(userInfoRepository.existsById(userInfo.getUsername())).thenReturn(false);
	   
	    assertFalse(userInfoRepository.existsById(userInfo.getUsername()));
	}
	
	//update
	@Test
	public void updateTest() throws ParseException{
		
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
		
	    Mockito.when(userInfoRepository.findById(userInfo.getUsername())).thenReturn(Optional.of(userInfo));
		
	    userInfo.setFathername("Bhadra Rao");
	    userInfo.setLastname("Nadh Aduri");
		
		Mockito.when(userInfoRepository.save(userInfo)).thenReturn(userInfo);
		
		assertThat(userInfoServiceImplementation.update(userInfo)).isEqualTo(userInfo);
		
	}
	
	//negative cases
	
			@Test
			public void NotsaveTest() throws ParseException{
				
				UserInfo userInfo = null;
					
				Mockito.when(userInfoRepository.save(userInfo)).thenReturn(userInfo);
		    
				assertThat(userInfoServiceImplementation.save(userInfo)).isEqualTo(userInfo);
				}
			
			@Test
			public void findByUsername_NoFoundTest() throws ParseException{
				UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
			    Mockito.when(userInfoRepository.findById("anil@dxc.com")).thenReturn(Optional.of(userInfo));
			    assertThat(userInfoServiceImplementation.findByUsername("anil@dxc.com")).isEqualTo(userInfo);
			}

			@Test
			public void NotupdateTest() throws ParseException{
				
				UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");	
					
				Mockito.when(userInfoRepository.findById("anil@dxc.com")).thenReturn(Optional.of(userInfo));
				
				userInfo.setFathername("Bhadra Rao");
				userInfo.setLastname("Nadh Aduri");
				
				Mockito.when(userInfoRepository.save(userInfo)).thenReturn(userInfo);
				
				assertThat(userInfoServiceImplementation.update(userInfo)).isNotEqualTo(userInfo);
				
			}

	
}
