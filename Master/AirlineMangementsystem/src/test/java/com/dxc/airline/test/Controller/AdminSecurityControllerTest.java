package com.dxc.airline.test.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dxc.airline.controller.AdminSecurityController;
import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.service.AdminSecurityServiceImplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=AdminSecurityController.class)

public class AdminSecurityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminSecurityServiceImplementation adminSecurityServiceImplementation;
	
	@Test
	public void findbyUsernameTest() throws Exception {
		
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		
		Mockito.when(adminSecurityServiceImplementation.findByid(adminSecurity.getUsername())).thenReturn(adminSecurity);
		
		String URI = "/AdminSecurity/pasupathi@dxc.com";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(adminSecurity);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void findAll() throws Exception {

		AdminSecurity adminSecurity1 = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		
		AdminSecurity adminSecurity2 = new AdminSecurity("anil@dxc.com", "what is your favorite colour?","red");
		
		List<AdminSecurity> adminSecurities = new ArrayList<>();
		adminSecurities.add(adminSecurity1);
		adminSecurities.add(adminSecurity2);
		
		Mockito.when(adminSecurityServiceImplementation.findAll()).thenReturn(adminSecurities);
		
		String URI = "/AdminSecurity";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(adminSecurities);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void saveTest() throws Exception {
		
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
		
		String inputInJson = this.mapToJson(adminSecurity);
		
		String URI = "/AdminSecurity";
		
		Mockito.when(adminSecurityServiceImplementation.save(Mockito.any(AdminSecurity.class))).thenReturn(adminSecurity);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void updateTest() throws Exception {
		
		AdminSecurity adminSecurity = new AdminSecurity("pasupathi@dxc.com", "what is your favorite number?","96");
			
		String inputInJson = this.mapToJson(adminSecurity);
		
		String URI = "/AdminSecurity";
		
		Mockito.when(adminSecurityServiceImplementation.update(Mockito.any(AdminSecurity.class))).thenReturn(adminSecurity);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

//	@Test
//	public void deleteTest() throws Exception {
//		
//		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");
//		
//		String inputInJson = this.mapToJson(admin);
//		
//		String URI = "/Admin/pasupathi@dxc.com";
//			
//		Mockito.when(adminServiceImplementation.deleteById(admin.getUsername())).thenReturn(admin);
//		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.delete(URI)
//				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
//				.contentType(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//		
//		String outputInJson = response.getContentAsString();
//		
//		assertThat(outputInJson).isEqualTo(inputInJson);
//		assertEquals(HttpStatus.OK.value(), response.getStatus());
//	}

	

	/**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
