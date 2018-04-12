package com.xyz.ata.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "ATA_TBL_Reservation")
public class ReservationBean {
	@Id
	@Column(name = "reservationId")
	private String reservationID;
	@Column(name = "UserId")
	private String userID;
	@Column(name = "RouteId")
	private String routeID;
	@Column(name = "BookingDate")
	private Date bookingDate;
	@Column(name = "JourneyDate")
	private Date journeyDate;
	@Column(name = "VehicleId")
	private String vehicleID;
	@Column(name = "DriverId")
	private String driverID;
	@Column(name = "BookingStatus")
	private String bookingStatus;
	@Column(name = "TotalFare")
	private double totalFare;
	@Column(name = "BoardingPoint")
	private String boardingPoint;
	@Column(name = "DropPoint")
	private String dropPoint;
	@Transient
	private String cardNumber;
	

	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the reservationID
	 */
	public String getReservationID() {
		return reservationID;
	}

	/**
	 * @param reservationID
	 *            the reservationID to set
	 */
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the routeID
	 */
	public String getRouteID() {
		return routeID;
	}

	/**
	 * @param routeID
	 *            the routeID to set
	 */
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	/**
	 * @return the bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate
	 *            the bookingDate to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the journeyDate
	 */
	public Date getJourneyDate() {
		return journeyDate;
	}

	/**
	 * @param journeyDate
	 *            the journeyDate to set
	 */
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
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
	 * @return the driverID
	 */
	public String getDriverID() {
		return driverID;
	}

	/**
	 * @param driverID
	 *            the driverID to set
	 */
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	/**
	 * @return the bookingStatus
	 */
	public String getBookingStatus() {
		return bookingStatus;
	}

	/**
	 * @param bookingStatus
	 *            the bookingStatus to set
	 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	/**
	 * @return the totalFare
	 */
	public double getTotalFare() {
		return totalFare;
	}

	/**
	 * @param totalFare
	 *            the totalFare to set
	 */
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	/**
	 * @return the boardingPoint
	 */
	public String getBoardingPoint() {
		return boardingPoint;
	}

	/**
	 * @param boardingPoint
	 *            the boardingPoint to set
	 */
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	/**
	 * @return the dropPoint
	 */
	public String getDropPoint() {
		return dropPoint;
	}

	/**
	 * @param dropPoint
	 *            the dropPoint to set
	 */
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

}
