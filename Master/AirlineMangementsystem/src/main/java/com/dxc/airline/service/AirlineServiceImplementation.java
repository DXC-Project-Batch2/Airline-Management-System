package com.dxc.airline.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		
		AirLine airLine = new AirLine(e.getPlaneId(), e.getCarrierName(), e.getSource(), e.getDestination(), strDate, e.getDuration(), e.getStarting_time(), e.getEnding_time(), e.getPrize(), e.getAvaliable_seats(), e.getSold_out());	
		AirLine isValid = validateAirLine(airLine);

		if (isValid != null) {
			for(int i=0;i<10;i++)
			{
				airlineRepository.save(airLine);
				strDate = dateFormat.format(airLine.getDate());  
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Calendar c = Calendar.getInstance();
					c.setTime(sdf.parse(strDate));
					c.add(Calendar.DATE, e.getPeriod()); // number of days to add
					//c.add(Calendar.DATE, 1);
					airLine.setDate(c.getTime());
					airlineRepository.save(airLine);
			} 
			
			}
		else {

			throw new AirlineException("Airline addition failed, try again...");
		}
		return airLine;
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
		Optional<AirLine> findbyId = airlineRepository.findById(theAirline.getPlaneId());
		if (findbyId.isPresent()) {
			return airlineRepository.save(theAirline);
		}
		return null;
	}

	@Override
	@Transactional
	public AirLine findById(int id) {

		Optional<AirLine> result = airlineRepository.findById(id);

		AirLine theAirline = null;

		if (result.isPresent()) {
			theAirline = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find flight ");
		}

		return theAirline;

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