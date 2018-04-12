package com.xyz.ata.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
public class AtaAdminDAOImpl implements AtaAdminDAO {
	@Autowired
	SessionFactory sessionfactory;

	
	public String addDriver(DriverBean driverBean) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.getCurrentSession();
		driverBean.setDriverID(driverBean.getName().substring(0, 2).toUpperCase().concat(String.valueOf(getDriverId())));
		String driverId = (String) session.save(driverBean);
		return driverId;
	}

	
	public boolean allotDriver(String reservationID, String driverID) {
		boolean isAlloted = false;
		Session session = sessionfactory.getCurrentSession();
		ReservationBean reservationBean = (ReservationBean) session.get(
				ReservationBean.class, reservationID);
		DriverBean driverBean=(DriverBean)session.get(DriverBean.class,driverID);
		reservationBean.setDriverID(driverID);
		driverBean.setStatus(reservationBean.getJourneyDate());
		if (isAlloted == false) {
			session.save(reservationBean);
			session.save(driverBean);
			isAlloted = true;
		}
		return isAlloted;
	}


	public int deleteDriver(ArrayList<String> driverID) {
		System.out.println("in delete");
		int count = 0;
		int deleteStatus = 0;
		Session session = sessionfactory.getCurrentSession();
		for (Iterator<String> iterator = driverID.iterator(); iterator
				.hasNext();) {
			DriverBean driverBean = (DriverBean) session.get(DriverBean.class,
					iterator.next().toString());

			session.delete(driverBean);
			count++;

		}
		System.out.println(":"+count);
		if (count == driverID.size()) {
			deleteStatus = 1;
		}
		return deleteStatus;

	}


	public boolean modifyDriver(DriverBean driverBean) {
		boolean isModified = false;
		Session session = sessionfactory.getCurrentSession();
		if (isModified == false) {
			session.update(driverBean);
			isModified = true;
		}
		return isModified;
	}

	@SuppressWarnings("unchecked")
	
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,
			String source, String destination) {
		Session session = sessionfactory.getCurrentSession();
		String hqlRoute = "select routeID from RouteBean where source=:source and destination=:destination";
		Query queryRoute = session.createQuery(hqlRoute);
		queryRoute.setParameter("source", source);
		queryRoute.setParameter("destination", destination);
		String routeId = queryRoute.list().get(0).toString();
		String hql = "From ReservationBean where routeID=:id and journeyDate=:date";
		Query query = session.createQuery(hql);
		query.setParameter("id", routeId);
		query.setParameter("date", new java.sql.Date(journeyDate.getTime()));
		ArrayList<ReservationBean> arrayList = (ArrayList<ReservationBean>) query
				.list();
		return arrayList;

	}


	public String addVehicle(VehicleBean vehicleBean) {
		Session session = sessionfactory.getCurrentSession();
		vehicleBean.setVehicleID(vehicleBean.getName().substring(0, 2).toUpperCase().concat(String.valueOf(getVehicleId())));

		String vehicleId = (String) session.save(vehicleBean);
		return vehicleId;
	}

	
	public int deleteVehicle(ArrayList<String> vehicleID) {
		int deleteStatus = 0;
		int count=0;
		Session session = sessionfactory.getCurrentSession();
		for (Iterator<String> iterator = vehicleID.iterator(); iterator.hasNext();) {
			
			VehicleBean vehicleBean = (VehicleBean) session.get(VehicleBean.class,
					iterator.next().toString());	
			session.delete(vehicleBean);
		count++;
			
		}
		if(count==vehicleID.size())
		{
			deleteStatus=1;
		}
		
		

		return deleteStatus;

	}

	
	public boolean modifyVehicle(VehicleBean vehicleBean) {
		boolean isModified = false;
		Session session = sessionfactory.getCurrentSession();
		if (isModified == false) {
			session.update(vehicleBean);
			isModified = true;
		}

		return isModified;

	}

	@SuppressWarnings("unchecked")

	public VehicleBean viewVehicle(String vehicleID) {
		Session session = sessionfactory.getCurrentSession();

		String hql = "From VehicleBean where vehicleID=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", vehicleID);
		ArrayList<VehicleBean> arrayList = (ArrayList<VehicleBean>) query
				.list();
		return arrayList.get(0);
	}

	public String addRoute(RouteBean routeBean) {
		String result = "";
		String sname = routeBean.getSource();
		String dname = routeBean.getDestination();
		String routeID = ((sname.substring(0, 2).concat(dname.substring(0, 2)))
				.toUpperCase());
		String ID = routeID.concat(String.valueOf(getRouteId()));System.out.println(ID);
		routeBean.setRouteID(ID);System.out.println(routeBean.getRouteID());
		
			result = (String) sessionfactory.getCurrentSession()
					.save(routeBean);
		return result;
	}

	@SuppressWarnings("deprecation")
	
	public long getRouteId() {
		long key = 0L;
		Connection connection = sessionfactory.getCurrentSession().connection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select ATA_SEQ_ROUTEID.nextval from dual");
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
	

	public int deleteRoute(ArrayList<String> routeID) {
		int deleteStatus = 0;
		int count=0;
		for (Iterator<String> iterator = routeID.iterator(); iterator.hasNext();) {
			deleteStatus=0;
			RouteBean bean = (RouteBean) sessionfactory.getCurrentSession()
					.get(RouteBean.class, iterator.next().toString());
			sessionfactory.getCurrentSession().delete(bean);
			count++;
		}
		if(count==routeID.size())
		{
			deleteStatus=1;
		}
		return deleteStatus;
	}
	
	public RouteBean viewRoute(String routeID) {
		RouteBean routeBean = null;
		routeBean = (RouteBean) sessionfactory.getCurrentSession().get(
				RouteBean.class, routeID);
		return routeBean;
		
	}

	@SuppressWarnings("deprecation")
	
	public long getDriverId() {
		long key = 0L;
		Connection connection = sessionfactory.getCurrentSession().connection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select ATA_SEQ_DRIVERID.nextval from dual");
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

	@SuppressWarnings("deprecation")
	
	public long getVehicleId() {
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
	
public boolean modifyRoute(RouteBean routeBean)
	
	{
		boolean modifyStatus=false;
		String modifyId=routeBean.getRouteID();
		try
		{
		RouteBean bean = (RouteBean) sessionfactory.getCurrentSession().get(
				RouteBean.class, modifyId);
		bean.setSource(routeBean.getSource());
		bean.setDestination(routeBean.getDestination());
		bean.setDistance(routeBean.getDistance());
		bean.setTravelDuration(routeBean.getTravelDuration());
		sessionfactory.getCurrentSession().update(bean);
		modifyStatus=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return modifyStatus;
		
	}


@SuppressWarnings("unchecked")

public ArrayList<VehicleBean> viewAllVehicles() {
	ArrayList<VehicleBean> list=new ArrayList<VehicleBean>();
	Session session=sessionfactory.getCurrentSession();
	Query query=session.createQuery("from VehicleBean");
	list=(ArrayList<VehicleBean>) query.list();
	return list;
	
}


@SuppressWarnings("unchecked")

public ArrayList<DriverBean> viewAllDrivers() {
	ArrayList<DriverBean> list=new ArrayList<DriverBean>();
	Session session=sessionfactory.getCurrentSession();
	Query query=session.createQuery("from DriverBean");
	list=(ArrayList<DriverBean>) query.list();
	return list;
}


@SuppressWarnings("unchecked")

public ArrayList<RouteBean> viewAllRoutes() {
	ArrayList<RouteBean> list=new ArrayList<RouteBean>();
	Session session=sessionfactory.getCurrentSession();
	Query query=session.createQuery("from RouteBean");
	list=(ArrayList<RouteBean>) query.list();
	return list;
}


@SuppressWarnings("unchecked")

public DriverBean viewDriver(String driverID) {
	Session session = sessionfactory.getCurrentSession();

	String hql = "From DriverBean where driverID=:id";
	Query query = session.createQuery(hql);
	query.setParameter("id", driverID);
	ArrayList<DriverBean> arrayList = (ArrayList<DriverBean>) query
			.list();
	return arrayList.get(0);
}


@SuppressWarnings("unchecked")
public ArrayList<ReservationBean> showAllReservations() {
	ArrayList<ReservationBean> list=new ArrayList<ReservationBean>();
	Session session=sessionfactory.getCurrentSession();
	Query query=session.createQuery("from ReservationBean");
	
	list=(ArrayList<ReservationBean>) query.list();
	return list;
}



public ReservationBean viewReservation(String reservationID) {
	Session session = sessionfactory.getCurrentSession();

	String hql = "From ReservationBean where reservationID=:id";
	Query query = session.createQuery(hql);
	query.setParameter("id", reservationID);
	@SuppressWarnings("unchecked")
	ArrayList<ReservationBean> arrayList = (ArrayList<ReservationBean>) query
			.list();
	return arrayList.get(0);
}

}
