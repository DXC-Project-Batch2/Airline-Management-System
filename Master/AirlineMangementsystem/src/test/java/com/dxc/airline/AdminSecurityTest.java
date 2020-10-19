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

import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.repository.AdminSecurityRepository;
import com.dxc.airline.service.AdminSecurityServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminSecurityTest {
	
	@Autowired
	AdminSecurityServiceImplementation adminSecurityServiceImplementation;

	@MockBean
	AdminSecurityRepository adminSecurityRepository;
	
	@Test
	public void AdminSecurityfindAllTest() {
		when(adminSecurityServiceImplementation.findAll()).thenReturn(Stream
				.of(new AdminSecurity("pasupathi@gmail.com", "what is favorite number?", "100"),
						new AdminSecurity("p@gmail.com", "what is favorite number?", "100"))
				.collect(Collectors.toList()));
		assertEquals(2, adminSecurityServiceImplementation.findAll().size());
	}

	@Test
	public void AdminSecurityfindByUsernameTest() {
		
		AdminSecurity adminSecurity = new AdminSecurity("p@dxc.com", "what is favorite number?", "100");
		when(adminSecurityRepository.findById("p@dxc.com")).thenReturn(Optional.of(adminSecurity));
		assertEquals(adminSecurity, adminSecurityServiceImplementation.findByid(adminSecurity.getUsername()));
		
	}

	@Test
	public void saveAdminSecurityTest() {
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@gmail.com", "what is favorite number?", "100");
		when(adminSecurityRepository.save(adminSecurity)).thenReturn(adminSecurity);
		assertEquals(adminSecurity, adminSecurityServiceImplementation.save(adminSecurity));
	}

	@Test
	public void deleteAdminSecurityTest() {
		String username = "aaa@gmail.com";
		adminSecurityServiceImplementation.delete(username);
		verify(adminSecurityRepository, times(1)).deleteById(username);
	}


}
