package com.cts.commsmedia.forecast.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("userDao")
public class UserDAOImpl implements UserDAO{
	
    @Autowired
    JdbcTemplate jdbcTemplate;
	
	public boolean isValidUser(String userName, String password) {
	      boolean retVal;
	      try { 
	           String SQL = "select count(*) from forecast_users where username= ? and password = ?";
	          // int count = jdbcTemplate.queryForInt(SQL, new Object[]{userName, password});
	           
	           int count = jdbcTemplate.queryForObject(
	        		   SQL, new Object[] { userName, password }, Integer.class);
	 
	           if (count == 1) {
	                retVal = true;
	           } else {
	                retVal = false;
	           }
	      } catch (Exception ex) { 
	    	  ex.printStackTrace();
	          retVal = false;
	      }
	      return retVal;
	 }

}
