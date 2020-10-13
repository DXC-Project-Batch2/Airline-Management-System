package com.dxc.airline;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.TicketBooking;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = AirlineMangementsystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketBookingTest {
	
	 @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }
     @Test
     public void testCreateBooking() {
    	 
    	 TicketBooking booking = new TicketBooking();
    	 
    	 booking.setTicketId(12345);
    	 booking.setFrom("chennai");
    	 booking.setTo("delhi");
    	 booking.setDate(12-10-2020);
    	 ResponseEntity<TicketBooking> postResponse = restTemplate.postForEntity(getRootUrl() + "/TicketBookings", booking, TicketBooking.class);
	        assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
    	 
     }

}
