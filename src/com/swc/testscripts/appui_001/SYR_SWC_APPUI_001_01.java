package com.swc.testscripts.appui_001;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swc.common.DataHandlers;
import com.swc.common.GetReport;
import com.swc.common.RelativePath;
import com.swc.common.TakeScreenshot;
import com.swc.common.TestConfiguration;
import com.swc.pompages.SWC_LoginScreen;

import junit.framework.Assert;

public class SYR_SWC_APPUI_001_01 implements RelativePath{
	
	 WebDriver driver;
	 SWC_LoginScreen ls;
	 String className = getClass().getName();
	 String sheetName;
	 int rowNum;
	 int cellNum;
	
//  @Test
//  /*Check the title of the Login page*/
//  public void APPUI_001_TC01() {
//	 
//	 GetReport.startTestExecution(className);
//	 String actualPageTitle = ls.LoginScreenTitle();
//	 Assert.assertEquals(expectedPageTitle, actualPageTitle);
//	  
//  }
//  
  @Test
  /*Check the header of the Login page*/
  public void APPUI_001_TC02() {
	 
	 sheetName = "Login";
	 rowNum = 10;
	 cellNum = 2;
	 GetReport.startTestExecution(className);
	 String actualHeader = ls.LoginHeader();
	 Assert.assertEquals(expectedHeader, actualHeader);
	  
  }
  
  @Test
  /*Check the sub headers present in the login page*/
  public void APPUI_001_TC03() {
	 
	 sheetName = "Login";
	 rowNum = 11;
	 cellNum = 5;
	 GetReport.startTestExecution(className);
	 String actualSubHeader = ls.LoginHeader();
	 Assert.assertEquals(expectedSubHeader, actualSubHeader);
	  
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  GetReport.initializeReport();
	  driver = TestConfiguration.getInstance();
	  ls = new SWC_LoginScreen(driver);
	  ls.waitforLoginPageToLoad();
	  
  
  }

  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  
	  if(ITestResult.FAILURE == result.getStatus()) {
			 
			 String testName = result.getName().toString();
			 String screenShot = TakeScreenshot.captureScreenShot(driver, testName);
			 GetReport.failTest(testName, screenShot);
			 DataHandlers.writeIntoExcel(sheetName, rowNum, cellNum, "FAILED");
			 
			    
		 } else if (ITestResult.SUCCESS == result.getStatus()) {
			 
			 String testName = result.getName().toString();
			 GetReport.passTest(testName);
		 }
	  
	  
	  driver.close();
	  driver.quit();
	  
	  GetReport.closeReport();
}
  
}
