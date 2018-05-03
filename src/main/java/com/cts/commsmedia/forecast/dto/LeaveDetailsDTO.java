package com.cts.commsmedia.forecast.dto;

public class LeaveDetailsDTO {
	
	private int leave_id;
	private String leave_type;
	private String associate_id;
	private int noofdays;
	private String month_name;
	private String fromdate;
	private String todate;
	private int totalhours;
	private int workinghours;
	private int location_id;
	private String crnumber;
	private String grouping;
	private float rate;
	private int totalworkingdays;
	private String allocation_percentage;
	private java.sql.Timestamp fromdate_timestamp;
	private java.sql.Timestamp todate_timestamp;
	private String locationid;	

	
	/**
	 * @return the leave_id
	 */
	public int getLeave_id() {
		return leave_id;
	}
	/**
	 * @param leave_id the leave_id to set
	 */
	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}
	/**
	 * @return the leave_type
	 */
	public String getLeave_type() {
		return leave_type;
	}
	/**
	 * @param leave_type the leave_type to set
	 */
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	/**
	 * @return the associate_id
	 */
	public String getAssociate_id() {
		return associate_id;
	}
	/**
	 * @param associate_id the associate_id to set
	 */
	public void setAssociate_id(String associate_id) {
		this.associate_id = associate_id;
	}
	/**
	 * @return the noofdays
	 */
	public int getNoofdays() {
		return noofdays;
	}
	/**
	 * @param noofdays the noofdays to set
	 */
	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}
	/**
	 * @return the month_name
	 */
	public String getMonth_name() {
		return month_name;
	}
	/**
	 * @param month_name the month_name to set
	 */
	public void setMonth_name(String month_name) {
		this.month_name = month_name;
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
	 * @return the totalhours
	 */
	public int getTotalhours() {
		return totalhours;
	}
	/**
	 * @param totalhours the totalhours to set
	 */
	public void setTotalhours(int totalhours) {
		this.totalhours = totalhours;
	}
	/**
	 * @return the workinghours
	 */
	public int getWorkinghours() {
		return workinghours;
	}
	/**
	 * @param workinghours the workinghours to set
	 */
	public void setWorkinghours(int workinghours) {
		this.workinghours = workinghours;
	}
	/**
	 * @return the location_id
	 */
	public int getLocation_id() {
		return location_id;
	}
	/**
	 * @param location_id the location_id to set
	 */
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	/**
	 * @return the crnumber
	 */
	public String getCrnumber() {
		return crnumber;
	}
	/**
	 * @param crnumber the crnumber to set
	 */
	public void setCrnumber(String crnumber) {
		this.crnumber = crnumber;
	}
	/**
	 * @return the grouping
	 */
	public String getGrouping() {
		return grouping;
	}
	/**
	 * @param grouping the grouping to set
	 */
	public void setGrouping(String grouping) {
		this.grouping = grouping;
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
	 * @return the totalworkingdays
	 */
	public int getTotalworkingdays() {
		return totalworkingdays;
	}
	/**
	 * @param totalworkingdays the totalworkingdays to set
	 */
	public void setTotalworkingdays(int totalworkingdays) {
		this.totalworkingdays = totalworkingdays;
	}
	/**
	 * @return the allocation_percentage
	 */
	public String getAllocation_percentage() {
		return allocation_percentage;
	}
	/**
	 * @param allocation_percentage the allocation_percentage to set
	 */
	public void setAllocation_percentage(String allocation_percentage) {
		this.allocation_percentage = allocation_percentage;
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
	
	public String getLocationid() {
		return locationid;
	}
	
	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}
}
