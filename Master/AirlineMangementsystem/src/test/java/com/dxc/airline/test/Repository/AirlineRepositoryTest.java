package com.dxc.airline.test.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.AirLine;
import com.dxc.airline.repository.AirLineRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AirlineRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	AirLineRepository airLineRepository;
	
	//save
	@Test
	public void testSaveAirLine() throws ParseException{
		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
		AirLine savedInDb = entityManager.persist(airLine);
		AirLine getFromDatabase = airLineRepository.getOne(savedInDb.getPlaneId());
		
		assertThat(getFromDatabase).isEqualTo(savedInDb);
	}
	
	//findbyid
	@Test
	public void testGetAirLineById() throws ParseException{
		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
		//Save airLine in DB
		AirLine airLineSavedInDb = entityManager.persist(airLine);
		
		//Get airLine from DB
		Optional<AirLine> airLineFromInDb = airLineRepository.findById(airLine.getPlaneId());
		assertThat(airLineSavedInDb).isEqualTo(airLineFromInDb.get());
	}
	
	//findbycities
		@Test
		public void FindByCities() throws ParseException{
			
			AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "22-10-2020", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
			AirLine airLine2 = new AirLine(111, "airindia","goa", "chennai", "22-10-2020", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
			AirLine airLine3 = new AirLine(112, "airindia","goa", "chennai", "23-10-2020", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
			//Save airLine in DB
			entityManager.persist(airLine1);
			entityManager.persist(airLine2);
			entityManager.persist(airLine3);
			
			//Get airLine from DB
			List<AirLine> airLines = airLineRepository.findByCities("chennai", "goa");
			assertThat(airLines.size()).isEqualTo(1);
			
			airLines = airLineRepository.findByCities("goa", "chennai");
			assertThat(airLines.size()).isEqualTo(2);

		}
	
	//findByUser
		@Test
		public void findByUser() throws ParseException{
			
			AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "22-10-2020", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
			AirLine airLine2 = new AirLine(111, "airindia","goa", "chennai", "22-10-2020", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
			AirLine airLine3 = new AirLine(112, "airindia","goa", "chennai", "23-10-2020", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
			//Save airLine in DB
			entityManager.persist(airLine1);
			entityManager.persist(airLine2);
			entityManager.persist(airLine3);
			
			//Get airLine from DB
			List<AirLine> airLines = airLineRepository.findByUser("chennai", "vijayawada", "22-10-2020");
			assertThat(airLines.size()).isEqualTo(0);
			
			airLines = airLineRepository.findByUser("chennai", "goa", "22-10-2020");
			assertThat(airLines.size()).isEqualTo(1);

		}

	//findAll
	@Test
	public void testGetAllAirLines() throws ParseException{
		
		AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
		AirLine airLine2 = new AirLine(111, "airindia","goa", "chennai", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);		
		//Save both airLine in DB
		entityManager.persist(airLine1);
		entityManager.persist(airLine2);
		
		List<AirLine> airLines = airLineRepository.findAll();
		assertThat(airLines.size()).isEqualTo(2);
	}
	
	//delete
	@Test
	public void testDeleteAirLineById() throws ParseException{
	
		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);		
		//Save airLine in DB
		entityManager.persist(airLine);
		
		//delete one airLine DB
		entityManager.remove(airLine);
		
		List<AirLine> airLines = airLineRepository.findAll();
		assertThat(airLines.size()).isEqualTo(0);
	}
	
	//update
	@Test
	public void testUpdateAirLine() throws ParseException{
		
		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);		
		//save airLine info in DB
		entityManager.persist(airLine);
		
		AirLine getFromDb = airLineRepository.findById(airLine.getPlaneId()).get();

		getFromDb.setPrize(2000);
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getPrize()).isEqualTo(2000);
	}
	
}
