/**
 * @author 562750
 *
 */
package com.cts.commsmedia.forecast.dto;

import java.io.Serializable;

public class UserDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String location_id;
	private String locationName;
	private String month_id;
	private String month_name;
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getMonth_id() {
		return month_id;
	}
	public void setMonth_id(String month_id) {
		this.month_id = month_id;
	}
	public String getMonth_name() {
		return month_name;
	}
	public void setMonth_name(String month_name) {
		this.month_name = month_name;
	}
}
