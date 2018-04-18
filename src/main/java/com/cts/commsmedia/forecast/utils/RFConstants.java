package com.cts.commsmedia.forecast.utils;

public class RFConstants {
	
	public static interface DATABASE {
		public static final String JDBC_DRIVER_CLASS_NAME = "jdbc.driverClassName";
		public static final String JDBC_URL = "jdbc.url";
		public static final String JDBC_USERNAME = "jdbc.username";
		public static final String JDBC_PASSWORD = "jdbc.password";
	}

	public static interface COMMON {
		public static final String CLASSPATH_APP_PROPERTIES = "classpath:application.properties";
		public static final String COM_CTS_COMMSMEDIA = "com.cts.commsmedia";
	}

	public static final String ACCOUNT = "ACCOUNT";
	public static final String ASSOCIATE_ID = "ASSOCIATE_ID";
	public static final String ASSOCIATE_NAME = "ASSOCIATE_NAME";
	public static final String ASSOCIATE_ROLE = "ASSOCIATE_ROLE";
	public static final String PROJECT_ID = "PROJECT_ID";
	public static final String PROJECT_NAME = "PROJECT_NAME";
	public static final String RATE_PER_HOUR = "RATE_PER_HOUR";
	public static final String CR_NUMBER = "CR_NUMBER";
	public static final String ALLOCATION_PERCENTAGE = "ALLOCATION_PERCENTAGE";
	public static final String RATE_CARD_ROLE = "RATE_CARD_ROLE";
	public static final String STATUS = "STATUS";
	public static final String BILLING_STATUS = "BILLING_STATUS";
	public static final String LOCATION_ID = "LOCATION_ID";
	public static final String LOCATION_NAME = "LOCATION_NAME";
	public static final String LOCATION_TYPE = "LOCATION_TYPE";
	public static final String GEO = "GEO";
	public static final String SUB_LOCATION = "SUB_LOCATION";
	public static final String DAILY_HOURS = "DAILY_HOURS";
	
	public static final String SESSION_USER_DETAILS = "userDetailsVO";

	public static interface FORWARDS {
		public static final String LANDING = "landing";
		public static final String LOGIN = "login";
	}

	public static interface RF_REQ_MAPPING {
		public static final String INDEX_URL = "/index";
		public static final String LOGOUT_URL = "/logout";
	}
}
