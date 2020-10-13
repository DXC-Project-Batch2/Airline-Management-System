package com.dxc.admin;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.dxc.airline.model.Admin;
import com.dxc.airline.repository.AdminRepository;
import com.dxc.airline.service.AdminService;



@SpringBootTest
public class AdminManagementSystemApplicationTests {
	
	@Autowired
	private AdminService service;
	
	@MockBean
	private AdminRepository repository;
	
	@Test
	public void findAllUsersTest() {
		
		
		when(repository.findAll()).thenReturn(Stream
				.of(new Admin("Danile", "USA123"), new Admin("Huy","UK123")).collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
	}

}
