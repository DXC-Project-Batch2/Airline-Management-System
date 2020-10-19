package com.dxc.airline;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.dxc.airline.model.UserInfo;
import com.dxc.airline.repository.UserInfoRepository;
import com.dxc.airline.service.UserInfoServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoTest {
	
	@Autowired
	UserInfoServiceImplementation userInfoServiceImplementation;

	@MockBean
	UserInfoRepository userInfoRepository;

	@Test
	public void userInfofindAllTest() throws ParseException{
		when(userInfoRepository.findAll()).thenReturn(Stream.of(
				new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com"),new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com")
				).collect(Collectors.toList()));
		assertEquals(2, userInfoServiceImplementation.findAll().size());
	}

	@Test
	public void userInfofindByUsernameTest() throws ParseException{
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");
		when(userInfoRepository.findById("pasupathi@dxc.com")).thenReturn(Optional.of(userInfo));
		assertEquals(userInfo, userInfoServiceImplementation.findByUsername(userInfo.getUsername()));
	}

	@Test
	public void saveuserInfoTest() throws ParseException{
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");
		when(userInfoRepository.save(userInfo)).thenReturn(userInfo);
		assertEquals(userInfo, userInfoServiceImplementation.save(userInfo));
	}

	@Test
	public void deleteuserInfoTest(){
		String username = "aaa@gmail.com";
		userInfoServiceImplementation.deleteById(username);
		verify(userInfoRepository, times(1)).deleteById(username);
	}

}
