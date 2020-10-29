package com.dxc.airline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.repository.AdminInfoRepository;
import com.dxc.airline.service.AdminInfoServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminInfoTest {
	
	@Autowired
	AdminInfoServiceImplementation adminInfoServiceImplementation;

	@MockBean
	AdminInfoRepository adminInfoRepository;

	
	//postive cases
	
	@Test
	public void adminInfofindAllTest() throws ParseException{
		when(adminInfoRepository.findAll()).thenReturn(Stream.of(
				new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com"),new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com")
				).collect(Collectors.toList()));
		assertEquals(2, adminInfoServiceImplementation.findAll().size());
	}

	@Test
	public void adminInfofindByUsernameTest() throws ParseException{
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");
		when(adminInfoRepository.findById("pasupathi@dxc.com")).thenReturn(Optional.of(adminInfo));
		assertEquals(adminInfo, adminInfoServiceImplementation.findByUsername(adminInfo.getUsername()));
	}

	@Test
	public void saveadminInfoTest() throws ParseException{
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");
		when(adminInfoRepository.save(adminInfo)).thenReturn(adminInfo);
		assertEquals(adminInfo, adminInfoServiceImplementation.save(adminInfo));
	}

	@Test
	public void deleteadminInfoTest() throws ParseException{
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");
		adminInfoServiceImplementation.delete(adminInfo.getUsername());
		verify(adminInfoRepository, times(1)).deleteById(adminInfo.getUsername());
	}
	
	
	//negative cases
	
	@Test
	public void NotsaveadminInfoTest() throws ParseException{
		AdminInfo adminInfo=null;
		when(adminInfoRepository.save(adminInfo)).thenReturn(adminInfo);
		assertEquals(adminInfo, adminInfoServiceImplementation.save(adminInfo));
		assertEquals(adminInfo, adminInfoServiceImplementation.save(adminInfo));
	}
	
	@Test
	public void adminInfofindByUsername_NoFoundTest() throws ParseException{
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");
		when(adminInfoRepository.findById("pasupathi@dxc.com")).thenReturn(Optional.of(adminInfo));
		assertEquals(adminInfo!=null, adminInfoServiceImplementation.findByUsername("pasupathi143@dxc.com")==null);
	}

}
