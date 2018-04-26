package com.cts.commsmedia.forecast.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.commsmedia.forecast.dto.DepartmentlDetailsDTO;
import com.cts.commsmedia.forecast.dto.SkillDetailsDTO;
import com.cts.commsmedia.forecast.model.RateCardDetailsVO;

@Repository
@Qualifier("rateCardDao")
public class RateCardDAOImpl implements RateCardDAO{
	
    @Autowired
    JdbcTemplate jdbcTemplate;
	
	
	
	public RateCardDetailsVO getDeptDetails() {
		DepartmentlDetailsDTO departmentlDetailsDTO = null;
		RateCardDetailsVO rateCardPojo = new RateCardDetailsVO();
		ArrayList<DepartmentlDetailsDTO> retBeanList = new ArrayList<DepartmentlDetailsDTO>();
		StringBuffer sql = new StringBuffer();
		try {
			sql.append("select department_ID,")
			.append("department_NAME from RF_DEPARTMENT_MASTER");
			List<Map<String, Object>> retList = jdbcTemplate.queryForList(sql.toString());
			if (retList.size() != 0) {
				for (Map value : retList) {
					departmentlDetailsDTO = new DepartmentlDetailsDTO();
					departmentlDetailsDTO.setDept_id(value.get("department_ID").toString());
					departmentlDetailsDTO.setDept_name((String) value.get("department_NAME"));
					retBeanList.add(departmentlDetailsDTO);
				}
			}
			rateCardPojo.setDeptList(retBeanList);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return rateCardPojo;
	}

	public RateCardDetailsVO getSkillDetails() {
		SkillDetailsDTO skillDetailsDTO = null;
		RateCardDetailsVO rateCardPojo = new RateCardDetailsVO();
		ArrayList<SkillDetailsDTO> retBeanList = new ArrayList<SkillDetailsDTO>();
		
		StringBuffer sql = new StringBuffer();
		try {
			sql.append("select skill_id,")
			.append("skill_name from RF_SKILL_MASTER");
			List<Map<String, Object>> retList = jdbcTemplate.queryForList(sql.toString());
			if (retList.size() != 0) {
				for (Map value : retList) {
					skillDetailsDTO = new SkillDetailsDTO();
					skillDetailsDTO.setSkill_id(value.get("skill_id").toString());
					skillDetailsDTO.setSkill_name((String) value.get("skill_name"));
					retBeanList.add(skillDetailsDTO);
				}
			}
			rateCardPojo.setSkillList(retBeanList);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return rateCardPojo;
	}
}
