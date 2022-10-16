package com.tmb.utils;

public class RandomUtils {
//business layer
	private RandomUtils() {}
	
	public static int getId() {
	
		return FakerUtils.getNumber(10, 10000);
	}
	
	public static String getFirstName() {
		return FakerUtils.getFirstName().toLowerCase();
	}
	
	public static String getLastName() {
		return FakerUtils.getLastName().toLowerCase();
	}	
}
