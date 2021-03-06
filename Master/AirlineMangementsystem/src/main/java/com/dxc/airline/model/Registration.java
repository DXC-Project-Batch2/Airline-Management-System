package com.dxc.airline.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registration {

	String username;
	String password;
	String name;
	String Lastname;
	String gender;
	Date dob;
	String fathername;
	String passportname;
	long passportnumber;
	Date expiry;
	String doorNumber;
	String street;
	String area;
	String country;
	String state;
	String city;
	long postalCode;
	String landMark;
	String mobile; 
	String securityQuestion;
	String answer;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(String username, String password, String name, String lastname, String gender, String strdob,
			String fathername, String passportname, long passportnumber, String strexpiry, String doorNumber, String street,
			String area, String country, String state, String city, long postalCode, String landMark, String mobile,
			String securityQuestion, String answer) throws ParseException  {

		super();
		this.username = username;
		this.password = password;
		this.name = name;
		Lastname = lastname;
		this.gender = gender;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		dob=sdf.parse(strdob);
		this.fathername = fathername;
		this.passportname = passportname;
		this.passportnumber = passportnumber;
		expiry = sdf.parse(strexpiry);
		this.doorNumber = doorNumber;
		this.street = street;
		this.area = area;
		this.country = country;
		this.state = state;
		this.city = city;
		this.postalCode = postalCode;
		this.landMark = landMark;
		this.mobile = mobile;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getPassportname() {
		return passportname;
	}

	public void setPassportname(String passportname) {
		this.passportname = passportname;
	}

	public long getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(long passportnumber) {
		this.passportnumber = passportnumber;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Registration [username=" + username + ", password=" + password + ", name=" + name + ", Lastname="
				+ Lastname + ", gender=" + gender + ", dob=" + dob + ", fathername=" + fathername + ", passportname="
				+ passportname + ", passportnumber=" + passportnumber + ", expiry=" + expiry + ", doorNumber="
				+ doorNumber + ", street=" + street + ", area=" + area + ", country=" + country + ", state=" + state
				+ ", city=" + city + ", postalCode=" + postalCode + ", landMark=" + landMark + ", mobile=" + mobile
				+ ", securityQuestion=" + securityQuestion + ", answer=" + answer + "]";
	}

	
	}
	
