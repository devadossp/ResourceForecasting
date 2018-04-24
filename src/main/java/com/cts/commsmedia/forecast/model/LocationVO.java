package com.cts.commsmedia.forecast.model;

import java.io.Serializable;
import java.util.HashMap;

public class LocationVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int locationId;
    private String locationName;
    private String locationType;
    private String geo;
    private int subLocation;
    private int dailyHours;
    private HashMap<String, Integer> monthly_working_days;
    
	/**
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}
	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return the locationType
	 */
	public String getLocationType() {
		return locationType;
	}
	/**
	 * @param locationType the locationType to set
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	/**
	 * @return the geo
	 */
	public String getGeo() {
		return geo;
	}
	/**
	 * @param geo the geo to set
	 */
	public void setGeo(String geo) {
		this.geo = geo;
	}
	/**
	 * @return the subLocation
	 */
	public int getSubLocation() {
		return subLocation;
	}
	/**
	 * @param subLocation the subLocation to set
	 */
	public void setSubLocation(int subLocation) {
		this.subLocation = subLocation;
	}
	/**
	 * @return the dailyHours
	 */
	public int getDailyHours() {
		return dailyHours;
	}
	/**
	 * @param dailyHours the dailyHours to set
	 */
	public void setDailyHours(int dailyHours) {
		this.dailyHours = dailyHours;
	}
	/**
	 * @return the monthly_working_days
	 */
	public HashMap<String, Integer> getMonthly_working_days() {
		return monthly_working_days;
	}
	/**
	 * @param monthly_working_days the monthly_working_days to set
	 */
	public void setMonthly_working_days(HashMap<String, Integer> monthly_working_days) {
		this.monthly_working_days = monthly_working_days;
	}
		
}
