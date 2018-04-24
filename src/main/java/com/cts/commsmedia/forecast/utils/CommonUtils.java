package com.cts.commsmedia.forecast.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {
	
	public static String getMonth(String whichMonth, String type) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		month += 1;
		
		if (RFConstants.NEXT_MONTH.equalsIgnoreCase(whichMonth)) {
			month += 1;
		}
		return ((type.equalsIgnoreCase(RFConstants.MONTHS.NAME)) ? getMonthName(month) : String.valueOf(month));
	}
	
	private static String getMonthName(int month)
	{
		String month_name;
		switch (month){
		case 1:
			month_name = RFConstants.MONTHS.JANUARY;
			break;
		case 2:
			month_name = RFConstants.MONTHS.FEBRUARY;
			break;
		case 3:
			month_name = RFConstants.MONTHS.MARCH;
			break;
		case 4:
			month_name = RFConstants.MONTHS.APRIL;
			break;
		case 5:
			month_name = RFConstants.MONTHS.MAY;
			break;
		case 6:
			month_name = RFConstants.MONTHS.JUNE;
			break;
		case 7:
			month_name = RFConstants.MONTHS.JULY;
			break;
		case 8:
			month_name = RFConstants.MONTHS.AUGUST;
			break;
		case 9:
			month_name = RFConstants.MONTHS.SEPTEMBER;
			break;
		case 10:
			month_name = RFConstants.MONTHS.OCTOBER;
			break;
		case 11:
			month_name = RFConstants.MONTHS.NOVEMBER;
			break;
		default:
			month_name = RFConstants.MONTHS.DECEMBER;
			break;
		}
		return month_name;
	}
	
	public static Timestamp convertStringToTimestamp(String str_date) {
		try {
			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = (Date) formatter.parse(str_date);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
			return timeStampDate;
		} catch (ParseException e) {
			return null;
		}
	}
}
