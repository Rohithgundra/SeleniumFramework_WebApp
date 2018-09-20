package com.swc.testsettings;

import org.testng.annotations.Test;

import com.swc.common.GetReport;
import com.swc.common.TakeScreenshot;
import com.swc.common.TestConfiguration;

import com.swc.pompages.SWC_LoginScreen;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

	public class TestExtentReportConfiguration {
		
		  WebDriver driver;
		  SWC_LoginScreen ls;
	
	
	  @Test (testName = "Verify valid test case")
	  public void sampleTest() {
		
		  driver.findElement(By.id("uname")).sendKeys("uname");
		  
		  
	  }
	  
	  @Test (testName = "Verify invalid test case")
	  public void failedTest() {
		  
		  driver.findElement(By.id("unam")).sendKeys("uname");
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
//          GetReport.executionDetails();
		  GetReport.closeReport();
	  
	}
	  
}
		  



