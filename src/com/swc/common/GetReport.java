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
		
		htmlReporter = new ExtentHtmlReporter(extenReports_path);
		htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
//		extent.loadConfig(new File(".\\extent-config.xml"));
		
		
	}
	
	public static void startTestExecution(String classname) {
		
		test = extent.createTest(classname);
		
	}
	
	public static void passTest(String testName) {
		
		test.pass("Test Case is passed " + testName);
	}
	
	public static void failTest(String testName, String screenshot) throws IOException {
		
		test.fail("Following Test Case is failed  " + testName, MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
	}
	
	public static void closeReport() {
		
		extent.flush();
	}
}
