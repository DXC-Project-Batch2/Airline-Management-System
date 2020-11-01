package com.dxc.airline.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.dxc.airline.exception.UserInfoException;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
public class UserInfo {
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =40)
	String name;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =40)
	String Lastname;
	
	String gender;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	Date dob;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =80)
	String fathername;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =80)
	String passportname;
	
	@NotNull(message = "Mandatory field")
	long passportnumber;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	Date expiry;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =10)
	String doorNumber;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =80)
	String street;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =80)
	String area;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1, max = 56)
	String country;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1, max = 56)
	String state;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1, max = 56)
	String city;
	
	@NotNull(message = "Mandatory field")
	long postalCode;
	
	String landMark;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 6, max = 56)
	String mobile; 
	
	@Id
	@NotNull(message = "Mandatory field")
	@Size(min = 3, max = 25)
	String username;
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserInfo(String name, String lastname, String gender, String strdob, String fathername, String passportname,
			long passportnumber, String strexpiry, String doorNumber, String street, String area, String country,
			String state, String city, long postalCode, String landMark, String mobile, String username) throws ParseException {
		super();
		this.name = validateName(name);
		Lastname = validateLastname(lastname);
		this.gender = validateGender(gender);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		dob=sdf.parse(strdob);
		this.fathername = validateFathername(fathername);
		this.passportname = validatePassportname(passportname);
		this.passportnumber = validatePassportnumber(passportnumber);
		expiry = sdf.parse(strexpiry);
		this.doorNumber = validateDoorNumber(doorNumber);
		this.street = validateStreet(street);
		this.area = validateArea(area);
		this.country = validateCountry(country);
		this.state = validateState(state);
		this.city = validateCity(city);
		this.postalCode = validatePostalCode(postalCode);
		this.landMark = landMark;
		this.mobile = validateMobile(mobile);
		this.username = validateUsername(username);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = validateName(name);
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = validateLastname(lastname);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = validateGender(gender);
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
		this.fathername = validateFathername(fathername);
	}

	public String getPassportname() {
		return passportname;
	}

	public void setPassportname(String passportname) {
		this.passportname = validatePassportname(passportname);
	}

	public long getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(long passportnumber) {
		this.passportnumber = validatePassportnumber(passportnumber);
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
		this.doorNumber = validateDoorNumber(doorNumber);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = validateStreet(street);
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = validateArea(area);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = validateCountry(country);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = validateState(state);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = validateCity(city);
	}

	public long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(long postalCode) {
		this.postalCode = validatePostalCode(postalCode);
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
		this.mobile = validateMobile(mobile);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = validateUsername(username);
	}

	@Override
	public String toString() {
		return "AdminInfo [name=" + name + ", Lastname=" + Lastname + ", gender=" + gender + ", dob=" + dob
				+ ", fathername=" + fathername + ", passportname=" + passportname + ", passportnumber=" + passportnumber
				+ ", expiry=" + expiry + ", doorNumber=" + doorNumber + ", street=" + street + ", area=" + area
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", postalCode=" + postalCode
				+ ", landMark=" + landMark + ", mobile=" + mobile + ", username=" + username + "]";
	}

	public String validateName(String name) {
		if (name == null) {
			throw new UserInfoException("name cannot be blank");
		} 
		return name;
	}
	
	public String validateLastname(String Lastname) {
		if (Lastname == null) {
			throw new UserInfoException("lastname cannot be blank");
		} 
		return Lastname;
	}
	
	public String validateGender(String gender) {
		if (gender == null) {
			throw new UserInfoException("gender cannot be blank");
		} 
		return gender;
	}
	
	public String validateFathername(String fathername) {
		if (fathername == null) {
			throw new UserInfoException("fathername cannot be blank");
		} 
		return fathername;
	}
	
	public String validatePassportname(String passportname) {
		if (passportname == null) {
			throw new UserInfoException("passportname cannot be blank");
		} 
		return passportname;
	}
	
	public long validatePassportnumber(long passportnumber) {
		 char[] A = Long.toString(passportnumber).toCharArray();
		if (passportnumber == 0) {
			throw new UserInfoException("passportnumber cannot be blank");
		} else {
				if (!(A.length == 8)) {
					throw new UserInfoException("passportnumber number is Invalid or its should contains 8 digits");
				} 
			}
		return Long.valueOf(new String(A));
	}

	public String validateDoorNumber(String doorNumber) {
		if (doorNumber == null) {
			throw new UserInfoException("doorNumber cannot be blank");
		} 
		return doorNumber;
	}

	public String validateStreet(String street) {
		if (street == null) {
			throw new UserInfoException("street cannot be blank");
		} 
		return street;
	}

	public String validateArea(String area) {
		if (area == null) {
			throw new UserInfoException("area cannot be blank");
		} 
		return area;
	}
	
	public String validateCountry(String country) {
		if (country == null) {
			throw new UserInfoException("country cannot be blank");
		} 
		return country;
	}

	
	public String validateState(String state) {
		if (state == null) {
			throw new UserInfoException("state cannot be blank");
		} 
		return state;
	}
	
	public String validateCity(String city) {
		if (city == null) {
			throw new UserInfoException("city cannot be blank");
		} 
		return city;
	}

	public long validatePostalCode(long postalCode) {
		 char[] A = Long.toString(postalCode).toCharArray();
		if (postalCode == 0) {
			throw new UserInfoException("postalCode cannot be blank");
		} else {
				if (!(A.length == 6)) {
					throw new UserInfoException("postalCode number is Invalid or its should contains 6 digits");
				} 
			}
		return Long.valueOf(new String(A));
	}

	public String validateMobile(String mobile) {
		if (mobile == null) {
			throw new UserInfoException("mobile cannot be blank");
		} else {
				if (!(mobile.length() == 10)) {
					throw new UserInfoException("mobile number is Invalid or its should contains 10 digits");
				} 
			}
		return mobile;
	}

	public String validateUsername(String username) {
		if (username == null) {
			throw new UserInfoException("Username cannot be blank");
		} else {
			if (!username.endsWith("gmail.com") && !username.endsWith("yahoo.com") && username.contains("@")) {
				throw new UserInfoException("Username should ends with @gmail.com or @yahoo.com");
			} else {
				if (username.length()-10 < 3) {
					throw new UserInfoException("Username is too short");
				} else if (username.length() > 25) {
					throw new UserInfoException("Username is too long");
				}
			}
		}
		return username;
	}
	
}
