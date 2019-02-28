package com.couponworld.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class constants {
	public static String dbfilepath = "//C:/Users/russi/eclipse-workspace-web/coupons/src/main/webapp/resources/data/Database1.accdb";
	public static String className = "net.ucanaccess.jdbc.UcanaccessDriver";
	public static String dbName = "jdbc:ucanaccess:" + dbfilepath;
	public static String filepath = "//C:/Users/russi/eclipse-workspace-web/coupons/src/main/webapp/resources/data/coupons.txt";
	
	public static Date convertToDate(String dt) throws ParseException{
		return new SimpleDateFormat("yyyy-MM-dd").parse(dt);
	}
}
