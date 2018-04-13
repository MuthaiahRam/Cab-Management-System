package com.xyz.ata.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.ata.bean.ReservationBean;
import com.xyz.ata.bean.RouteBean;
import com.xyz.ata.bean.VehicleBean;
import com.xyz.ata.dao.AtaCustomerDAO;
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class CustomerImpl implements Customer{
@Autowired
AtaCustomerDAO ataCustomerDAO;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String bookVehicle(ReservationBean reservationBean) {
		return ataCustomerDAO.bookVehicle(reservationBean);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean cancelBooking(String userID, String reservationID) {
		return ataCustomerDAO.cancelBooking(userID, reservationID);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ReservationBean printBookingDetails(String reservationID) {
		return ataCustomerDAO.printBookingDetails(reservationID);
	}

	
	

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ReservationBean viewBookingDetails(String reservationID) {
		return ataCustomerDAO.viewBookingDetails(reservationID);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats) {
		return ataCustomerDAO.viewVehicleBySeats(noOfSeats);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<VehicleBean> viewVehiclesByType(String vehicleType) {
		return ataCustomerDAO.viewVehiclesByType(vehicleType);
	}


	public double getFare(RouteBean routeBean, String vehicleID) {
		return ataCustomerDAO.getFare(routeBean, vehicleID);
	}


	public RouteBean getRoute(ReservationBean reservationBean) {
		return ataCustomerDAO.getRoute(reservationBean);
	}


	public ArrayList<ReservationBean> viewAllReservations(String userID) {
		return ataCustomerDAO.viewAllReservations(userID);
	}

}
