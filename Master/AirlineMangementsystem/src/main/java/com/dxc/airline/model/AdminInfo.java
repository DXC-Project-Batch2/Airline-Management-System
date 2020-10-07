package com.dxc.airline.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class AdminInfo {
	
	@Id
	int aadhaarNo;
	String name;
	int age;
	Date dob;
	String address;
	int passport;
	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminInfo(int aadhaarNo, String name, int age, Date dob, String address, int passport) {
		super();
		this.aadhaarNo = aadhaarNo;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.address = address;
		this.passport = passport;
	}
	public int getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(int aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public int getPassport() {
		return passport;
	}
	public void setPassport(int passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return "AdminInfo [aadhaarNo=" + aadhaarNo + ", name=" + name + ", age=" + age + ", dob=" + dob + ", address="
				+ address + ", passport=" + passport + "]";
	}
	
	
	

}
