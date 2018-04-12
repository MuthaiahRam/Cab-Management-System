package com.xyz.ata.dao;

import java.util.ArrayList;
import java.util.Date;

import com.xyz.ata.bean.DriverBean;
import com.xyz.ata.bean.ReservationBean;
import com.xyz.ata.bean.RouteBean;
import com.xyz.ata.bean.VehicleBean;

public interface AtaAdminDAO {
	
	public String addDriver(DriverBean driverBean);
	public boolean modifyDriver(DriverBean driverBean);
	public int deleteDriver(ArrayList<String> driverID);
	public boolean allotDriver(String reservationID, String driverID);
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination);
	public String addVehicle(VehicleBean vehicleBean);
	public int deleteVehicle(ArrayList<String> vehicleID);
	public boolean modifyVehicle(VehicleBean vehicleBean);
	public VehicleBean viewVehicle(String vehicleID);
	public DriverBean viewDriver(String driverID);
	public String addRoute(RouteBean routeBean);
	public long getRouteId();
	public long getVehicleId();
	public long getDriverId();
	public int deleteRoute(ArrayList<String> routeID);
	public RouteBean viewRoute(String routeID);
	public boolean modifyRoute(RouteBean routeBean);
	public ArrayList<VehicleBean> viewAllVehicles();
	public ArrayList<DriverBean> viewAllDrivers();
	public ArrayList<RouteBean> viewAllRoutes();
	public ArrayList<ReservationBean> showAllReservations();
	public ReservationBean viewReservation(String reservationID);



	
}
