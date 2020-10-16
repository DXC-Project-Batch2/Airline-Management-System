package com.dxc.airline.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity

public class Registration {
	

	@Id
	private long mobileNumber;
	
	@Email
	@NotNull(message = "A valid E-mail id is required")
	@Size(min = 2, max = 100)
     private String mailId;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =40)
	private String firstName;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =40)
	private String lastName;
		
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =40)
	private String fatherName;
	
	@NotNull(message = "Please enter in MM/dd/yyyy format")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date DOB;

	@NotNull(message = "Mandatory field")
	@Size(min = 7,max = 7)
	private String passportNumber;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1, max = 100)
	private String addressLine1;
	
	@Size(min = 1, max = 100)
	private String adrressLine2;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1, max = 100)
	private String state;
	
	
	private long postalcode;
	
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1, max = 56)
	private String country;
	
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1)
	private String password;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1)
	private String conformPassword;
	
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
}


	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public Date getDOB() {
		return DOB;
	}


	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAdrressLine2() {
		return adrressLine2;
	}


	public void setAdrressLine2(String adrressLine2) {
		this.adrressLine2 = adrressLine2;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public long getPostalcode() {
		return postalcode;
	}


	public void setPostalcode(long postalcode) {
		this.postalcode = postalcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConformPassword() {
		return conformPassword;
	}


	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}


	@Override
	public String toString() {
		return "Registration [mobileNumber=" + mobileNumber + ", mailId=" + mailId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", fatherName=" + fatherName + ", DOB=" + DOB + ", passportNumber="
				+ passportNumber + ", addressLine1=" + addressLine1 + ", adrressLine2=" + adrressLine2 + ", state="
				+ state + ", postalcode=" + postalcode + ", country=" + country + ", password=" + password
				+ ", conformPassword=" + conformPassword + "]";
	}
	
	
	
	
	
	
	}
	
