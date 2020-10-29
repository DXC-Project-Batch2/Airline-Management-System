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

import com.dxc.airline.controller.UserSecurityController;
import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.service.UserSecurityServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserSecurityController.class)

public class UserSecurityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserSecurityServiceImp userSecurityServiceImp;
	
	@Test
	public void findbyUsernameTest() throws Exception {
		
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		
		Mockito.when(userSecurityServiceImp.findByUsername(userSecurity.getUsername())).thenReturn(userSecurity);
		
		String URI = "/usersecurity/pasupathi@gmail.com";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(userSecurity);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void findAll() throws Exception {

		UserSecurity userSecurity1 = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		
		UserSecurity userSecurity2 = new UserSecurity("anil@gmail.com", "what is your favorite colour?","red");
		
		List<UserSecurity> userSecurities = new ArrayList<>();
		userSecurities.add(userSecurity1);
		userSecurities.add(userSecurity2);
		
		Mockito.when(userSecurityServiceImp.findAll()).thenReturn(userSecurities);
		
		String URI = "/usersecurity";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(userSecurities);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void saveTest() throws Exception {
		
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
		
		String inputInJson = this.mapToJson(userSecurity);
		
		String URI = "/usersecurity";
		
		Mockito.when(userSecurityServiceImp.add(Mockito.any(UserSecurity.class))).thenReturn(userSecurity);
		
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
		
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is your favorite number?","96");
			
		String inputInJson = this.mapToJson(userSecurity);
		
		String URI = "/usersecurity";
		
		Mockito.when(userSecurityServiceImp.update(Mockito.any(UserSecurity.class))).thenReturn(userSecurity);
		
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
