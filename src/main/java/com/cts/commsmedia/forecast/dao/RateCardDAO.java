package com.cts.commsmedia.forecast.dao;

import com.cts.commsmedia.forecast.dto.RateCardDetailsDTO;
import com.cts.commsmedia.forecast.model.RateCardDetailsVO;

public interface RateCardDAO {

	RateCardDetailsVO getDeptDetails(RateCardDetailsVO rateCardDetailsVO);

	RateCardDetailsVO getSkillDetails();

	int saveRateCardDetails(RateCardDetailsDTO rateCardDetailsDTO);

	
}
