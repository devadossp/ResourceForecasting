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
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSubLocation() {
		return subLocation;
	}
	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public List getLocation_list() {
		return location_list;
	}
	public void setLocation_list(List location_list) {
		this.location_list = location_list;
	}
	public List getAssignment_list() {
		return assignment_list;
	}
	public void setAssignment_list(List assignment_list) {
		this.assignment_list = assignment_list;
	}
	public List getSub_location_list() {
		return sub_location_list;
	}
	public void setSub_location_list(List sub_location_list) {
		this.sub_location_list = sub_location_list;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getSelectedMonth() {
		return selectedMonth;
	}
	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}
	public List getMonth_list() {
		return month_list;
	}
	public void setMonth_list(List month_list) {
		this.month_list = month_list;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getTotalHrs() {
		return totalHrs;
	}
	public void setTotalHrs(String totalHrs) {
		this.totalHrs = totalHrs;
	}
	public String getWorkingHrs() {
		return workingHrs;
	}
	public void setWorkingHrs(String workingHrs) {
		this.workingHrs = workingHrs;
	}
    
}