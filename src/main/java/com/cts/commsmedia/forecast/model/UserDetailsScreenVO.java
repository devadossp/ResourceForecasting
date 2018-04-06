package com.cts.commsmedia.forecast.model;

import java.io.Serializable;
import java.util.List;

public class UserDetailsScreenVO implements Serializable
{
    private String projectId;
    private String location ;
    private String indiaLocation ;
    private String assignment ;
    private List location_list;
    private List assignment_list;
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
	public String getIndiaLocation() {
		return indiaLocation;
	}
	public void setIndiaLocation(String indiaLocation) {
		this.indiaLocation = indiaLocation;
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
    
}