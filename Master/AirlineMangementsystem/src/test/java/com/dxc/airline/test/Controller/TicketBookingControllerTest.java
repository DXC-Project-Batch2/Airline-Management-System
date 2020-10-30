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

import com.dxc.airline.controller.TicketBookingController;
import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.service.TicketBookingServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=TicketBookingController.class)
public class TicketBookingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TicketBookingServiceImp ticketBookingServiceImp;
	
	@Test
	public void findbyUsernameTest() throws Exception {
		
		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 10);		
	
		Mockito.when(ticketBookingServiceImp.findById(ticketBooking.getTicketId())).thenReturn(ticketBooking);
		
		String URI = "/TicketBooking/0";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(ticketBooking);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void findAll() throws Exception {

		TicketBooking ticketBooking1 = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 8);		
		TicketBooking ticketBooking2 = new TicketBooking(102, "rama@gmail.com",102,"chennai", "hyderabad", "29-10-2020", 4);
	
		List<TicketBooking> ticketBookings = new ArrayList<>();
		ticketBookings.add(ticketBooking1);
		ticketBookings.add(ticketBooking2);
		
		Mockito.when(ticketBookingServiceImp.getAll()).thenReturn(ticketBookings);
		
		String URI = "/TicketBookings";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(ticketBookings);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void saveTest() throws Exception {
		
		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 10);		

		String inputInJson = this.mapToJson(ticketBooking);
		
		String URI = "/TicketBooking";
		
		Mockito.when(ticketBookingServiceImp.add(Mockito.any(TicketBooking.class))).thenReturn(ticketBooking);
		
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
		
		TicketBooking ticketBooking = new TicketBooking(101, "pasupathi@gmail.com", 101,"chennai", "hyderabad", "29-10-2020", 10);		

		String inputInJson = this.mapToJson(ticketBooking);
		
		String URI = "/TicketBooking";
		
		Mockito.when(ticketBookingServiceImp.update(Mockito.any(TicketBooking.class))).thenReturn(ticketBooking);
		
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
