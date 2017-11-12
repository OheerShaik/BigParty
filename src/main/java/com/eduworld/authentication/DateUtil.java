package com.eduworld.authentication;

import java.util.Date;

public abstract class DateUtil {
	
	static Date date = null;
	
	
	
	
	public static Long getTimeInMills(){
		date = new Date();
		return date.getTime();
		
	}
	
	public static Long getTimeNext15MinInMills() {
		date = new Date(System.currentTimeMillis()+15*60*1000);
		return date.getTime();
	}
	
	
	
	
	
	
	

}
