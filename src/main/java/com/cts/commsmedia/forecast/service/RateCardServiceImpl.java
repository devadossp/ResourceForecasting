package com.cts.commsmedia.forecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.commsmedia.forecast.dao.RateCardDAO;
import com.cts.commsmedia.forecast.dto.RateCardDetailsDTO;
import com.cts.commsmedia.forecast.model.RateCardDetailsVO;

@Service("rateCardService")
public class RateCardServiceImpl implements RateCardService {
	
    @Autowired
    RateCardDAO  rateCardDao;

	public RateCardDetailsVO getSkillDetails(){
		return rateCardDao.getSkillDetails();
	}

	public RateCardDetailsVO getDeptDetails(RateCardDetailsVO rateCardDetailsVO){
		return rateCardDao.getDeptDetails(rateCardDetailsVO);
	}
	
	public int saveRateCardDetails(RateCardDetailsDTO rateCardDetailsDTO){
		return rateCardDao.saveRateCardDetails(rateCardDetailsDTO);
	}
}
