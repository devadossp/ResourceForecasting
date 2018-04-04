package com.cts.commsmedia.forecast.utils;

public class StringUtil {
	
	public static boolean isNullOrEmpty(String s) {
		if ((s == null) || (s.length() == 0)) {
			return true;
		}

		return false;
	}
	
	public static boolean isNullOrEmptyTrim(String s) {
		if (s == null) {
			return true;
		}

		s = s.trim();
		if (s.length() == 0) {
			return true;
		}

		return false;
	}
}
