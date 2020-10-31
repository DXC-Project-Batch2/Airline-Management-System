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

		Admin admin = new Admin("pasupathi@dxc.com", "%Pasupathi123");
		
	    Mockito.when(adminRepository.save(admin)).thenReturn(admin);
	    
	    assertThat(adminServiceImplementation.save(admin)).isEqualTo(admin);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		Admin admin = new Admin("pasupathi@dxc.com", "@Pasupathi999");		
	    Mockito.when(adminRepository.findById(admin.getUsername())).thenReturn(Optional.of(admin));
	    assertThat(adminServiceImplementation.findById(admin.getUsername())).isEqualTo(admin);
	}
	
	//findByUsernameAndPassword
	@Test
	public void findByUsernameAndPasswordTest(){
			
		Admin admin = new Admin("pasupathi@dxc.com", "Pa#$supathi123");
		    Mockito.when(adminRepository.findByUsernameAndPassword("pasupathi@dxc.com", "pasupathi")).thenReturn(admin);
		    assertThat(adminServiceImplementation.findByUsernameAndPassword("pasupathi@dxc.com", "pasupathi")).isEqualTo(admin);
	
	}
	
	//findAll
	@Test
	public void findallTest(){

		Admin admin1 = new Admin("pasupathi@dxc.com", "Pasu#$45pathi");		
		
		Admin admin2 = new Admin("krishna@dxc.com", "Krishn@#$11a");		
		
		List<Admin> admins = new ArrayList<>();
		admins.add(admin1);
		admins.add(admin2);
		
		Mockito.when(adminRepository.findAll()).thenReturn(admins);
		
		assertThat(adminServiceImplementation.findAll()).isEqualTo(admins);
	}
	
	//delete
	@Test
	public void deleteTest(){

		Admin admin = new Admin("krishna@dxc.com", "Krish234#$na");
		
	    Mockito.when(adminRepository.findById(admin.getUsername())).thenReturn(Optional.of(admin));
	    Mockito.when(adminRepository.existsById(admin.getUsername())).thenReturn(false);
	   
	    assertFalse(adminRepository.existsById(admin.getUsername()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		Admin admin = new Admin("krishna@dxc.com", "kriS34%$hna");
		
	    Mockito.when(adminRepository.findById(admin.getUsername())).thenReturn(Optional.of(admin));
		
		admin.setPassword("Krishna@9897");
		
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		
		assertThat(adminServiceImplementation.update(admin)).isEqualTo(admin);
		
	}
	
	//negative cases
	
		@Test
		public void NotsaveadminInfoTest() throws ParseException{
			
			Admin admin = null;
			
			Mockito.when(adminRepository.save(admin)).thenReturn(admin);
	    
			assertThat(adminServiceImplementation.save(admin)).isEqualTo(admin);
			}
		
		@Test
		public void adminInfofindByUsername_NoFoundTest() throws ParseException{
			Admin admin = new Admin("krishna@dxc.com", "Krishna123@");
		    Mockito.when(adminRepository.findById("anil@dxc.com")).thenReturn(Optional.of(admin));
		    assertThat(adminServiceImplementation.findById("anil@dxc.com")).isEqualTo(admin);
		}

		@Test
		public void NotupdateTest() throws ParseException{
			
			Admin admin = new Admin("krishna@dxc.com", "Krishna!@#1");
							
			Mockito.when(adminRepository.findById("anil@dxc.com")).thenReturn(Optional.of(admin));
			
			admin.setPassword("Pasupathi123@");
			
			Mockito.when(adminRepository.save(admin)).thenReturn(admin);
			
			assertThat(adminServiceImplementation.update(admin)).isNotEqualTo(admin);
			
		}
		
		@Test
		public void NotfindByUsernameAndPasswordTest(){
				
			Admin admin = new Admin("pasupathi@dxc.com", "pasuP@#31athi");		
			Mockito.when(adminRepository.findByUsernameAndPassword("pasupathi@dxc.com", "ppppp")).thenReturn(admin);
			assertThat(adminServiceImplementation.findByUsernameAndPassword("pasupathi@dxc.com", "pasupathi")).isNotEqualTo(admin);
		
		}

}
