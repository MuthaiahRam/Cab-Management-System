package com.xyz.ata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name=" ATA_TBL_Route")
public class RouteBean {
	@Id
	@Column(name="routeId")
	private String routeID;
	@Column(name="Source")
	private String source;
	@Column(name="Destination")
	private String destination;
	@Column(name="Distance")
	private int distance;
	@Column(name="TravelDuration")
	private int travelDuration;
	@Transient
	private boolean checked;
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	/**
	 * @return the routeID
	 */
	public String getRouteID() {
		return routeID;
	}
	/**
	 * @param routeID the routeID to set
	 */
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
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
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	/**
	 * @return the travelDuration
	 */
	public int getTravelDuration() {
		return travelDuration;
	}
	/**
	 * @param travelDuration the travelDuration to set
	 */
	public void setTravelDuration(int travelDuration) {
		this.travelDuration = travelDuration;
	}
	
	

	

}


