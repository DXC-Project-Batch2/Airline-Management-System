package com.dxc.airline.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.airline.exception.AirlineException;
import com.dxc.airline.model.AirLine;
import com.dxc.airline.model.AirLineDetalis;
import com.dxc.airline.repository.AirLineRepository;

@Service
public class AirlineServiceImplementation implements AirlineService {

	@Autowired
	private AirLineRepository airlineRepository;

	@Override
	@Transactional
	public List<AirLine> findAll() {
		return airlineRepository.findAll();
	}

	@Override
	@Transactional
	public AirLine save(AirLineDetalis e) throws AirlineException, ParseException {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		String strDate = dateFormat.format(e.getDate());  
		
		AirLine airLine = new AirLine(0,e.getPlaneId(), e.getCarrierName(), e.getSource(), e.getDestination(), strDate, e.getDuration(), e.getStarting_time(), e.getEnding_time(), e.getPrize(), e.getAvaliable_seats(), e.getSold_out());	
		AirLine isValid = validateAirLine(airLine);
		Calendar c = Calendar.getInstance();
		if (isValid != null) {
			for(int i=0;i<e.getTrip();i++)
			{
				isValid = airlineRepository.save(isValid);
				Date date =isValid.getDate();
				String strDate1 = dateFormat.format(date);  
				c.setTime(dateFormat.parse(strDate1));
				c.add(Calendar.DATE,e.getSchedule_period());
				strDate1 = dateFormat.format(c.getTime());
				isValid = new AirLine(0,e.getPlaneId(), e.getCarrierName(), e.getSource(), e.getDestination(), strDate1, e.getDuration(), e.getStarting_time(), e.getEnding_time(), e.getPrize(), e.getAvaliable_seats(), e.getSold_out());			
			} 
			
			}
		else {

			throw new AirlineException("Airline addition failed, try again...");
		}
		return isValid;
	}

	public AirLine validateAirLine(AirLine theAirline) {

		if (((theAirline.getStarting_time() != theAirline.getEnding_time())) && (theAirline.getAvaliable_seats() != 0)
				&& (theAirline.getPrize() != 0)) {

			return theAirline;
		}

		return null;
	}

	@Override
	@Transactional
	public AirLine update(AirLine theAirline) {
		
		Optional<AirLine> findbyId = airlineRepository.findById(theAirline.getSno());
		if (findbyId.isPresent()) {
			return airlineRepository.save(theAirline);
		}
		return null;
	}

	@Override
	@Transactional
	public AirLine findBySno(int id) {

		Optional<AirLine> airLines = airlineRepository.findById(id);

		if (airLines!=null) {
			return airLines.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find flight ");
		}

	}

	
	@Override
	@Transactional
	public List<AirLine> findById(int id) {

		List<AirLine> airLines = airlineRepository.findAllById(id);


		if (airLines!=null) {
			return airLines;
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find flight ");
		}

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		airlineRepository.deleteById(id);
	}

	@Override
	public List<AirLine> findByCities(String source, String destination) {
		List<AirLine> theAirline = airlineRepository.findByCities(source, destination);
		if(theAirline!=null)
		{
			return theAirline;
		}
		return null;
	}
	
	@Override
	public List<AirLine> findByUser(String source, String destination,String date) {
		List<AirLine> theAirline = airlineRepository.findByUser(source, destination,date);
		if(theAirline!=null)
		{
			return theAirline;
		}
		return null;
	}

}