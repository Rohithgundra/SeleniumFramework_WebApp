package com.swc.testsettings;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swc.common.GetReport;
import com.swc.common.SendTestReportMail;
import com.swc.common.TakeScreenshot;
import com.swc.common.TestConfiguration;
import com.swc.pompages.SWC_LoginScreen;

public class TestEmailConfiguration {
	  WebDriver driver;
	  SWC_LoginScreen ls;
	  String className = getClass().getName();
	  
 @Test
 public void sampleTest() {
	 
	  GetReport.startTestExecution(className);
	  

		  ls.UsernameTextfield().sendKeys("uswm");
		  ls.PasswordTextfield().sendKeys("6"); 
		  
	  }

	 
 @BeforeMethod
 public void beforeMethod() throws IOException {
	  
	  GetReport.initializeReport();
	  driver = TestConfiguration.getInstance();
	  ls = new SWC_LoginScreen(driver);

	  
 }

 @AfterMethod
 public void afterMethod(ITestResult result) throws IOException {
	  
	  if(ITestResult.FAILURE == result.getStatus()) {
			 
			 String testName = result.getName().toString();
			 TakeScreenshot.captureScreenShot(driver, testName);
			 String screenShot = TakeScreenshot.captureScreenShot(driver, testName);
			 GetReport.failTest(testName, screenShot);
		 } else if (ITestResult.SUCCESS == result.getStatus()) {
			 
			 String testName = result.getName().toString();
			 GetReport.passTest(testName);
		 }
	  
	  driver.close();
	  GetReport.closeReport();
 }
 
 @AfterSuite
 public void finalWork() {
	 
	 SendTestReportMail.sendReport();
	 
 }
 
}
