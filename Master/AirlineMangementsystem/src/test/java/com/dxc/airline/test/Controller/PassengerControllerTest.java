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

import com.dxc.airline.controller.PassengerController;
import com.dxc.airline.model.Passenger;
import com.dxc.airline.service.PassengerServiceImplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=PassengerController.class)
public class PassengerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PassengerServiceImplementation passengerServiceImplementation;
	
	@Test
	public void saveTest() throws Exception {
		
		Passenger passenger = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		
		String inputInJson = this.mapToJson(passenger);
		
		String URI = "/passenger/add";
	
		Mockito.when(passengerServiceImplementation.save(Mockito.any(Passenger.class))).thenReturn(passenger);
		
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
	public void findByUserNameTest() throws Exception {
		
		Passenger passenger1 = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		Passenger passenger2 = new Passenger(1001,"anil@gmail.com", "anil kumar", "male", 22,11111, 101);
		
		List<Passenger> passengers = new ArrayList<>();
		passengers.add(passenger1);
		passengers.add(passenger2);
		
		Mockito.when(passengerServiceImplementation.findByUserName("pasupathi@gmail.com")).thenReturn(passengers);
		
		String URI = "/passenger/pasupathi@gmail.com";

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(passengers);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void findByUserTest() throws Exception {
		
		Passenger passenger1 = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		Passenger passenger2 = new Passenger(1001,"anil@gmail.com", "anil kumar", "male", 22,11111, 101);
		
		List<Passenger> passengers = new ArrayList<>();
		passengers.add(passenger1);
		passengers.add(passenger2);
		
		Mockito.when(passengerServiceImplementation.findByUser("pasupathi@gmail.com",101)).thenReturn(passengers);
		
		String URI = "/passenger/pasupathi@gmail.com/101";

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(passengers);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void findAll() throws Exception {

		Passenger passenger1 = new Passenger(1001,"pasupathi@gmail.com", "pasupathi", "male", 22,11110, 101);
		Passenger passenger2 = new Passenger(1001,"anil@gmail.com", "anil kumar", "male", 22,11111, 101);
		
		List<Passenger> passengers = new ArrayList<>();
		passengers.add(passenger1);
		passengers.add(passenger2);
		
		Mockito.when(passengerServiceImplementation.findAll()).thenReturn(passengers);
		
		String URI = "/passenger";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(passengers);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	/**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
