package com.dxc.airline.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airline.exception.AirlineException;
import com.dxc.airline.model.AirLine;
import com.dxc.airline.model.AirLineDetalis;
import com.dxc.airline.service.AirlineService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineController {
	
	@Autowired
	AirlineService service;
	
	@ResponseBody
	@GetMapping(path="/airline")
	public List<AirLine> findAll() throws ParseException{
		return service.findAll();
	}
	
	
	@PostMapping(path="/airline/add")
	@ResponseBody
	public AirLine save(@RequestBody AirLineDetalis theairline ) throws AirlineException, ParseException {
		
		return service.save(theairline);
	}
	
	@PutMapping(path = "/airline/update")
	@ResponseBody
	public AirLine update(@RequestBody AirLine theairline ) throws ParseException {
		
		return service.update(theairline);
	}
	
	@GetMapping(path="/airline/{id}")
	@ResponseBody
	public List<AirLine> findById(@PathVariable("id")int id) {
		
		List<AirLine> theAirline = service.findById(id);
		
		if (theAirline == null) {
			return null;
		}
		
		return theAirline;
	}

	@GetMapping(path="/airline/check/{id}")
	@ResponseBody
	public Boolean findByIdCheck(int id) {
		return service.findByIdCheck(id);
	}
	
	@GetMapping(path="/airline/sno/{sno}")
	@ResponseBody
	public AirLine findBySno(@PathVariable("sno")int sno) {
		
		AirLine theAirline = service.findBySno(sno);
		
		if (theAirline == null) {
			throw new RuntimeException("flight not found - ");
		}
		
		return theAirline;
	}

	
	@GetMapping("/airline/{source}/{destination}")
	@ResponseBody
	public List<AirLine> getAirline(@PathVariable String source, @PathVariable String destination) {
		
		List<AirLine> theAirline = service.findByCities(source, destination);
		
		if (theAirline == null) {
			throw new RuntimeException("Flight  not found - ");
		}
		
		return theAirline;
	}
	
	@DeleteMapping(path="/airlineDelete/{sno}")
	@ResponseBody
	public void deleteById(@PathVariable("sno")int sno) {
		
		service.deleteById(sno);
	}

	@DeleteMapping(path="/airlineDelete/planeid/{planeId}")
	@ResponseBody
	public void deleteByPlaneId(@PathVariable("planeId")int planeId) {
		
		service.deleteByPlane_Id(planeId);
	}
	
	@DeleteMapping(path="/airlineDeleteDate")
	@ResponseBody
	public void deleteByCurrentDate() {
		
		service.deleteByDate();
	}

	@GetMapping("/airline/{source}/{destination}/{date}")
	@ResponseBody
	public List<AirLine> getAirline(@PathVariable String source, @PathVariable String destination,@PathVariable String date) throws ParseException, java.text.ParseException {
		//*for converting a string date to requried datetime*//
		DateFormat dfrmt = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = dfrmt.parse(date);
		
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		System.out.println("==>"+formatter.format(dt));
		
		String str = formatter.format(dt)+"  05:30:00.000000";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date dat = df.parse(str);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String strDate = dateFormat.format(dat);
		
		List<AirLine> theAirline = service.findByUser(source, destination, strDate);
		
		if (theAirline == null) {
			throw new RuntimeException("Flight  not found - ");
		}
		
		return theAirline;
	}
	
	

}
