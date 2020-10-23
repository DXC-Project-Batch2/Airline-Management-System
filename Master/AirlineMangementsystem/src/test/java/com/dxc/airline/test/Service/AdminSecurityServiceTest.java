package com.dxc.airline.test.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

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

import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.repository.AdminSecurityRepository;
import com.dxc.airline.service.AdminSecurityServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminSecurityServiceTest {

	@Autowired
	private AdminSecurityServiceImplementation adminSecurityServiceImplementation;
	
	@MockBean
	private AdminSecurityRepository adminSecurityRepository;
	
	//save
	@Test
	public void saveTest(){

		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		
	    Mockito.when(adminSecurityRepository.save(adminSecurity)).thenReturn(adminSecurity);
	    
	    assertThat(adminSecurityServiceImplementation.save(adminSecurity)).isEqualTo(adminSecurity);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		Mockito.when(adminSecurityRepository.findById(adminSecurity.getUsername())).thenReturn(Optional.of(adminSecurity));
	    assertThat(adminSecurityServiceImplementation.findByid(adminSecurity.getUsername())).isEqualTo(adminSecurity);
	}
	
	//findAll
	@Test
	public void findallTest(){

		AdminSecurity adminSecurity1 = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		
		AdminSecurity adminSecurity2 = new AdminSecurity("anil@dxc.com", "what is your favorite colour?","red");
		
		List<AdminSecurity> adminSecurities = new ArrayList<>();
		adminSecurities.add(adminSecurity1);
		adminSecurities.add(adminSecurity2);
		
		Mockito.when(adminSecurityRepository.findAll()).thenReturn(adminSecurities);
		
		assertThat(adminSecurityServiceImplementation.findAll()).isEqualTo(adminSecurities);
	}
	
	//delete
	@Test
	public void deleteTest(){

		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		
	    Mockito.when(adminSecurityRepository.findById(adminSecurity.getUsername())).thenReturn(Optional.of(adminSecurity));
	    Mockito.when(adminSecurityRepository.existsById(adminSecurity.getUsername())).thenReturn(false);
	   
	    assertFalse(adminSecurityRepository.existsById(adminSecurity.getUsername()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		
	    Mockito.when(adminSecurityRepository.findById(adminSecurity.getUsername())).thenReturn(Optional.of(adminSecurity));
		
		adminSecurity.setSecurityQuestion("what is your favorite colour?");
		adminSecurity.setAnswer("red");
		
		Mockito.when(adminSecurityRepository.save(adminSecurity)).thenReturn(adminSecurity);
		
		assertThat(adminSecurityServiceImplementation.update(adminSecurity)).isEqualTo(adminSecurity);
		
	}
	
}
