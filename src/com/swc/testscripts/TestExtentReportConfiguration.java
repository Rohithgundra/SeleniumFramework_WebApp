package com.swc.testscripts;

import org.testng.annotations.Test;

import com.swc.common.GetReport;
import com.swc.common.TakeScreenshot;
import com.swc.common.TestConfiguration;

import com.swc.pompages.SWC_LoginScreen;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

	public class ReportTest {
		
		  WebDriver driver;
		  SWC_LoginScreen ls;
		  String className = getClass().getName();
		  
	  @Test
	  public void sampleTest() {
		 
		  GetReport.startTestExecution(className);
		  driver.findElement(By.id("UN0")).sendKeys("uname");
		  
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
				 String screenShot = TakeScreenshot.captureScreenShot(driver, testName);
				 GetReport.failTest(testName, screenShot);
				 
				    
			 }
		  
		  driver.close();
		  
		  GetReport.closeReport();
	  }
	  
	}
		  



