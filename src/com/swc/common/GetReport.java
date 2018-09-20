package com.swc.common;

import java.io.IOException;



import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class GetReport implements RelativePath {
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test;
	WebDriver driver;
	
	
	public static void initializeReport() {
		
		htmlReporter = new ExtentHtmlReporter(extentReports_path);
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo(System.getProperty("os.name"), System.getProperty("os.version"));
		extent.setSystemInfo("Browser Type", DataHandlers.getDataFromPropertyFile("browser"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
//		extent.loadConfig(new File(".\\extent-config.xml"));
				
	}
	
	public static void startTestExecution(String testName, String description) {

		test = extent.createTest(testName, description);
		
	}
	
	public static void passTest(String testName) {
		
		test.pass(testName + " Test Case is PASSED");
		
	}
	
	public static void skipTest(String testName) {
		
		test.skip(testName + " Test Case is SKIPPED");
		
	}
	
	public static void failTest(String testName, String screenshot) throws IOException {
		
		test.fail(testName + " Test Case is FAILED", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		
	}
	
	public static void failTestException(Throwable throwable) {
		
		test.fail(throwable);
	}
	
	public static void closeReport() {
		
		extent.flush();
	}

}
