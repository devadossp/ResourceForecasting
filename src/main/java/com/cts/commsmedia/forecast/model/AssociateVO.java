package com.cts.commsmedia.forecast.model;

import java.io.Serializable;

public class AssociateVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String associateId;
	private String associateName;
	private String password;
	private String associateRole;
	private String projectId;
	private String projectName;
	private float ratePerHour;
	private String crnumber;
	private int allocationPercentage;
	private String rateCardRole;
	private String status;
	private String billingStatus;
	
	/**
	 * @return the associateId
	 */
	public String getAssociateId() {
		return associateId;
	}
	/**
	 * @param associateId the associateId to set
	 */
	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}
	/**
	 * @return the associateName
	 */
	public String getAssociateName() {
		return associateName;
	}
	/**
	 * @param associateName the associateName to set
	 */
	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the associateRole
	 */
	public String getAssociateRole() {
		return associateRole;
	}
	/**
	 * @param associateRole the associateRole to set
	 */
	public void setAssociateRole(String associateRole) {
		this.associateRole = associateRole;
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
	 * @return the allocationPercentage
	 */
	public int getAllocationPercentage() {
		return allocationPercentage;
	}
	/**
	 * @param allocationPercentage the allocationPercentage to set
	 */
	public void setAllocationPercentage(int allocationPercentage) {
		this.allocationPercentage = allocationPercentage;
	}
	/**
	 * @return the rateCardRole
	 */
	public String getRateCardRole() {
		return rateCardRole;
	}
	/**
	 * @param rateCardRole the rateCardRole to set
	 */
	public void setRateCardRole(String rateCardRole) {
		this.rateCardRole = rateCardRole;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the billingStatus
	 */
	public String getBillingStatus() {
		return billingStatus;
	}
	/**
	 * @param billingStatus the billingStatus to set
	 */
	public void setBillingStatus(String billingStatus) {
		this.billingStatus = billingStatus;
	}
	
	
}
