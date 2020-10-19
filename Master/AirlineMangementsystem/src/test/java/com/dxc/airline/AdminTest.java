package com.dxc.airline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.Admin;
import com.dxc.airline.repository.AdminRepository;
import com.dxc.airline.service.AdminServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
	
	@Autowired
	AdminServiceImplementation adminServiceImplementation;
	
	@MockBean
	AdminRepository adminRepository;
	
	@Test
	public void AdminfindAllTest() {
		when(adminRepository.findAll()).thenReturn(
				Stream.of(new Admin("pasupathi@dxc.com", "pasupathi"), new Admin("p@dxc.com", "pasupathi"))
						.collect(Collectors.toList()));
		assertEquals(2, adminServiceImplementation.findAll().size());
	}

	@Test
	public void AdminfindByUsernameTest() {
		
		Admin admin = new Admin("p@dxc.com", "ppp");
		when(adminRepository.findById("p@dxc.com")).thenReturn(Optional.of(admin));
		assertEquals(admin, adminServiceImplementation.findById(admin.getUsername()));
	}

	@Test
	public void saveAdminTest() {
		Admin admin = new Admin("aaa@dxc.com", "aaa");
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals(admin, adminServiceImplementation.save(admin));
	}

	@Test
	public void deleteAdminTest() {
		String username = "aaa@dxc.com";
		adminServiceImplementation.deleteById(username);
		verify(adminRepository, times(1)).deleteById(username);
	}


}
