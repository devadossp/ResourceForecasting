package com.cts.commsmedia.forecast.dto;

import java.util.List;

public class RateCardDetailsDTO {
	
	private String skillName;
	private String fromdate;
	private String todate;
	private String location;
	private String department;
	private float rate;
	private String onsite;
	private String projectId;
	private String projectName;
	private java.sql.Timestamp fromdate_timestamp;
	private java.sql.Timestamp todate_timestamp;
	private int rateValue;
	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}
	/**
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	/**
	 * @return the fromdate
	 */
	public String getFromdate() {
		return fromdate;
	}
	/**
	 * @param fromdate the fromdate to set
	 */
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	/**
	 * @return the todate
	 */
	public String getTodate() {
		return todate;
	}
	/**
	 * @param todate the todate to set
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the rate
	 */
	public float getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
	/**
	 * @return the onsite
	 */
	public String getOnsite() {
		return onsite;
	}
	/**
	 * @param onsite the onsite to set
	 */
	public void setOnsite(String onsite) {
		this.onsite = onsite;
	}
	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the fromdate_timestamp
	 */
	public java.sql.Timestamp getFromdate_timestamp() {
		return fromdate_timestamp;
	}
	/**
	 * @param fromdate_timestamp the fromdate_timestamp to set
	 */
	public void setFromdate_timestamp(java.sql.Timestamp fromdate_timestamp) {
		this.fromdate_timestamp = fromdate_timestamp;
	}
	/**
	 * @return the todate_timestamp
	 */
	public java.sql.Timestamp getTodate_timestamp() {
		return todate_timestamp;
	}
	/**
	 * @param todate_timestamp the todate_timestamp to set
	 */
	public void setTodate_timestamp(java.sql.Timestamp todate_timestamp) {
		this.todate_timestamp = todate_timestamp;
	}
	/**
	 * @return the rateValue
	 */
	public int getRateValue() {
		return rateValue;
	}
	/**
	 * @param rateValue the rateValue to set
	 */
	public void setRateValue(int rateValue) {
		this.rateValue = rateValue;
	}
	}
