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

import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.repository.UserSecurityRepository;
import com.dxc.airline.service.UserSecurityServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSecurityServiceTest {

	@Autowired
	private UserSecurityServiceImp userSecurityServiceImp;
	
	@MockBean
	private UserSecurityRepository userSecurityRepository;
	
	//save
	@Test
	public void saveTest(){

		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		
	    Mockito.when(userSecurityRepository.save(userSecurity)).thenReturn(userSecurity);
	    
	    assertThat(userSecurityServiceImp.add(userSecurity)).isEqualTo(userSecurity);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		Mockito.when(userSecurityRepository.findById(userSecurity.getUsername())).thenReturn(Optional.of(userSecurity));
	    assertThat(userSecurityServiceImp.findByUsername(userSecurity.getUsername())).isEqualTo(userSecurity);
	}
	
	//findAll
	@Test
	public void findallTest(){

		UserSecurity userSecurity1 = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		
		UserSecurity userSecurity2 = new UserSecurity("anil@gmail.com", "what is your favorite colour?","red");
		
		List<UserSecurity> userSecurities = new ArrayList<>();
		userSecurities.add(userSecurity1);
		userSecurities.add(userSecurity2);
		
		Mockito.when(userSecurityRepository.findAll()).thenReturn(userSecurities);
		
		assertThat(userSecurityServiceImp.findAll()).isEqualTo(userSecurities);
	}
	
	//delete
	@Test
	public void deleteTest(){

		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		
	    Mockito.when(userSecurityRepository.findById(userSecurity.getUsername())).thenReturn(Optional.of(userSecurity));
	    Mockito.when(userSecurityRepository.existsById(userSecurity.getUsername())).thenReturn(false);
	   
	    assertFalse(userSecurityRepository.existsById(userSecurity.getUsername()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		
	    Mockito.when(userSecurityRepository.findById(userSecurity.getUsername())).thenReturn(Optional.of(userSecurity));
		
	    userSecurity.setSecurityQuestion("what is your favorite colour?");
	    userSecurity.setAnswer("red");
		
		Mockito.when(userSecurityRepository.save(userSecurity)).thenReturn(userSecurity);
		
		assertThat(userSecurityServiceImp.update(userSecurity)).isEqualTo(userSecurity);
		
	}
	
	@Test
	public void NotsaveTest() throws ParseException{
		
		UserSecurity userSecurity = null;
		
		Mockito.when(userSecurityRepository.save(userSecurity)).thenReturn(userSecurity);
    
		assertThat(userSecurityServiceImp.add(userSecurity)).isEqualTo(userSecurity);
		}
	
	@Test
	public void findByUsername_NoFoundTest() throws ParseException{
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		Mockito.when(userSecurityRepository.findById("anil@dxc.com")).thenReturn(Optional.of(userSecurity));
	    assertThat(userSecurityServiceImp.findByUsername("anil@dxc.com")).isEqualTo(userSecurity);
	}

	@Test
	public void NotupdateTest() throws ParseException{
		
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
				
		Mockito.when(userSecurityRepository.findById("anil@dxc.com")).thenReturn(Optional.of(userSecurity));
		
		userSecurity.setSecurityQuestion("what is your favorite place?");
		userSecurity.setAnswer("tadepalligudem");
		
		Mockito.when(userSecurityRepository.save(userSecurity)).thenReturn(userSecurity);
		
		assertThat(userSecurityServiceImp.update(userSecurity)).isNotEqualTo(userSecurity);
		
	}


	
}
