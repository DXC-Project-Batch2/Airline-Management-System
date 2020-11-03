//package com.dxc.airline.test.Service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertFalse;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.dxc.airline.model.AirLine;
//import com.dxc.airline.repository.AirLineRepository;
//import com.dxc.airline.service.AirlineServiceImplementation;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AirLineServiceTest {
//
//	@Autowired
//	private AirlineServiceImplementation airlineServiceImplementation;
//	
//	@MockBean
//	private AirLineRepository airLineRepository;
//	
//	//save
//	@Test
//	public void saveTest() throws ParseException{
//
//		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
//				
//	    Mockito.when(airLineRepository.save(airLine)).thenReturn(airLine);
//	    
//	    assertThat(airlineServiceImplementation.save(airLine)).isEqualTo(airLine);
//	
//	}
//	
//	
//	//findbyId
//	@Test
//	public void findByIdTest() throws ParseException{
//		
//		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
//		Mockito.when(airLineRepository.findById(airLine.getPlaneId())).thenReturn(Optional.of(airLine));
//	    assertThat(airlineServiceImplementation.findById(airLine.getPlaneId())).isEqualTo(airLine);
//	    
//	}
//	
//	//findByCities
//	@Test
//	public void findByCitiesTest() throws ParseException{
//		
//		AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
//		AirLine airLine2 = new AirLine(111, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
//		List<AirLine> airLines = new ArrayList<>();
//		airLines.add(airLine1);
//		airLines.add(airLine2);
//		Mockito.when(airLineRepository.findByCities(airLine1.getSource(), airLine1.getDestination())).thenReturn(airLines);
//	    assertThat(airlineServiceImplementation.findByCities(airLine1.getSource(), airLine1.getDestination())).isEqualTo(airLines);
//	    
//	}
//	
//	//findByUser
//	@Test
//	public void findByUserTest() throws ParseException{
//		
//		AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
//		AirLine airLine2 = new AirLine(111, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
//		List<AirLine> airLines = new ArrayList<>();
//		airLines.add(airLine1);
//		airLines.add(airLine2);
//		Mockito.when(airLineRepository.findByUser(airLine1.getSource() , airLine1.getDestination(), "18-07-2021")).thenReturn(airLines);
//	    assertThat(airlineServiceImplementation.findByUser(airLine1.getSource() , airLine1.getDestination(), "18-07-2021")).isEqualTo(airLines);
//	    
//	}
//	
//	//findAll
//	@Test
//	public void findallTest() throws ParseException{
//
//		AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
//		
//		AirLine airLine2 = new AirLine(111, "airindia","goa", "chennai", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);		
//		
//		List<AirLine> airLines = new ArrayList<>();
//		airLines.add(airLine1);
//		airLines.add(airLine2);
//		
//		Mockito.when(airLineRepository.findAll()).thenReturn(airLines);
//		
//		assertThat(airlineServiceImplementation.findAll()).isEqualTo(airLines);
//	}
//	
//	//delete
//	@Test
//	public void deleteTest() throws ParseException{
//
//		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
//		
//	    Mockito.when(airLineRepository.findById(airLine.getPlaneId())).thenReturn(Optional.of(airLine));
//	    Mockito.when(airLineRepository.existsById(airLine.getPlaneId())).thenReturn(false);
//	   
//	    assertFalse(airLineRepository.existsById(airLine.getPlaneId()));
//	}
//	
//	//update
//	@Test
//	public void updateTest() throws ParseException{
//		
//		AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
//		
//	    Mockito.when(airLineRepository.findById(airLine.getPlaneId())).thenReturn(Optional.of(airLine));
//		
//	    airLine.setPrize(2000);
//	    
//		Mockito.when(airLineRepository.save(airLine)).thenReturn(airLine);
//		
//		assertThat(airlineServiceImplementation.update(airLine)).isEqualTo(airLine);
//		
//	}
//	
//	//negative cases
//	
//		//NotfindbyId
//		@Test
//		public void NotfindByIdTest() throws ParseException{
//			
//			AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
//			Mockito.when(airLineRepository.findById(111)).thenReturn(Optional.of(airLine));
//		    assertThat(airlineServiceImplementation.findById(111)).isEqualTo(airLine);
//		    
//		}
//		
//		//NotfindByCities
//		@Test
//		public void NotfindByCitiesTest() throws ParseException{
//			
//			AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
//			AirLine airLine2 = new AirLine(111, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
//			List<AirLine> airLines = new ArrayList<>();
//			airLines.add(airLine1);
//			airLines.add(airLine2);
//			Mockito.when(airLineRepository.findByCities("goa","chennai")).thenReturn(airLines);
//		    assertThat(airlineServiceImplementation.findByCities("goa","chennai")).isEqualTo(airLines);
//		    
//		}
//		
//		//NotfindByUser
//		@Test
//		public void NotfindByUserTest() throws ParseException{
//			
//			AirLine airLine1 = new AirLine(110, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 3000, 44,0);
//			AirLine airLine2 = new AirLine(111, "airindia","chennai", "goa", "18-07-2021", "150 mins", "2:00 AM", "4:30 AM", 2000, 44,0);
//			List<AirLine> airLines = new ArrayList<>();
//			airLines.add(airLine1);
//			airLines.add(airLine2);
//			Mockito.when(airLineRepository.findByUser("goa","chennai", "18-07-2021")).thenReturn(airLines);
//		    assertThat(airlineServiceImplementation.findByUser("goa","chennai", "18-07-2021")).isEqualTo(airLines);
//		    
//		}
//		
//		//NotfindAll
//		@Test
//		public void NotfindallTest() throws ParseException{
//
//			AirLine airLine1 = null;
//			
//			AirLine airLine2 = null;
//			
//			List<AirLine> airLines = new ArrayList<>();
//			airLines.add(airLine1);
//			airLines.add(airLine2);
//			
//			Mockito.when(airLineRepository.findAll()).thenReturn(airLines);
//			
//			assertThat(airlineServiceImplementation.findAll()).isEqualTo(airLines);
//		}
//				
//		//Notupdate
//		@Test
//		public void NotupdateTest() throws ParseException{
//			
//			AirLine airLine = new AirLine(110, "airindia","chennai", "goa", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44,0);
//			
//		    Mockito.when(airLineRepository.findById(111)).thenReturn(Optional.of(airLine));
//			
//		    airLine.setPrize(2000);
//		    
//			Mockito.when(airLineRepository.save(airLine)).thenReturn(airLine);
//			
//			assertThat(airlineServiceImplementation.update(airLine)).isNotEqualTo(airLine);
//			
//		}
//	}
