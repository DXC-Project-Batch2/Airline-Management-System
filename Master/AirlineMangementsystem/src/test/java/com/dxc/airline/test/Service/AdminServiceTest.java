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

import com.dxc.airline.model.Admin;
import com.dxc.airline.repository.AdminRepository;
import com.dxc.airline.service.AdminServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

	@Autowired
	private AdminServiceImplementation adminServiceImplementation;
	
	@MockBean
	private AdminRepository adminRepository;
	
	//save
	@Test
	public void saveTest(){

		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");
		
	    Mockito.when(adminRepository.save(admin)).thenReturn(admin);
	    
	    assertThat(adminServiceImplementation.save(admin)).isEqualTo(admin);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");		
	    Mockito.when(adminRepository.findById(admin.getUsername())).thenReturn(Optional.of(admin));
	    assertThat(adminServiceImplementation.findById(admin.getUsername())).isEqualTo(admin);
	}
	
	//findAll
	@Test
	public void findallTest(){

		Admin admin1 = new Admin("pasupathi@dxc.com", "pasupathi");		
		
		Admin admin2 = new Admin("krishna@dxc.com", "krishna");		
		
		List<Admin> admins = new ArrayList<>();
		admins.add(admin1);
		admins.add(admin2);
		
		Mockito.when(adminRepository.findAll()).thenReturn(admins);
		
		assertThat(adminServiceImplementation.findAll()).isEqualTo(admins);
	}
	
	//delete
	@Test
	public void deleteTest(){

		Admin admin = new Admin("krishna@dxc.com", "krishna");
		
	    Mockito.when(adminRepository.findById(admin.getUsername())).thenReturn(Optional.of(admin));
	    Mockito.when(adminRepository.existsById(admin.getUsername())).thenReturn(false);
	   
	    assertFalse(adminRepository.existsById(admin.getUsername()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		Admin admin = new Admin("krishna@dxc.com", "krishna");
		
	    Mockito.when(adminRepository.findById(admin.getUsername())).thenReturn(Optional.of(admin));
		
		admin.setPassword("krishna9897");
		
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		
		assertThat(adminServiceImplementation.update(admin)).isEqualTo(admin);
		
	}
	
}
