package com.dxc.airline.test.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.City;
import com.dxc.airline.repository.CityRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CityRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	CityRepository cityRepository;
	
	//save
	@Test
	public void testSaveCity(){

		City city = new City("Kolkata");
		City savedInDb = entityManager.persist(city);
		City getFromDatabase = cityRepository.getOne(savedInDb.getCity());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetCityById(){
	
		City city = new City("Kolkata");
		//Save city in DB
		City citySavedInDb = entityManager.persist(city);
		
		//Get city from DB
		Optional<City> cityFromInDb = cityRepository.findById(city.getCity());
		assertThat(citySavedInDb).isEqualTo(cityFromInDb.get());
	}
	
	//findAll
	@Test
	public void testGetAllCity(){
		
		City city1 = new City("Kolkata");
		City city2 = new City("goa");
		City city3 = new City("chennai");
		//Save both city in DB
		entityManager.persist(city1);
		entityManager.persist(city2);
		entityManager.persist(city3);
		
		
		List<City> cities = cityRepository.findAll();
		assertThat(cities.size()).isEqualTo(3);
	}
	
	//delete
	@Test
	public void testDeleteBycity() {
	
		City city = new City("Kolkata");
		//Save city in DB
		entityManager.persist(city);
		
		//delete one city DB
		entityManager.remove(city);
		
		List<City> cities = cityRepository.findAll();
		assertThat(cities.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateCity(){
		
		City city = new City("Kolkata");
		//save city info in DB
		entityManager.persist(city);
		
		City getFromDb = cityRepository.findById(city.getCity()).get();

		getFromDb.setCity("chennai");
		
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getCity()).isEqualTo("chennai");
	}
	
}
