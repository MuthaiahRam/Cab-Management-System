package com.xyz.ata.service;

import java.util.ArrayList;
import java.util.Date;

import com.xyz.ata.bean.DriverBean;
import com.xyz.ata.bean.ReservationBean;
import com.xyz.ata.bean.RouteBean;
import com.xyz.ata.bean.VehicleBean;

public interface Administrator {
	
	public String addVehicle(VehicleBean vehicleBean);
	public int deleteVehicle(ArrayList<String> vehicleID);
	public VehicleBean viewVehicle(String vehicleID);
	public boolean modifyVehicle(VehicleBean vehicleBean);
	public String addDriver(DriverBean driverBean);
	public int deleteDriver(ArrayList<String> driverID);
	public boolean allotDriver(String reservationID, String driverID);
	public boolean modifyDriver(DriverBean driverBean);
	public String addRoute(RouteBean routeBean);
	public int deleteRoute(ArrayList<String> routeID);
	public RouteBean viewRoute(String routeID);
    public boolean modifyRoute(RouteBean routeBean);
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination);
	public ArrayList<VehicleBean> viewAllVehicles();
	public ArrayList<DriverBean> viewAllDrivers();
	public ArrayList<RouteBean> viewAllRoutes();
	public DriverBean viewDriver(String driverID);
public ArrayList<ReservationBean> showAllReservations();
public ReservationBean viewReservation(String reservationID);

	

}



