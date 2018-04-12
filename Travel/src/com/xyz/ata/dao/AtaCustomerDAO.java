package com.xyz.ata.dao;

import java.util.ArrayList;

import com.xyz.ata.bean.ReservationBean;
import com.xyz.ata.bean.RouteBean;
import com.xyz.ata.bean.VehicleBean;

public interface AtaCustomerDAO {
	
	public ArrayList<VehicleBean> viewVehiclesByType(String vehicleType);
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats);
	
	public String bookVehicle(ReservationBean reservationBean);
	public boolean cancelBooking(String userID, String reservationID);
	public ReservationBean viewBookingDetails(String reservationID);
	public ReservationBean printBookingDetails(String reservationID);
	public long getReservationID();
	public double getFare(RouteBean routeBean,String vehicleID) ;
	public RouteBean getRoute(ReservationBean reservationBean);
	public ArrayList<ReservationBean> viewAllReservations(String userID);
}
