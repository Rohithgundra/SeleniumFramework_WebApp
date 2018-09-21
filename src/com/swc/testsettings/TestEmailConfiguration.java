package com.swc.testsettings;

import java.io.IOException;
import java.lang.reflect.Method;

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

		  ls.UsernameTextfield().sendKeys("uswm");
		  ls.PasswordTextfield().sendKeys("6"); 
		  
	  }

	 
 @BeforeMethod
 public void beforeMethod(Method method) throws IOException {
	  
	  GetReport.initializeReport();
	  driver = TestConfiguration.getInstance();
	  ls = new SWC_LoginScreen(driver);
	  String testName = method.getName();
	  String testDescription = method.getAnnotation(Test.class).testName();
	  GetReport.startTestExecution(testName, testDescription );
	  
 
 }

 @AfterMethod
 public void afterMethod(ITestResult result) throws IOException {
	  
		
	  if(ITestResult.FAILURE == result.getStatus()) {
			 
			 String testName = result.getName().toString();
			 String screenShot = TakeScreenshot.captureScreenShot(driver, testName);
			 GetReport.failTest(testName, screenShot);
			 GetReport.failTestException(result.getThrowable());
			 
			    
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
