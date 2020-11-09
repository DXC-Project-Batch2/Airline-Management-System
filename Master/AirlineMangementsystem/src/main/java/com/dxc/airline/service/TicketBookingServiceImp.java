package com.dxc.airline.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dxc.airline.exception.TicketBookingException;
import com.dxc.airline.model.Sample_model;
import com.dxc.airline.model.TicketBooking;
import com.dxc.airline.repository.JasperRepo;
import com.dxc.airline.repository.TicketBookingRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class TicketBookingServiceImp implements ITicketBookingService {

	@Autowired
	TicketBookingRepository repo;
	
	@Autowired
	JasperRepo jpRepo;
	

	@Override
	public TicketBooking add(TicketBooking booking) throws TicketBookingException {

		TicketBooking isValid = validateTicketBooking(booking);

		if (isValid != null) {

			return repo.save(booking);
		} else {

			throw new TicketBookingException("Ticket booking failed, try again...");
		}
	}

	public TicketBooking validateTicketBooking(TicketBooking booking) {

		if ((booking.getNoOfPassengers() >= 0) && (booking.getSource() != booking.getDestination())) {

			return booking;
		}

		return null;
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	@Override
	public List<TicketBooking> getAll() {

		List<TicketBooking> theTickets=repo.findAll();
		System.out.println(theTickets);
		return repo.findAll();
	}

	@Override
	public TicketBooking findById(long id) {
		TicketBooking theTicket = null;
		Optional<TicketBooking> result = repo.findById(id);
		if (result.isPresent()) {
			theTicket = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find ticket ");
		}

		return theTicket;
	}

	@Override
	public TicketBooking update(TicketBooking booking) {
		Optional<TicketBooking> updateBooking = repo.findById(booking.getTicketId());
		if(updateBooking.isPresent())
		{
			return repo.save(booking);
		}
		// TODO Auto-generated method stub
		return null;
	}
	

	public String exportReport(String reportFormat) throws JRException, IOException {
        String path = "C:\\Report";
        List<Sample_model> ticketReport = jpRepo.sampleModel();
        System.out.println("----->>>>>>"+ticketReport);
        System.out.println(this.getClass());
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:JasperReport.jrxml");
        File bg = ResourceUtils.getFile("classpath:background/flights-1589975710.png");
        
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ticketReport);
        Map<String, Object> parameters = new HashMap<>();
        
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("background/flights-1589975710.png")) {
            parameters.put("bgImage", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(inputStream))));
        } catch (JRException | IOException e) {
             throw new RuntimeException("Failed to load images", e);
        }
        
        try (InputStream iS = this.getClass().getClassLoader().getResourceAsStream("background/airline.png")) {
            parameters.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(iS))));
        } catch (JRException | IOException e) {
             throw new RuntimeException("Failed to load images", e);
        }
      
        parameters.put("createdBy", "anil");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\JasperReport.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\JasperReport.pdf");
        }

        return "report generated in path : " + path;
    }
	
	public List<Sample_model> sampleModel(){
		
		List<Sample_model> theSampleModel = jpRepo.sampleModel();
		return theSampleModel;

	}

	@Override
	public long LastEnteredTicket() {
		
		return repo.LastEnteredTicket();
	};

}