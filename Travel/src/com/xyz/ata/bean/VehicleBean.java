package com.xyz.ata.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ATA_TBL_Vehicle")
public class VehicleBean {
	@Id
	@Column(name = "vehicleId")
	private String vehicleID;
	@Column(name = "Name")
	private String name;
	@Column(name = "Type")
	private String type;
	@Column(name = "RegistrationNumber")
	private String registrationNumber;
	@Column(name = "SeatingCapacity")
	private int seatingCapacity;
	@Column(name = "FarePerKM")
	private double farePerKM;
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
	 * @return the vehicleID
	 */
	public String getVehicleID() {
		return vehicleID;
	}

	/**
	 * @param vehicleID
	 *            the vehicleID to set
	 */
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber
	 *            the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the seatingCapacity
	 */
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	/**
	 * @param seatingCapacity
	 *            the seatingCapacity to set
	 */
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	/**
	 * @return the farePerKM
	 */
	public double getFarePerKM() {
		return farePerKM;
	}

	/**
	 * @param farePerKM
	 *            the farePerKM to set
	 */
	public void setFarePerKM(double farePerKM) {
		this.farePerKM = farePerKM;
	}

}
