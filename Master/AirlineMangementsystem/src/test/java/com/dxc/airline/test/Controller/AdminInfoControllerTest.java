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

import com.dxc.airline.controller.AdminInfoController;
import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.service.AdminInfoServiceImplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=AdminInfoController.class)
public class AdminInfoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminInfoServiceImplementation adminInfoServiceImplementation;
	
	@Test
	public void findbyUsernameTest() throws Exception{
		
				AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "", "9003299897", "pasupathi@dxc.com");
				Mockito.when(adminInfoServiceImplementation.findByUsername(adminInfo.getUsername())).thenReturn(adminInfo);
				
				String URI = "/admininfo/pasupathi@dxc.com";
				
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
						URI).accept(
						MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();
				String expectedJson = this.mapToJson(adminInfo);
				String outputInJson = result.getResponse().getContentAsString();
				assertThat(outputInJson).isEqualTo(expectedJson);
							
	}

	@Test
	public void findAll() throws Exception {

			AdminInfo adminInfo1 = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");
			AdminInfo adminInfo2 = new AdminInfo("anil", "kumar", "male", "18-07-1999", "bhadra", "Anil Kumar", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "anil@dxc.com");	
			
			List<AdminInfo> adminInfos = new ArrayList<>();
			adminInfos.add(adminInfo1);
			adminInfos.add(adminInfo2);
			
			Mockito.when(adminInfoServiceImplementation.findAll()).thenReturn(adminInfos);
			
			String URI = "/admininfo";
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					URI).accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			String expectedJson = this.mapToJson(adminInfos);
			String outputInJson = result.getResponse().getContentAsString();
			assertThat(outputInJson).isEqualTo(expectedJson);
		}

	@Test
	public void saveTest() throws Exception {
		
			AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
		
			String inputInJson = this.mapToJson(adminInfo);
			
			String URI = "/admininfo";
			
			Mockito.when(adminInfoServiceImplementation.save(Mockito.any(AdminInfo.class))).thenReturn(adminInfo);
			
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
		
		AdminInfo adminInfo = new AdminInfo("pasupathi", "aduri", "male", "18-07-1999", "bhadra", "Pasupathi Nadh", 12345678, "22-09-2099", "3-44", "saliepeta", "saliepeta", "india", "andhra pradesh", "tadepalligudem", 534101, "null", "9003299897", "pasupathi@dxc.com");	
			
		String inputInJson = this.mapToJson(adminInfo);
		
		String URI = "/admininfo";
		
		Mockito.when(adminInfoServiceImplementation.update(Mockito.any(AdminInfo.class))).thenReturn(adminInfo);
		
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
