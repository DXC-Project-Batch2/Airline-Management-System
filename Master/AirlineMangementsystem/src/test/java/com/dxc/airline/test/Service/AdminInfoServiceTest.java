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

import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.repository.AdminInfoRepository;
import com.dxc.airline.service.AdminInfoServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminInfoServiceTest {

	@Autowired
	private AdminInfoServiceImplementation adminInfoServiceImplementation;
	
	@MockBean
	private AdminInfoRepository adminInfoRepository;
	
	//save
	@Test
	public void saveTest() throws ParseException{

		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
			
	    Mockito.when(adminInfoRepository.save(adminInfo)).thenReturn(adminInfo);
	    
	    assertThat(adminInfoServiceImplementation.save(adminInfo)).isEqualTo(adminInfo);
	
	}
	
	//findbyId
	@Test
	public void findByIdTest() throws ParseException{
		
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");		
	    Mockito.when(adminInfoRepository.findById(adminInfo.getUsername())).thenReturn(Optional.of(adminInfo));
	    assertThat(adminInfoServiceImplementation.findByUsername(adminInfo.getUsername())).isEqualTo(adminInfo);
	}
	
	//findAll
	@Test
	public void findallTest() throws ParseException{

		AdminInfo adminInfo1 = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		AdminInfo adminInfo2 = new AdminInfo("anil", "kumar", "male", "18-07-1999", "bhadra", "Anil Kumar", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "anil@dxc.com");	
	
		List<AdminInfo> adminInfos = new ArrayList<>();
		adminInfos.add(adminInfo1);
		adminInfos.add(adminInfo2);
		
		Mockito.when(adminInfoRepository.findAll()).thenReturn(adminInfos);
		
		assertThat(adminInfoServiceImplementation.findAll()).isEqualTo(adminInfos);
	}
	
	//delete
	@Test
	public void deleteTest() throws ParseException{

		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		
	    Mockito.when(adminInfoRepository.findById(adminInfo.getUsername())).thenReturn(Optional.of(adminInfo));
	    Mockito.when(adminInfoRepository.existsById(adminInfo.getUsername())).thenReturn(false);
	   
	    assertFalse(adminInfoRepository.existsById(adminInfo.getUsername()));
	}
	
	//update
	@Test
	public void updateTest() throws ParseException{
		
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		
	    Mockito.when(adminInfoRepository.findById(adminInfo.getUsername())).thenReturn(Optional.of(adminInfo));
		
	    adminInfo.setFathername("Bhadra Rao");
	    adminInfo.setLastname("Nadh Aduri");
		
		Mockito.when(adminInfoRepository.save(adminInfo)).thenReturn(adminInfo);
		
		assertThat(adminInfoServiceImplementation.update(adminInfo)).isEqualTo(adminInfo);
		
	}
	
}
