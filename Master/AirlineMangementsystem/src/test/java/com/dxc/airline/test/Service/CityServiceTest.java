package com.dxc.airline.test.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.City;
import com.dxc.airline.repository.CityRepository;
import com.dxc.airline.service.CityServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

	@Autowired
	private CityServiceImplementation cityServiceImplementation;
	
	@MockBean
	private CityRepository cityRepository;
	
	//save
	@Test
	public void saveTest(){

		City city = new City("Kolkata");
		
	    Mockito.when(cityRepository.save(city)).thenReturn(city);
	    
	    assertThat(cityServiceImplementation.save(city)).isEqualTo(city);
	
	}
	
	
	//findbyId
	@Test
	public void findByIdTest(){
		
		City city = new City("Kolkata");
		Mockito.when(cityRepository.findById(city.getCity())).thenReturn(Optional.of(city));
	    assertThat(cityServiceImplementation.findBycity(city.getCity())).isEqualTo(city);
	}
	
	//findAll
	@Test
	public void findallTest(){

		City city1 = new City("Kolkata");
		City city2 = new City("goa");
		City city3 = new City("chennai");
		
		List<City> cities = new ArrayList<>();
		cities.add(city1);
		cities.add(city2);
		cities.add(city3);
		
		Mockito.when(cityRepository.findAll()).thenReturn(cities);
		
		assertThat(cityServiceImplementation.findAll()).isEqualTo(cities);
	}
	
	//delete
	@Test
	public void deleteTest(){

		City city = new City("Kolkata");
		
	    Mockito.when(cityRepository.findById(city.getCity())).thenReturn(Optional.of(city));
	    Mockito.when(cityRepository.existsById(city.getCity())).thenReturn(false);
	   
	    assertFalse(cityRepository.existsById(city.getCity()));
	}
	
	//update
	@Test
	public void updateTest(){
		
		City city = new City("Kolkata");
		
	    Mockito.when(cityRepository.findById(city.getCity())).thenReturn(Optional.of(city));
		
		city.setCity("Chennai");

		Mockito.when(cityRepository.save(city)).thenReturn(city);
		
		assertThat(cityServiceImplementation.save(city)).isEqualTo(city);
		
	}

	//negative cases
	
	//Notsave
	@Test
	public void NotsaveTest(){

		City city = null;
		
	    Mockito.when(cityRepository.save(city)).thenReturn(city);
	    
	    assertThat(cityServiceImplementation.save(city)).isEqualTo(city);
	
	}
	
	
	//NotfindbyId
	@Test
	public void NotfindByIdTest(){
		
		City city = new City("Kolkata");
		Mockito.when(cityRepository.findById("chennai")).thenReturn(Optional.of(city));
	    assertThat(cityServiceImplementation.findBycity("chennai")).isEqualTo(city);
	}
	
	//NotfindAll
	@Test
	public void NotfindallTest(){

		City city1 = null;
		City city2 = null;
		City city3 = null;
		
		List<City> cities = new ArrayList<>();
		cities.add(city1);
		cities.add(city2);
		cities.add(city3);
		
		Mockito.when(cityRepository.findAll()).thenReturn(cities);
		
		assertThat(cityServiceImplementation.findAll()).isEqualTo(cities);
	}
		
	//Notupdate
	@Test
	public void NotupdateTest(){
		
		City city = new City("Kolkata");
		
	    Mockito.when(cityRepository.findById("goa")).thenReturn(Optional.of(city));
		
		city.setCity("Chennai");

		Mockito.when(cityRepository.save(city)).thenReturn(city);
		
		assertThat(cityServiceImplementation.update(city)).isNotEqualTo(city);
		
	}

}
