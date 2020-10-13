package com.dxc.airline;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.airline.model.Admin;
import com.dxc.airline.model.AdminInfo;
import com.dxc.airline.model.AirLine;
import com.dxc.airline.model.City;
import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.model.User;
import com.dxc.airline.model.UserInfo;
import com.dxc.airline.model.UserSecurity;
import com.dxc.airline.repository.AdminInfoRepository;
import com.dxc.airline.repository.AdminRepository;
import com.dxc.airline.repository.AdminSecurityRepository;
import com.dxc.airline.repository.AirLineRepository;
import com.dxc.airline.repository.CityRepository;
import com.dxc.airline.repository.TicketBookingRepository;
import com.dxc.airline.repository.UserInfoRepository;
import com.dxc.airline.repository.UserRepository;
import com.dxc.airline.repository.UserSecurityRepository;
import com.dxc.airline.service.AdminInfoServiceImplementation;
import com.dxc.airline.service.AdminSecurityServiceImplementation;
import com.dxc.airline.service.AdminServiceImplementation;
import com.dxc.airline.service.AirlineServiceImplementation;
import com.dxc.airline.service.CityServiceImplementation;
import com.dxc.airline.service.TicketBookingServiceImp;
import com.dxc.airline.service.UserInfoServiceImplementation;
import com.dxc.airline.service.UserSecurityServiceImp;
import com.dxc.airline.service.UserServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
class AirlineMangementsystemApplicationTests {

	@Autowired
	UserServiceImplementation userServiceImplementation;

	@Autowired
	UserSecurityServiceImp userSecurityServiceImp;
	
	@Autowired
	AdminInfoServiceImplementation adminInfoServiceImplementation;
	
	@Autowired
	UserInfoServiceImplementation userInfoServiceImplementation;
	
	@Autowired
	AirlineServiceImplementation airlineServiceImplementation;
	
	@Autowired
	AdminServiceImplementation adminServiceImplementation;
	
	@Autowired
	AdminSecurityServiceImplementation adminSecurityServiceImplementation;
	
	@Autowired
	CityServiceImplementation cityServiceImplementation;
	
	@Autowired
	TicketBookingServiceImp ticketBookingServiceImp;
	
	
	
	
	@MockBean
	UserRepository userRepository;

	@MockBean
	UserSecurityRepository userSecurityRepository;
	
	@MockBean
	AdminInfoRepository adminInfoRepository;
	
	@MockBean
	UserInfoRepository userInfoRepository;
	
	@MockBean
	AirLineRepository airLineRepository;
	
	@MockBean
	AdminRepository AdminRepository;

	@MockBean
	AdminSecurityRepository adminSecurityRepository;
	
	@MockBean
	CityRepository cityRepository;
	
	@MockBean
	TicketBookingRepository TicketBookingRepository;
	
	
	
	@Test
	public void UserfindAllTest() {
		when(userRepository.findAll()).thenReturn(
				Stream.of(new User("pasupathi@gmail.com", "pasupathi"), new User("p@gmail.com", "pasupathi"))
						.collect(Collectors.toList()));
		assertEquals(2, userServiceImplementation.findAll().size());
	}

	@Test
	public void UserfindByUsernameTest() {
		String username = "aaa@gmail.com";
		when(userRepository.findByUsername(username))
				.thenReturn(Stream.of(new User("aaaa@gmail.com","aaaa")).collect(Collectors.toList()));
		assertEquals(1, userServiceImplementation.findByUsername(username).size());	}

	@Test
	public void saveUserTest() {
		User user = new User("aaa@gmail.com", "aaa");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userServiceImplementation.save(user));
	}

	@Test
	public void deleteUserTest() {
		String username = "aaa@gmail.com";
		userServiceImplementation.deleteById(username);
		verify(userRepository, times(1)).deleteById(username);
	}

	@Test
	public void UserSecurityfindAllTest() {
		when(userSecurityServiceImp.findAll()).thenReturn(
				Stream.of(new UserSecurity("pasupathi@gmail.com", "what is favorite number?","100"), new UserSecurity("p@gmail.com",  "what is favorite number?","100"))
						.collect(Collectors.toList()));
		assertEquals(2, userSecurityServiceImp.findAll().size());
	}

	@Test
	public void UserSecurityfindByUsernameTest() {
		String username = "aaa@gmail.com";
		when(userSecurityRepository.findByUsername(username))
				.thenReturn(Stream.of(new UserSecurity("pasupathi@gmail.com", "what is favorite number?","100")).collect(Collectors.toList()));
		assertEquals(1, userSecurityServiceImp.findByUsername(username).size());	}

	@Test
	public void saveUserSecurityTest() {
		UserSecurity userSecurity = new UserSecurity("pasupathi@gmail.com", "what is favorite number?","100");
		when(userSecurityRepository.save(userSecurity)).thenReturn(userSecurity);
		assertEquals(userSecurity, userSecurityServiceImp.add(userSecurity));
	}

	@Test
	public void deleteUserSecurityTest() {
		String username = "aaa@gmail.com";
		userSecurityServiceImp.deleteById(username);
		verify(userSecurityRepository, times(1)).deleteById(username);
	}

	@Test
	public void adminSecurityfindAllTest() throws ParseException {
		when(adminInfoRepository.findAll()).thenReturn(
				Stream.of(new AdminInfo("pasupathi","pasupathi@gmail.com", "male","18-07-1999","9003299897","tadepalligudem"), new AdminInfo("pppp","ppppp@gmail.com", "male","18-07-1999","9003299897","tadepalligudem"))
						.collect(Collectors.toList()));
		assertEquals(2, adminInfoServiceImplementation.findAll().size());
	}

	@Test
	public void adminSecurityfindByUsernameTest() throws ParseException {
		String username = "aaa@gmail.com";
		when(adminInfoRepository.findByUsername(username))
				.thenReturn(Stream.of(new AdminInfo("pasupathi","pasupathi@gmail.com", "male","18-07-1999","9003299897","tadepalligudem")).collect(Collectors.toList()));
		assertEquals(1, adminInfoServiceImplementation.findByUsername(username).size());	
	}

	@Test
	public void saveadminSecurityTest() throws ParseException {
		AdminInfo adminInfo = new AdminInfo("pasupathi","pasupathi@gmail.com", "male","18-07-1999","9003299897","tadepalligudem");
		when(adminInfoRepository.save(adminInfo)).thenReturn(adminInfo);
		assertEquals(adminInfo, adminInfoServiceImplementation.save(adminInfo));
	}

	@Test
	public void deleteadminSecurityTest() {
		String username = "aaa@gmail.com";
		adminInfoServiceImplementation.delete(username);
		verify(adminInfoRepository, times(1)).deleteById(username);
	}
	
	@Test
	public void UserInfofindAllTest() throws ParseException {
		when(userInfoRepository.findAll()).thenReturn(
				Stream.of(new UserInfo("pasupathi","pasupathi@gmail.com", "male","18-07-1999","9003299897","tadepalligudem"), new UserInfo("paul","paul@gmail.com", "male","18-07-1999","9003299897","tadepalligudem"))
						.collect(Collectors.toList()));
		assertEquals(2, userInfoServiceImplementation.findAll().size());
	}

	@Test
	public void UserInfofindByUsernameTest() throws ParseException {
		String username = "aaa@gmail.com";
		when(userInfoRepository.findByUsername(username))
				.thenReturn(Stream.of(new UserInfo("pasupathi","pasupathi@gmail.com", "male","18-07-1999","9003299897","tadepalligudem")).collect(Collectors.toList()));
		assertEquals(1, userInfoServiceImplementation.findByUsername(username).size());	}

	@Test
	public void saveUserInfoTest() throws ParseException {
		UserInfo userInfo = new UserInfo("pasupathi","pasupathi@gmail.com", "male","18-07-1999","9003299897","tadepalligudem");
		when(userInfoRepository.save(userInfo)).thenReturn(userInfo);
		assertEquals(userInfo, userInfoServiceImplementation.save(userInfo));
	}

	@Test
	public void deleteUserInfoTest() {
		String username = "aaa@gmail.com";
		userInfoServiceImplementation.deleteById(username);
		verify(userInfoRepository, times(1)).deleteById(username);
	}

	@Test
	public void AirlinefindAllTest() throws ParseException {
		when(airLineRepository.findAll()).thenReturn(
				Stream.of(new AirLine(110, "chennai", "destination", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44, 0), new AirLine(110, "chennai", "destination", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44, 0))
						.collect(Collectors.toList()));
		assertEquals(2, airlineServiceImplementation.findAll().size());
	}

	@Test
	public void AirlinefindByUsernameTest() throws ParseException {
		int id = 111;
		when(airLineRepository.findByplaneId(id))
				.thenReturn(Stream.of(new AirLine(110, "chennai", "destination", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44, 0)).collect(Collectors.toList()));
		assertEquals(1, airlineServiceImplementation.findByAirlineid(id).size());	
		}

	@Test
	public void saveAirlineTest() throws ParseException {
		AirLine airLine = new AirLine(110, "chennai", "destination", "18-07-1999", "150 mins", "2:00 AM", "4:30 AM", 10000, 44, 0);
		when(airLineRepository.save(airLine)).thenReturn(airLine);
		assertEquals(airLine, airlineServiceImplementation.save(airLine));
	}

	@Test
	public void deleteAirlineTest() {
		int id = 111;
		airlineServiceImplementation.deleteById(id);
		verify(airLineRepository, times(1)).deleteById(id);
	}
	
	@Test
	public void AdminfindAllTest() throws ParseException {
		when(AdminRepository.findAll()).thenReturn(Stream.of(new Admin("pasupath@gmail.com", "pasupat"), new Admin("p@gmail.com", "pasupathi"))
				.collect(Collectors.toList()));
		assertEquals(2, adminServiceImplementation.findAll().size());
	}

	@Test
	public void adminfindByUsernameTest() {
		String username = "aaa@gmail.com";
		when(AdminRepository.findByUsername(username))
				.thenReturn(Stream.of(new Admin("aaaa@gmail.com","aaaa")).collect(Collectors.toList()));
		assertEquals(1, adminServiceImplementation.findByUsername(username).size());	}

	@Test
	public void saveAdminTest() {
		Admin admin = new Admin("aaa@gmail.com", "aaa");
		when(AdminRepository.save(admin)).thenReturn(admin);
		assertEquals(admin, adminServiceImplementation.save(admin));
	}

	@Test
	public void deleteAdminTest() {
		String username = "aaa@gmail.com";
		adminServiceImplementation.deleteById(username);
		verify(AdminRepository, times(1)).deleteById(username);
	}
	
	
	@Test
	public void cityfindAllTest() throws ParseException {
		when(cityRepository.findAll()).thenReturn(Stream.of(new City("Kolkata"), new City("Goa"))
				.collect(Collectors.toList()));
		assertEquals(2, cityServiceImplementation.findAll().size());
	}

	@Test
	public void cityfindBycityTest() {
		String city = "Kolkata";
		when(cityRepository.findBycity(city))
				.thenReturn(Stream.of(new City("Madras")).collect(Collectors.toList()));
		assertEquals(1, cityServiceImplementation.findBycity(city).size());	}

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
	
	
	@Test
	public void TicketBookingfindAllTest() {
		when(ticketBookingServiceImp.getAll()).thenReturn(
				Stream.of(new ticketBooking(122334L, "Madras","Kolkata",2019), new ticketBooking(121312312L, "Madrs","Kolka",2020))
						.collect(Collectors.toList()));
		assertEquals(2, ticketBookingServiceImp.getAll().size());
	}

	


	@Test
	public void deleteTicketBookingTest() {
		String username = "aaa@gmail.com";
		userSecurityServiceImp.deleteById(username);
		verify(userSecurityRepository, times(1)).deleteById(username);
	}
	

	

}
