package com.swc.common;

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
	
	String extenReports_path = ".\\extentReports\\TestReport.html";

}
