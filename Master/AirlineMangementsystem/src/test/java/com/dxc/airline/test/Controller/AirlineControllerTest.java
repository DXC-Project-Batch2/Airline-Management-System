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

import com.dxc.airline.controller.AirlineController;
import com.dxc.airline.model.AirLine;
import com.dxc.airline.service.AirlineServiceImplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=AirlineController.class)

public class AirlineControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AirlineServiceImplementation airlineServiceImplementation;
	
	@Test
	public void findbyUsernameTest() throws Exception {
		
		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-2022", "150mins", "2:00", "4:30", 10000, 44,3);
		
		Mockito.when(airlineServiceImplementation.findById(airLine.getPlaneId())).thenReturn(airLine);
		
		String URI = "/airline/110";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(airLine);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void findAll() throws Exception {

		AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
		AirLine airLine2 = new AirLine(111, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
		List<AirLine> airLines = new ArrayList<>();
		airLines.add(airLine1);
		airLines.add(airLine2);
		
		Mockito.when(airlineServiceImplementation.findAll()).thenReturn(airLines);
		
		String URI = "/airline";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(airLines);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void saveTest() throws Exception {
		
		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
		
		String inputInJson = this.mapToJson(airLine);
		
		String URI = "/airline/add";
		
		Mockito.when(airlineServiceImplementation.save(Mockito.any(AirLine.class))).thenReturn(airLine);
		
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
		
		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
		
		String inputInJson = this.mapToJson(airLine);
		
		String URI = "/airline/update";
		
		Mockito.when(airlineServiceImplementation.update(Mockito.any(AirLine.class))).thenReturn(airLine);
		
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
//		String URI = "/airlineDelete/110";
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
