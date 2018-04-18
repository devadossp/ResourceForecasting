package com.cts.commsmedia.forecast.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.commsmedia.forecast.model.AssociateVO;
import com.cts.commsmedia.forecast.model.LocationVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;
import com.cts.commsmedia.forecast.utils.RFConstants;

@SuppressWarnings("rawtypes")
public class UserDetailsRowMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetailsVO userDetailsVO = new UserDetailsVO();
		AssociateVO associateVO = new AssociateVO();
		LocationVO locationVO = new LocationVO();
		
		userDetailsVO.setValidUser(true);
		userDetailsVO.setAccountName(rs.getString(RFConstants.ACCOUNT));
		associateVO.setAssociateId(rs.getString(RFConstants.ASSOCIATE_ID));
		associateVO.setAssociateName(rs.getString(RFConstants.ASSOCIATE_NAME));
		associateVO.setAssociateRole(rs.getString(RFConstants.ASSOCIATE_ROLE));
		associateVO.setProjectId(rs.getString(RFConstants.PROJECT_ID));
		associateVO.setProjectName(rs.getString(RFConstants.PROJECT_NAME));
		associateVO.setRatePerHour(rs.getFloat(RFConstants.RATE_PER_HOUR));
		associateVO.setRateCardRole(rs.getString(RFConstants.RATE_CARD_ROLE));
		associateVO.setCrnumber(rs.getString(RFConstants.CR_NUMBER));
		associateVO.setAllocationPercentage(rs.getInt(RFConstants.ALLOCATION_PERCENTAGE));
		associateVO.setStatus(rs.getString(RFConstants.STATUS));
		associateVO.setBillingStatus(rs.getString(RFConstants.BILLING_STATUS));
		userDetailsVO.setAssociateDetails(associateVO);
		
		locationVO.setLocationId(rs.getInt(RFConstants.LOCATION_ID));
		locationVO.setLocationName(rs.getString(RFConstants.LOCATION_NAME));
		locationVO.setLocationType(rs.getString(RFConstants.LOCATION_TYPE));
		locationVO.setGeo(rs.getString(RFConstants.GEO));
		locationVO.setSubLocation(rs.getInt(RFConstants.SUB_LOCATION));
		locationVO.setDailyHours(rs.getInt(RFConstants.DAILY_HOURS));
		userDetailsVO.setLocationDetails(locationVO);
		
		return userDetailsVO;
	}
}
