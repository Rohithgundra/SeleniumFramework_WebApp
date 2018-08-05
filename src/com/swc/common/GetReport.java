package com.swc.common;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GetReport implements RelativePath {
	
	static ExtentReports extent;
	static ExtentTest logger;
	WebDriver driver;
	
	public static void initializeReport() {
		
		extent = new ExtentReports(extenReports_path);
//		extent.loadConfig(new File(".\\extent-config.xml"));
		
		
	}
	
	public static void startTestExecution(String classname) {
		
		logger = extent.startTest(classname);
		
	}
	
	public static void passTest() {
		
		logger.log(LogStatus.PASS, "Test Case is passed");
	}
	
	public static void failTest(String testName, String screenshot) {
		
		String image = logger.addScreenCapture(screenshot);
		logger.log(LogStatus.FAIL, "Following Test Case is failed  " + testName, image);
	}
	
	public static void closeReport() {
		
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
