package com.cts.commsmedia.forecast.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.cts.commsmedia.forecast.dto.LeaveDetailsDTO;
import com.cts.commsmedia.forecast.model.AssociateVO;
import com.cts.commsmedia.forecast.model.LocationVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;
import com.cts.commsmedia.forecast.utils.RFConstants;

public class leaveDetailsRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		LeaveDetailsDTO leaveDetailsVO = new LeaveDetailsDTO();
		
		
		leaveDetailsVO.setAssociate_id(rs.getString(RFConstants.ASSOCIATE_ID));
		leaveDetailsVO.setNoofdays(rs.getInt("NO_OF_DAYS_LEAVE"));
		leaveDetailsVO.setFromdate(rs.getString("FROM_DATE"));
		leaveDetailsVO.setTodate(rs.getString("TO_DATE"));
		leaveDetailsVO.setTotalworkingdays(rs.getInt("TOTAL_WORKING_DAYS"));
		leaveDetailsVO.setWorkinghours(rs.getInt("WORKING_HOURS"));
		leaveDetailsVO.setLocationid(rs.getString("location_details"));
		
		
		return leaveDetailsVO;
	}

}
