package com.cts.commsmedia.forecast.dto;

import java.util.List;

public class RateCardDetailsDTO {
	
	private String associate_id;
	private String fromdate;
	private String todate;
	private int location_id;
	private String department;
	private String crnumber;
	private float rate;
	private java.sql.Timestamp fromdate_timestamp;
	private java.sql.Timestamp todate_timestamp;
	private List deptList;
	private List skillList;
	private List locationList;
	public String getAssociate_id() {
		return associate_id;
	}
	public void setAssociate_id(String associate_id) {
		this.associate_id = associate_id;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCrnumber() {
		return crnumber;
	}
	public void setCrnumber(String crnumber) {
		this.crnumber = crnumber;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public java.sql.Timestamp getFromdate_timestamp() {
		return fromdate_timestamp;
	}
	public void setFromdate_timestamp(java.sql.Timestamp fromdate_timestamp) {
		this.fromdate_timestamp = fromdate_timestamp;
	}
	public java.sql.Timestamp getTodate_timestamp() {
		return todate_timestamp;
	}
	public void setTodate_timestamp(java.sql.Timestamp todate_timestamp) {
		this.todate_timestamp = todate_timestamp;
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
	
	
}
