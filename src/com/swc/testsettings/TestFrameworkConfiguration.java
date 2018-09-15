package com.swc.testsettings;

import org.testng.annotations.Test;

import com.swc.common.DataHandlers;
import com.swc.common.LogHandler;
import com.swc.common.TakeScreenshot;
import com.swc.common.TestConfiguration;
import com.swc.pompages.SWC_LoginScreen;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

	public class TestFrameworkConfiguration {
		
		  WebDriver driver;
		  TakeScreenshot tsr;
		  SWC_LoginScreen ls;
		  String uname = DataHandlers.readExcel("Login", 2, 0);
		  String className = getClass().getName();
		  
	  @Test
	  public void sampleTest() {
		 

		  driver.findElement(By.id("UN0")).sendKeys("uname");
		  
	  }
	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  
		  driver = TestConfiguration.getInstance();
		  ls = new SWC_LoginScreen(driver);
		  LogHandler.getLogs(className);
		  
	  }

	  @AfterMethod
	  public void afterMethod(ITestResult result) throws IOException {
		  
		  if(ITestResult.FAILURE == result.getStatus()) {
				 
				 String testName = result.getName().toString();
				 TakeScreenshot.captureScreenShot(driver, testName);
				 DataHandlers.writeIntoExcel("Login", 2, 5, "FAILED");
				 LogHandler.logInfo("Error found");
				 LogHandler.logError("Failed");
				    
			 }
		  
		  driver.close();
	  }
	  
	}
		  



