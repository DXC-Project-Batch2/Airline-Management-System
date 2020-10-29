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

import com.dxc.airline.controller.CityController;
import com.dxc.airline.model.City;
import com.dxc.airline.service.CityServiceImplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=CityController.class)
public class CityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CityServiceImplementation cityServiceImplementation;
	
	@Test
	public void findbyUsernameTest() throws Exception {
		
		City city = new City("Kolkata");
				
		Mockito.when(cityServiceImplementation.findBycity(city.getCity())).thenReturn(city);
		
		String URI = "/city/Kolkata";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(city);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void findAll() throws Exception {

		City city1 = new City("Kolkata");
			
		City city2 = new City("hyderabad");
		
		List<City> cities = new ArrayList<>();
		cities.add(city1);
		cities.add(city2);
		
		Mockito.when(cityServiceImplementation.findAll()).thenReturn(cities);
		
		String URI = "/cities";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(cities);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void saveTest() throws Exception {
		
		City city = new City("Kolkata");
			
		String inputInJson = this.mapToJson(city);
		
		String URI = "/city";
		
		Mockito.when(cityServiceImplementation.save(Mockito.any(City.class))).thenReturn(city);
		
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
		
		City city = new City("Kolkata");
			
		String inputInJson = this.mapToJson(city);
		
		String URI = "/city";
		
		Mockito.when(cityServiceImplementation.update(Mockito.any(City.class))).thenReturn(city);
			
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
