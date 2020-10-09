package com.dxc.airline.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class AdminInfo {
	
	String name;
	@Id
	String username;
	String gender;
	Date dob;
	String mobile; 
	String address;
	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminInfo(String name, String username, String gender, String strdob, String mobile, String address) throws ParseException{
		super();
		this.name = name;
		this.username = username;
		this.gender = gender;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		dob=sdf.parse(strdob);
		this.mobile = mobile;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", username=" + username + ", gender=" + gender + ", dob=" + dob + ", mobile=" + mobile
				+ ", address=" + address +"]";
	}	
	
	

}
