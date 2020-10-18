package com.dxc.airline;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.City;
import com.dxc.airline.repository.CityRepository;
import com.dxc.airline.service.CityServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CityTest {


		@Autowired
		CityServiceImplementation cityServiceImplementation;

		@MockBean
		CityRepository cityRepository;

	
		@Test
		public void cityfindAllTest() {
			when(cityRepository.findAll())
					.thenReturn(Stream.of(new City("Kolkata"), new City("Goa")).collect(Collectors.toList()));
			assertEquals(2, cityServiceImplementation.findAll().size());
		}
	
		@Test
		public void cityfindBycityTest() {
			City city = new City("chennai");
			when(cityRepository.findById("chennai")).thenReturn(Optional.of(city));
			assertEquals(city, cityServiceImplementation.findBycity(city.getCity()));
		}
	
		@Test
		public void saveCityTest() {
			City city = new City("Madras");
			when(cityRepository.save(city)).thenReturn(city);
			assertEquals(city, cityServiceImplementation.save(city));
		}
	
		@Test
		public void deleteCityTest() {
			String city = "Madras";
			cityServiceImplementation.delete(city);
			verify(cityRepository, times(1)).deleteById(city);
		}
	

}
