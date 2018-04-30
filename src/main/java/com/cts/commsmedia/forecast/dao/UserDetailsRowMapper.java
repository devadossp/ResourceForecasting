package com.cts.commsmedia.forecast.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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
		associateVO.setGroupingName(rs.getString(RFConstants.GROUPING_NAME));
		userDetailsVO.setAssociateDetails(associateVO);
		
		locationVO.setLocationId(rs.getInt(RFConstants.LOCATION_ID));
		locationVO.setLocationName(rs.getString(RFConstants.LOCATION_NAME));
		locationVO.setLocationType(rs.getString(RFConstants.LOCATION_TYPE));
		locationVO.setGeo(rs.getString(RFConstants.GEO));
		locationVO.setSubLocation(rs.getInt(RFConstants.SUB_LOCATION));
		locationVO.setDailyHours(rs.getInt(RFConstants.DAILY_HOURS));
		locationVO.setMonthly_working_days(mapMonths(rs));
		userDetailsVO.setLocationDetails(locationVO);
		
		return userDetailsVO;
	}
	
	private HashMap<String, Integer> mapMonths(ResultSet rs) {
		HashMap<String, Integer> months = new HashMap<String, Integer>();
		String location_id = RFConstants.EMPTY_STRING;
		try {
			location_id = String.valueOf(rs.getInt(RFConstants.LOCATION_ID));
			location_id = RFConstants.UNDER_SCORE + location_id;
			months.put(RFConstants.MONTHS.JANUARY + location_id, new Integer(rs.getInt(RFConstants.MONTHS.JANUARY)));
			months.put(RFConstants.MONTHS.FEBRUARY + location_id, new Integer(rs.getInt(RFConstants.MONTHS.FEBRUARY)));
			months.put(RFConstants.MONTHS.MARCH + location_id, new Integer(rs.getInt(RFConstants.MONTHS.MARCH)));
			months.put(RFConstants.MONTHS.APRIL + location_id, new Integer(rs.getInt(RFConstants.MONTHS.APRIL)));
			months.put(RFConstants.MONTHS.MAY + location_id, new Integer(rs.getInt(RFConstants.MONTHS.MAY)));
			months.put(RFConstants.MONTHS.JUNE + location_id, new Integer(rs.getInt(RFConstants.MONTHS.JUNE)));
			months.put(RFConstants.MONTHS.JULY + location_id, new Integer(rs.getInt(RFConstants.MONTHS.JULY)));
			months.put(RFConstants.MONTHS.AUGUST + location_id, new Integer(rs.getInt(RFConstants.MONTHS.AUGUST)));
			months.put(RFConstants.MONTHS.SEPTEMBER + location_id,
					new Integer(rs.getInt(RFConstants.MONTHS.SEPTEMBER)));
			months.put(RFConstants.MONTHS.OCTOBER + location_id, new Integer(rs.getInt(RFConstants.MONTHS.OCTOBER)));
			months.put(RFConstants.MONTHS.NOVEMBER + location_id, new Integer(rs.getInt(RFConstants.MONTHS.NOVEMBER)));
			months.put(RFConstants.MONTHS.DECEMBER + location_id, new Integer(rs.getInt(RFConstants.MONTHS.DECEMBER)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return months;
	}
}
