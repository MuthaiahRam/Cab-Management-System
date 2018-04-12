package com.xyz.ata.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ATA_TBL_Driver")
public class DriverBean {
	@Id
	@Column(name="driverId")
   private String driverID;
	@Column(name="Name")
   private String name;
	@Column(name="Street")
   private String street;
	@Column(name="Location")
   private String location;
	@Column(name="City")
   private String city;
	@Column(name="State")
   private String state;
	@Column(name="Pincode")
   private String pincode;
	@Column(name="MobileNo")
   private String mobileNo;
	@Column(name="LicenseNumber")
   private String licenseNumber;
	@Transient
	private boolean checked;
	@Column(name="status")
	private Date status;
public Date getStatus() {
		return status;
	}
	public void setStatus(Date status) {
		this.status = status;
	}
public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
/**
 * @return the driverID
 */
   
   
public String getDriverID() {
	return driverID;
}
/**
 * @param driverID the driverID to set
 */
public void setDriverID(String driverID) {
	this.driverID = driverID;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the street
 */
public String getStreet() {
	return street;
}
/**
 * @param street the street to set
 */
public void setStreet(String street) {
	this.street = street;
}
/**
 * @return the location
 */
public String getLocation() {
	return location;
}
/**
 * @param location the location to set
 */
public void setLocation(String location) {
	this.location = location;
}
/**
 * @return the city
 */
public String getCity() {
	return city;
}
/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}
/**
 * @return the state
 */
public String getState() {
	return state;
}
/**
 * @param state the state to set
 */
public void setState(String state) {
	this.state = state;
}
/**
 * @return the pincode
 */
public String getPincode() {
	return pincode;
}
/**
 * @param pincode the pincode to set
 */
public void setPincode(String pincode) {
	this.pincode = pincode;
}
/**
 * @return the mobileNo
 */
public String getMobileNo() {
	return mobileNo;
}
/**
 * @param mobileNo the mobileNo to set
 */
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
/**
 * @return the licenseNumber
 */
public String getLicenseNumber() {
	return licenseNumber;
}
/**
 * @param licenseNumber the licenseNumber to set
 */
public void setLicenseNumber(String licenseNumber) {
	this.licenseNumber = licenseNumber;
}
   
 
}


