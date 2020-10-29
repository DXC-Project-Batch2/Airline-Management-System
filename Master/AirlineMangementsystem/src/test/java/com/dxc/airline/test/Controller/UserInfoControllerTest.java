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

import com.dxc.airline.controller.UserInfoController;
import com.dxc.airline.model.UserInfo;
import com.dxc.airline.service.UserInfoServiceImplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserInfoController.class)
public class UserInfoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserInfoServiceImplementation userInfoServiceImplementation;
	
	@Test
	public void findbyUsernameTest() throws Exception{
		
				UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");
				Mockito.when(userInfoServiceImplementation.findByUsername(userInfo.getUsername())).thenReturn(userInfo);
				
				String URI = "/userinfo/pasupathi@gmail.com";
				
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
						URI).accept(
						MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();
				String expectedJson = this.mapToJson(userInfo);
				String outputInJson = result.getResponse().getContentAsString();
				assertThat(outputInJson).isEqualTo(expectedJson);
							
	}

	@Test
	public void findAll() throws Exception {

		UserInfo userInfo1 = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");
		UserInfo userInfo2 = new UserInfo("anil", "kumar", "male", "18-07-1999", "bhadra", "Anil Kumar", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "anil@gmail.com");	
			
			List<UserInfo> userInfos = new ArrayList<>();
			userInfos.add(userInfo1);
			userInfos.add(userInfo2);
			
			Mockito.when(userInfoServiceImplementation.findAll()).thenReturn(userInfos);
			
			String URI = "/userinfo";
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					URI).accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			String expectedJson = this.mapToJson(userInfos);
			String outputInJson = result.getResponse().getContentAsString();
			assertThat(outputInJson).isEqualTo(expectedJson);
		}

	@Test
	public void saveTest() throws Exception {
		
			UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");
		
			String inputInJson = this.mapToJson(userInfo);
			
			String URI = "/userinfo";
			
			Mockito.when(userInfoServiceImplementation.save(Mockito.any(UserInfo.class))).thenReturn(userInfo);
			
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
		
		UserInfo userInfo = new UserInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@gmail.com");
				
		String inputInJson = this.mapToJson(userInfo);
		
		String URI = "/userinfo";
		
		Mockito.when(userInfoServiceImplementation.update(Mockito.any(UserInfo.class))).thenReturn(userInfo);
		
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
