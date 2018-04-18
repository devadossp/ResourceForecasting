package com.cts.commsmedia.forecast.model;

import java.io.Serializable;

public class UserDetailsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String accountName;
	private AssociateVO associateVO;
	private LocationVO locationVO;
	private boolean validUser;

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	/**
	 * @return Returns the associateDetails
	 */
	public AssociateVO getAssociateDetails() {
		return associateVO;
	}
	
	/**
	 * @param associateDetails
	 * The associateDetails to set.
	 */
	public void setAssociateDetails(AssociateVO associateVO) {
		this.associateVO = associateVO;
	}
	
	/**
	 * @return Returns the locationDetails
	 */
	public LocationVO getLocationDetails() {
		return locationVO;
	}
	
	/**
	 * @param locationDetails
	 * The locationDetails to set.
	 */
	public void setLocationDetails(LocationVO locationVO) {
		this.locationVO = locationVO;
	}

	/**
	 * @return the validUser
	 */
	public boolean isValidUser() {
		return validUser;
	}

	/**
	 * @param validUser the validUser to set
	 */
	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}
}
