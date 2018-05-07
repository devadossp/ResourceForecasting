package com.cts.commsmedia.forecast.model;

import java.io.Serializable;
import java.util.List;

public class RateCardDetailsVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rateCardId;
	private String skillName;
	private String geography;
	private String department;
	private float ratePerHour;
	private String onsite;
	private String fromDate;
	private String toDate;
	private List deptList;
	private List skillList;
	private List locationList;
    private String noOfDays;
    private String totalHrs;
    private String workingHrs;
	
	/**
	 * @return the rateCardId
	 */
	public String getRateCardId() {
		return rateCardId;
	}
	/**
	 * @param rateCardId the rateCardId to set
	 */
	public void setRateCardId(String rateCardId) {
		this.rateCardId = rateCardId;
	}
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
	 * @return the geography
	 */
	public String getGeography() {
		return geography;
	}
	/**
	 * @param geography the geography to set
	 */
	public void setGeography(String geography) {
		this.geography = geography;
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
	 * @return the ratePerHour
	 */
	public float getRatePerHour() {
		return ratePerHour;
	}
	/**
	 * @param ratePerHour the ratePerHour to set
	 */
	public void setRatePerHour(float ratePerHour) {
		this.ratePerHour = ratePerHour;
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
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the deptList
	 */
	public List getDeptList() {
		return deptList;
	}
	/**
	 * @param deptList the deptList to set
	 */
	public void setDeptList(List deptList) {
		this.deptList = deptList;
	}
	/**
	 * @return the skillList
	 */
	public List getSkillList() {
		return skillList;
	}
	/**
	 * @param skillList the skillList to set
	 */
	public void setSkillList(List skillList) {
		this.skillList = skillList;
	}
	/**
	 * @return the locationList
	 */
	public List getLocationList() {
		return locationList;
	}
	/**
	 * @param locationList the locationList to set
	 */
	public void setLocationList(List locationList) {
		this.locationList = locationList;
	}
	/**
	 * @return the noOfDays
	 */
	public String getNoOfDays() {
		return noOfDays;
	}
	/**
	 * @param noOfDays the noOfDays to set
	 */
	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}
	/**
	 * @return the totalHrs
	 */
	public String getTotalHrs() {
		return totalHrs;
	}
	/**
	 * @param totalHrs the totalHrs to set
	 */
	public void setTotalHrs(String totalHrs) {
		this.totalHrs = totalHrs;
	}
	/**
	 * @return the workingHrs
	 */
	public String getWorkingHrs() {
		return workingHrs;
	}
	/**
	 * @param workingHrs the workingHrs to set
	 */
	public void setWorkingHrs(String workingHrs) {
		this.workingHrs = workingHrs;
	}
	
	
}