package com.cts.commsmedia.forecast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cts.commsmedia.forecast.dto.LeaveDetailsDTO;
import com.cts.commsmedia.forecast.dto.UserDetailsDto;
import com.cts.commsmedia.forecast.model.UserDetailsScreenVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;
import com.cts.commsmedia.forecast.utils.CommonUtils;
import com.cts.commsmedia.forecast.utils.RFConstants;

@Repository
@Qualifier("userDao")
public class UserDAOImpl implements UserDAO{
	
    @Autowired
    JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 */
	public UserDetailsVO isValidUser(String userName, String password) {
		UserDetailsVO userDetailsVO = new UserDetailsVO();
		try {
			String SQL = "select count(1) from rf_associate_master where associate_id= ? and password = ?";

			int count = jdbcTemplate.queryForObject(SQL, new Object[] { userName, password }, Integer.class);

			if (count == 1) {
				userDetailsVO = fetchUserDetails(userName);
			} else {
				userDetailsVO.setValidUser(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			userDetailsVO.setValidUser(false);
		}
		return userDetailsVO;
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public UserDetailsVO fetchUserDetails(String username) {
		StringBuffer sql = new StringBuffer();
		sql.append("select rfam.account,associate_id,associate_name,grade_name as associate_role,rfam.project_id,")
				.append("project_name,rate_per_hour,rate_card_role,cr_number,allocation_percentage,is_active as status,")
				.append("is_billable as billing_status,grouping_name,rfl.location_id,rfl.location_name,location_type,rfl.geo,rfl.sub_location,")
				.append("rfl.daily_hours,rfl.january,rfl.february,rfl.march,rfl.april,rfl.may,rfl.june,rfl.july,rfl.august,rfl.september,")
				.append("rfl.october,rfl.november,rfl.december ")
				.append("from rf_associate_master rfam,rf_location rfl ")
				.append("where rfam.location_id = rfl.location_id ")
				.append("and associate_id = ? and rfl.year=2018");
		@SuppressWarnings("unchecked")
		UserDetailsVO userDetailsVO = (UserDetailsVO) jdbcTemplate.queryForObject(sql.toString(),
				new Object[] { username }, new UserDetailsRowMapper());
		return userDetailsVO;
	}
	
	
	public UserDetailsScreenVO getLocationDetails() {
		UserDetailsDto usesDetails = null;
		UserDetailsScreenVO userPojo = new UserDetailsScreenVO();
		ArrayList<UserDetailsDto> retBeanList = new ArrayList<UserDetailsDto>();
		String Current_Month = CommonUtils.getMonth(RFConstants.CURRENT_MONTH, RFConstants.MONTHS.NAME);
		String Next_Month = CommonUtils.getMonth(RFConstants.NEXT_MONTH, RFConstants.MONTHS.NAME);
		StringBuffer sql = new StringBuffer();
		try {
			sql.append("select location_id||'|'||daily_hours||'|'||"+Current_Month+"||'|'||"+Next_Month+" as location_details,")
			.append("location_name from rf_location where location_id <> 3");
			List<Map<String, Object>> retList = jdbcTemplate.queryForList(sql.toString());
			if (retList.size() != 0) {
				for (Map value : retList) {
					usesDetails = new UserDetailsDto();
					usesDetails.setLocation_id(value.get(RFConstants.LOCATION_DETAILS).toString());
					usesDetails.setLocationName((String) value.get(RFConstants.LOCATION_NAME));
					retBeanList.add(usesDetails);
				}
			}
			userPojo.setLocation_list(retBeanList);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return userPojo;
	}
	
	public int insertLeaveDetails(LeaveDetailsDTO leaveDetailsDTO) {
		final StringBuffer sql = new StringBuffer();
		int rows = 0;
		try {
			sql.append(
					"INSERT into RF_LEAVE_DETAILS(LEAVE_ID, LEAVE_TYPE, LOCATION_ID, ASSOCIATE_ID, CR_NUMBER, GROUPING_NAME, TOTAL_HOURS_PER_MONTH,")
					.append("TOTAL_WORKING_DAYS, CURRENT_MONTH, WORKING_HOURS, RATE, FROM_DATE, TO_DATE, NO_OF_DAYS_LEAVE) ")
					.append("VALUES (rf_leave_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			rows = jdbcTemplate.update(sql.toString(),
					new Object[] { leaveDetailsDTO.getLeave_type(), leaveDetailsDTO.getLocation_id(),
							leaveDetailsDTO.getAssociate_id(), leaveDetailsDTO.getCrnumber(),
							leaveDetailsDTO.getGrouping(), leaveDetailsDTO.getTotalhours(),
							leaveDetailsDTO.getTotalworkingdays(), leaveDetailsDTO.getMonth_name(),
							leaveDetailsDTO.getWorkinghours(), leaveDetailsDTO.getRate(),
							leaveDetailsDTO.getFromdate_timestamp(), leaveDetailsDTO.getTodate_timestamp(),
							leaveDetailsDTO.getNoofdays() });

		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		return rows;
	}
	
public List getLeaveDetails(String associate_id) {
		
		String Current_Month = CommonUtils.getMonth(RFConstants.CURRENT_MONTH, RFConstants.MONTHS.NAME);
		String Next_Month = CommonUtils.getMonth(RFConstants.NEXT_MONTH, RFConstants.MONTHS.NAME);		
		List leaveDetails=new ArrayList();
		
		StringBuffer forecastSqlQuery = new StringBuffer();			
		forecastSqlQuery.append("select rl.location_id||'|'||rl.daily_hours||'|'||"+Current_Month+"||'|'||"+Next_Month+" as location_details,rld.* From Rf_Leave_Details Rld, Rf_Location Rl")
				 .append(" Where Rld.Location_Id=Rl.Location_Id And associate_id=? and")
		.append(" to_char(from_date,'MON YYYY')=to_char(ADD_MONTHS(sysdate,1),'MON YYYY') and LEAVE_TYPE='F'");
		@SuppressWarnings("unchecked")
		List forecastLeaveDetails = (List) jdbcTemplate.query(forecastSqlQuery.toString(), new Object[] { associate_id },
				new leaveDetailsRowMapper());
		
		leaveDetails.add(forecastLeaveDetails);
		
		StringBuffer actualSqlQuery = new StringBuffer();			
		actualSqlQuery.append("select rl.location_id||'|'||rl.daily_hours||'|'||"+Current_Month+"||'|'||"+Next_Month+" as location_details,rld.* From Rf_Leave_Details Rld, Rf_Location Rl")
				 .append(" Where Rld.Location_Id=Rl.Location_Id And associate_id=? and")
		.append(" to_char(from_date,'MON YYYY')=to_char(ADD_MONTHS(sysdate,-1),'MON YYYY') and LEAVE_TYPE in ('A','F')");
		@SuppressWarnings("unchecked")
		List actualLeaveDetails = (List) jdbcTemplate.query(actualSqlQuery.toString(), new Object[] { associate_id },
				new leaveDetailsRowMapper());
		
		leaveDetails.add(actualLeaveDetails);
		
	return leaveDetails;
	}

}
