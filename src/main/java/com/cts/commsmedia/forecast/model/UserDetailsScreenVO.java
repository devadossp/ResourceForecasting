package com.cts.commsmedia.forecast.model;

import java.io.Serializable;
import java.util.List;

public class UserDetailsScreenVO implements Serializable
{
	private String projectId;
    private String location ;
    private String subLocation ;
    private String assignment ;
    private List location_list;
    private List assignment_list;
    private List sub_location_list;
    private String fullname;
    private String empID;
    private String noOfDays;
    private String selectedMonth;
    private List month_list;
    private String fromDate;
    private String toDate;
    private String totalHrs;
    private String workingHrs;
    
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
	 * @return the subLocation
	 */
	public String getSubLocation() {
		return subLocation;
	}
	/**
	 * @param subLocation the subLocation to set
	 */
	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
	}
	/**
	 * @return the assignment
	 */
	public String getAssignment() {
		return assignment;
	}
	/**
	 * @param assignment the assignment to set
	 */
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	/**
	 * @return the location_list
	 */
	public List getLocation_list() {
		return location_list;
	}
	/**
	 * @param location_list the location_list to set
	 */
	public void setLocation_list(List location_list) {
		this.location_list = location_list;
	}
	/**
	 * @return the assignment_list
	 */
	public List getAssignment_list() {
		return assignment_list;
	}
	/**
	 * @param assignment_list the assignment_list to set
	 */
	public void setAssignment_list(List assignment_list) {
		this.assignment_list = assignment_list;
	}
	/**
	 * @return the sub_location_list
	 */
	public List getSub_location_list() {
		return sub_location_list;
	}
	/**
	 * @param sub_location_list the sub_location_list to set
	 */
	public void setSub_location_list(List sub_location_list) {
		this.sub_location_list = sub_location_list;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the empID
	 */
	public String getEmpID() {
		return empID;
	}
	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(String empID) {
		this.empID = empID;
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
	 * @return the selectedMonth
	 */
	public String getSelectedMonth() {
		return selectedMonth;
	}
	/**
	 * @param selectedMonth the selectedMonth to set
	 */
	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}
	/**
	 * @return the month_list
	 */
	public List getMonth_list() {
		return month_list;
	}
	/**
	 * @param month_list the month_list to set
	 */
	public void setMonth_list(List month_list) {
		this.month_list = month_list;
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