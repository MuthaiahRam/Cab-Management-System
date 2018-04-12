package com.xyz.ata.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xyz.ata.bean.DriverBean;
import com.xyz.ata.bean.ReservationBean;
import com.xyz.ata.bean.RouteBean;
import com.xyz.ata.bean.VehicleBean;
@Repository
public class AtaCustomerDAOImpl implements AtaCustomerDAO {
@Autowired
SessionFactory sessionfactory;
	
	public String bookVehicle(ReservationBean reservationBean) {
		reservationBean.setReservationID(String.valueOf(getReservationID()));
		Session session=sessionfactory.getCurrentSession();
		String hqlRoute = "select routeID from RouteBean where source=:source and destination=:destination";
		Query queryRoute = session.createQuery(hqlRoute);
		queryRoute.setParameter("source", reservationBean.getBoardingPoint());
		queryRoute.setParameter("destination", reservationBean.getDropPoint());
		String routeId = queryRoute.list().get(0).toString();
		reservationBean.setRouteID(routeId);
		System.out.println(":"+reservationBean.getBoardingPoint()+reservationBean.getVehicleID()+reservationBean.getReservationID()+":");
		String reservationID=(String) session.save(reservationBean);
		if(reservationID!=null)
		{
			Query query=session.createQuery("from VehicleBean where vehicleID=:id");
			query.setParameter("id",reservationBean.getVehicleID());
			VehicleBean vehicleBean=(VehicleBean) query.list().get(0);
			vehicleBean.setStatus(reservationBean.getJourneyDate());
			session.saveOrUpdate(vehicleBean);
			
		}
		return reservationID;

		
		
	

	
		
	}

	
	public boolean cancelBooking(String userID, String reservationID) {
		boolean cancelStatus=false;
		String hqlCancel = "from ReservationBean where userID=:userID and reservationID=:reservationID";
		Query queryCancel = sessionfactory.getCurrentSession().createQuery(hqlCancel);
		queryCancel.setParameter("userID", userID);
		queryCancel.setParameter("reservationID", reservationID);
		ReservationBean reservationBean=(ReservationBean) queryCancel.list().get(0);
	    sessionfactory.getCurrentSession().delete(reservationBean);
	    Session session=sessionfactory.getCurrentSession();
	    Query query=session.createQuery("from DriverBean where driverID=:id");
	    query.setParameter("id",reservationBean.getDriverID());
	    DriverBean driverBean=(DriverBean) query.list().get(0);
	    driverBean.setStatus(null);
	    session.saveOrUpdate(driverBean);
	    Query vehiclequery=session.createQuery("from VehicleBean where vehicleID=:id");
	    vehiclequery.setParameter("id",reservationBean.getVehicleID());
	    VehicleBean vehicleBean= (VehicleBean) vehiclequery.list().get(0);
	    vehicleBean.setStatus(null);
	    session.saveOrUpdate(vehicleBean);
	    
	    
	    
	    cancelStatus=true;
	    return cancelStatus;
	}

	
	public ReservationBean printBookingDetails(String reservationID) {
		ReservationBean reservationBean = (ReservationBean) sessionfactory.getCurrentSession().get(
				ReservationBean.class, reservationID);
		return reservationBean;
	}
	
	
	

	
	public ReservationBean viewBookingDetails(String reservationID) {
		ReservationBean reservationBean = (ReservationBean) sessionfactory.getCurrentSession().get(
				ReservationBean.class, reservationID);
		return reservationBean;
	}

	@SuppressWarnings("unchecked")
	
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats) {
		Session session=sessionfactory.getCurrentSession();
		String hql="from VehicleBean where seatingCapacity=:seatingCapacity";
		Query query=session.createQuery(hql);
		query.setParameter("seatingCapacity",noOfSeats);
		ArrayList<VehicleBean> arrayList=(ArrayList<VehicleBean>) query.list();
		return arrayList;
	}

	@SuppressWarnings("unchecked")
	
	public ArrayList<VehicleBean> viewVehiclesByType(String vehicleType) {
		Session session=sessionfactory.getCurrentSession();
		String hql="from VehicleBean where type=:type";
		Query query=session.createQuery(hql);
		query.setParameter("type",vehicleType);
		ArrayList<VehicleBean> arrayList=(ArrayList<VehicleBean>) query.list();
		return arrayList;
	}
	@SuppressWarnings("deprecation")
	
	public long getReservationID() {
		long key = 0L;
		Connection connection = sessionfactory.getCurrentSession().connection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select ATA_SEQ_VEHICLEID.nextval from dual");
			if (rs.next()) {
				key = Long.parseLong(rs.getString(1));

			}
		} catch (NumberFormatException eNumForm) {
			return 0;

		} catch (SQLException eSQL) {
			return 0;
		}
		return key;
	}
	public double getFare(RouteBean routeBean,String vehicleID) {
		Session session=sessionfactory.getCurrentSession();
		Query getFare=session.createSQLQuery("select FarePerKM from ATA_TBL_Vehicle where vehicleId=:id");
		getFare.setParameter("id",vehicleID);
		double fare=Double.valueOf(getFare.list().get(0).toString());
		return routeBean.getDistance()*fare;

	}

public RouteBean getRoute(ReservationBean reservationBean) {
		Session session=sessionfactory.getCurrentSession();
		Query fetchRoute=session.createQuery("from RouteBean where source=:source and destination=:destination");
		fetchRoute.setParameter("source",reservationBean.getBoardingPoint());
		fetchRoute.setParameter("destination",reservationBean.getDropPoint());
		if(fetchRoute.list().size()>0)
		{
        return (RouteBean) fetchRoute.list().get(0);
		}
		else
		{
			return null;
		}
	}


@SuppressWarnings("unchecked")
public ArrayList<ReservationBean> viewAllReservations(String userID) {
	ArrayList<ReservationBean> list=new ArrayList<ReservationBean>();
	Session session=sessionfactory.getCurrentSession();
	Query query=session.createQuery("from ReservationBean where userID=:id");
	query.setParameter("id",userID);
	list=(ArrayList<ReservationBean>) query.list();
	return list;
}
}
