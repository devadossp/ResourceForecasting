package com.cts.commsmedia.forecast.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cts.commsmedia.forecast.model.UserDetailsVO;
import com.cts.commsmedia.forecast.utils.RFConstants;

public class BaseController {

	/**
	 * @return Returns the current logged in user userDetails.If session is
	 *         not set then null will be returned.
	 */
	protected UserDetailsVO getUserDetails(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserDetailsVO userDetailsVO = null;
		if (session != null && session.getAttribute(RFConstants.SESSION_USER_DETAILS) != null) {
			userDetailsVO = (UserDetailsVO) session.getAttribute(RFConstants.SESSION_USER_DETAILS);
		}
		return userDetailsVO;
	}
}
