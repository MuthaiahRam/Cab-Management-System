package com.xyz.ata.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.ata.bean.DriverBean;
import com.xyz.ata.bean.ReservationBean;
import com.xyz.ata.bean.RouteBean;
import com.xyz.ata.bean.VehicleBean;
import com.xyz.ata.dao.AtaAdminDAO;
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)

public class AdministratorImpl implements Administrator{
@Autowired
AtaAdminDAO ataDAO;

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addDriver(DriverBean driverBean) {
		return ataDAO.addDriver(driverBean);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addRoute(RouteBean routeBean) {
		return ataDAO.addRoute(routeBean);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addVehicle(VehicleBean vehicleBean) {
		return ataDAO.addVehicle(vehicleBean);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean allotDriver(String reservationID, String driverID) {
		return ataDAO.allotDriver(reservationID, driverID);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int deleteDriver(ArrayList<String> driverID) {
		return ataDAO.deleteDriver(driverID);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int deleteRoute(ArrayList<String> routeID) {
		return ataDAO.deleteRoute(routeID);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int deleteVehicle(ArrayList<String> vehicleID) {
		return ataDAO.deleteVehicle(vehicleID);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean modifyDriver(DriverBean driverBean) {
		return ataDAO.modifyDriver(driverBean);
		
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean modifyRoute(RouteBean routeBean) {
		return ataDAO.modifyRoute(routeBean);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean modifyVehicle(VehicleBean vehicleBean) {
		return ataDAO.modifyVehicle(vehicleBean);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,
			String source, String destination) {
		return ataDAO.viewBookingDetails(journeyDate, source, destination);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public RouteBean viewRoute(String routeID) {
		return ataDAO.viewRoute(routeID);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public VehicleBean viewVehicle(String vehicleID) {
		return ataDAO.viewVehicle(vehicleID);
	}


	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<VehicleBean> viewAllVehicles() {
		return ataDAO.viewAllVehicles();
	}



	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<DriverBean> viewAllDrivers() {
		return ataDAO.viewAllDrivers();
	}


	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<RouteBean> viewAllRoutes() {
		return ataDAO.viewAllRoutes();
	}



	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public DriverBean viewDriver(String driverID) {
		return ataDAO.viewDriver(driverID);
	}


	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<ReservationBean> showAllReservations() {
		return ataDAO.showAllReservations();
	}


	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ReservationBean viewReservation(String reservationID) {
		return ataDAO.viewReservation(reservationID);
	}

}
