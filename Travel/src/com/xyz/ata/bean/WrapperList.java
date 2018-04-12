package com.xyz.ata.bean;

import java.util.ArrayList;
import java.util.Date;

public class WrapperList {
	
	private ArrayList<VehicleBean> vehicleList=new ArrayList<VehicleBean>();
	private ArrayList<DriverBean> driverList=new ArrayList<DriverBean>();
	private ArrayList<RouteBean> routeList=new ArrayList<RouteBean>();
	private ArrayList<ReservationBean> reservationList=new ArrayList<ReservationBean>();
	
	
	private int noOfSeats;
	private String type;
	private String source;
	private String destination;
	private Date journeyDate;

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the journeyDate
	 */
	public Date getJourneyDate() {
		return journeyDate;
	}

	/**
	 * @param journeyDate the journeyDate to set
	 */
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public ArrayList<ReservationBean> getReservationList() {
		return reservationList;
	}

	public void setReservationList(ArrayList<ReservationBean> reservationList) {
		this.reservationList = reservationList;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<RouteBean> getRouteList() {
		return routeList;
	}

	public void setRouteList(ArrayList<RouteBean> routeList) {
		this.routeList = routeList;
	}

	public ArrayList<DriverBean> getDriverList() {
		return driverList;
	}

	public void setDriverList(ArrayList<DriverBean> driverList) {
		this.driverList = driverList;
	}

	private VehicleBean vehicleBean;
	private DriverBean driverBean;
	private RouteBean routeBean;
	private ReservationBean reservationBean;

	

	/**
	 * @return the reservationBean
	 */
	public ReservationBean getReservationBean() {
		return reservationBean;
	}

	/**
	 * @param reservationBean the reservationBean to set
	 */
	public void setReservationBean(ReservationBean reservationBean) {
		this.reservationBean = reservationBean;
	}

	public DriverBean getDriverBean() {
		return driverBean;
	}

	public void setDriverBean(DriverBean driverBean) {
		this.driverBean = driverBean;
	}

	public RouteBean getRouteBean() {
		return routeBean;
	}

	public void setRouteBean(RouteBean routeBean) {
		this.routeBean = routeBean;
	}

	public VehicleBean getVehicleBean() {
		return vehicleBean;
	}

	public void setVehicleBean(VehicleBean vehicleBean) {
		this.vehicleBean = vehicleBean;
	}

	public ArrayList<VehicleBean> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(ArrayList<VehicleBean> vehicleList) {
		this.vehicleList = vehicleList;
	}

	
}
