package com.cts.commsmedia.forecast.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.commsmedia.forecast.dto.UserDetailsDto;
import com.cts.commsmedia.forecast.model.UserDetailsScreenVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;

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
		.append("is_billable as billing_status,rfl.location_id,rfl.location_name,is_onsite as location_type,rfl.geo,rfl.sub_location,rfl.daily_hours ")
		.append("from rf_associate_master rfam,rf_location rfl ")
		.append("where rfam.location_group_name = rfl.location_id ")
		.append("and associate_id = ?");
		@SuppressWarnings("unchecked")
		UserDetailsVO userDetailsVO = (UserDetailsVO) jdbcTemplate.queryForObject(sql.toString(), new Object[] { username },
				new UserDetailsRowMapper());
		return userDetailsVO;
	}
	
	
	public UserDetailsScreenVO getLocationDetails() {
		UserDetailsDto usesDetails = null;
		UserDetailsScreenVO userPojo = new UserDetailsScreenVO();
		ArrayList<UserDetailsDto> retBeanList = new ArrayList<UserDetailsDto>();
		try {
			String query = "select location_id,location_name from rf_location where location_id < 4";
			List<Map<String, Object>> retList = jdbcTemplate.queryForList(query);
			if (retList.size() != 0) {
				for (Map value : retList) {
					usesDetails = new UserDetailsDto();
					usesDetails.setLocation_id(value.get("location_id").toString());
					usesDetails.setLocationName((String) value.get("location_name"));
					retBeanList.add(usesDetails);
				}
			}
			userPojo.setLocation_list(retBeanList);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return userPojo;
	}
	
}
