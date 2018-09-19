package com.swc.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public interface RelativePath {
	
	String Chrome_properties = "webdriver.chrome.driver";
	String Firefox_properties = "webdriver.edge.driver";
	String MicrosoftEdge_properties = "webdriver.edge.driver";
	
	String Chrome_path = ".\\browsers\\chromedriver.exe";
	String Firefox_path = ".\\browsers\\geckodriver.exe";
	String MicrosoftEdge_path = ".\\browsers\\MicrosoftWebDriver.exe";
	
	String config_properties_path = ".\\data\\config.properties";
	String test_data_path = ".\\data\\SWC_TestData.xlsx";
	String log_properties_path = ".\\data\\log4j.properties";
	
	String extentReports_path = ".\\extentReports\\"+ "Reports "+ getDateTime() +".html";
	String testNGReports_path = ".\\test-output\\Regression Suite\\regression.html";

	
	public static String getDateTime() {
		
		DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy_hhmm");
	    df.setTimeZone(TimeZone.getTimeZone("IST"));
		return df.format(new Date());
		
		
	}
	
	public static String getDateTime2() {
		DateFormat df = new SimpleDateFormat("dd MMM yyyy_hhmm");
	    df.setTimeZone(TimeZone.getTimeZone("IST"));
		return df.format(new Date());
	}
}
