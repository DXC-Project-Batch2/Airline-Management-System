package com.dxc.airline.test.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.dxc.airline.controller.RegistrationController;
import com.dxc.airline.model.Admin;
import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.model.AdminSecurity;
import com.dxc.airline.model.Registration;
import com.dxc.airline.model.User;
import com.dxc.airline.model.UserInfo;
import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.service.AdminInfoServiceImplementation;
import com.dxc.airline.service.AdminSecurityServiceImplementation;
import com.dxc.airline.service.AdminServiceImplementation;
import com.dxc.airline.service.UserInfoServiceImplementation;
import com.dxc.airline.service.UserSecurityServiceImp;
import com.dxc.airline.service.UserServiceImplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=RegistrationController.class)
public class RegistrationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminServiceImplementation adminServiceImplementation;
	
	@MockBean
	private AdminInfoServiceImplementation adminInfoServiceImplementation;
	
	@MockBean
	private AdminSecurityServiceImplementation adminSecurityServiceImplementation;
	
	@MockBean
	private UserServiceImplementation userServiceImplementation;
	
	@MockBean
	private UserInfoServiceImplementation userInfoServiceImplementation;
	
	@MockBean
	private UserSecurityServiceImp userSecurityServiceImp;
	
	User user;
	UserInfo userinfo;
	UserSecurity userSecurity;
	Admin admin;
	AdminInfo adminInfo;
	AdminSecurity adminSecurity;

	
	@Test
	public void findbyUsernameTest() throws Exception {
		
		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");
		
		Mockito.when(adminServiceImplementation.findById(admin.getUsername())).thenReturn(admin);
		
		String URI = "/Admin/pasupathi@dxc.com";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(admin);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void findAll() throws Exception {

		Admin admin1 = new Admin("pasupathi@dxc.com", "pasupathi");		
		
		Admin admin2 = new Admin("krishna@dxc.com", "krishna");		
		
		List<Admin> admins = new ArrayList<>();
		admins.add(admin1);
		admins.add(admin2);
		
		Mockito.when(adminServiceImplementation.findAll()).thenReturn(admins);
		
		String URI = "/Admin";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(admins);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void saveTest() throws Exception {
		
		Registration e = new Registration("pasupathi@dxc.com", "pasupathi", "pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "what is your favorite number?","96");		
	
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
         String strDate = dateFormat.format(e.getDob());
         String strExpiry=dateFormat.format(e.getExpiry());
		
		 admin = new Admin(e.getUsername(), e.getPassword());
		 user = new User(e.getUsername(), e.getPassword());
			
		 adminInfo = new AdminInfo(e.getName(), e.getLastname(), e.getGender(), strDate, e.getFathername(), e.getPassportname(), e.getPassportnumber(), strExpiry, e.getDoorNumber(), e.getStreet(), e.getArea(), e.getCountry(), e.getState(), e.getCity(), e.getPostalCode(), e.getLandMark(), e.getMobile(), e.getUsername());
		 userinfo = new UserInfo(e.getName(), e.getLastname(), e.getGender(), strDate, e.getFathername(), e.getPassportname(), e.getPassportnumber(), strExpiry, e.getDoorNumber(), e.getStreet(), e.getArea(), e.getCountry(), e.getState(), e.getCity(), e.getPostalCode(), e.getLandMark(), e.getMobile(), e.getUsername());
			
		 adminSecurity = new AdminSecurity(e.getUsername(), e.getSecurityQuestion(), e.getAnswer());
		 userSecurity = new UserSecurity(e.getUsername(), e.getSecurityQuestion(), e.getAnswer());
			
		
		String inputInJson = this.mapToJson(admin);
		
		String URI = "/Registration";
		
		Mockito.when(adminServiceImplementation.save(Mockito.any(Admin.class))).thenReturn(admin);
		
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
		
		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");
		
		String inputInJson = this.mapToJson(admin);
		
		String URI = "/Admin";
		
		Mockito.when(adminServiceImplementation.update(Mockito.any(Admin.class))).thenReturn(admin);
		
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

	
	@Test
	public void adminLoginTest() throws Exception {
		
		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");
		
		Mockito.when(adminServiceImplementation.findByUsernameAndPassword("pasupathi@dxc.com", "pasupathi")).thenReturn(admin);
		
		String inputInJson = this.mapToJson(admin);
		
		String URI = "/adminLogin";
		
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

//	@Test
//	public void invalidusername_or_passwordTest() throws Exception {
//		
//		Admin admin = new Admin("pasupathi@dxc.com", "pasupathi");
//		
//		Mockito.when(adminServiceImplementation.findByUsernameAndPassword("pasupathi@dxc.com", "pasupathi143")).thenReturn(admin);
//		
//		String inputInJson = this.mapToJson(admin);
//		
//		String URI = "/adminLogin";
//		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post(URI)
//				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
//				.contentType(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//		
//		String outputInJson = response.getContentAsString();
//		
//		assertThat(outputInJson).isNotEqualTo(inputInJson);
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
