package com.cts.commsmedia.forecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.commsmedia.forecast.dao.RateCardDAO;
import com.cts.commsmedia.forecast.model.RateCardDetailsVO;

@Service("rateCardService")
public class RateCardServiceImpl implements RateCardService {
	
    @Autowired
    RateCardDAO  rateCardDao;

	public RateCardDetailsVO getSkillDetails(){
		return rateCardDao.getSkillDetails();
	}

	public RateCardDetailsVO getDeptDetails(){
		return rateCardDao.getDeptDetails();
	}
}
