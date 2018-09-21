package com.swc.testscripts.appui_001;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swc.common.DropDownHandlers;
import com.swc.common.GetReport;
import com.swc.common.TakeScreenshot;
import com.swc.common.TestConfiguration;
import com.swc.common.WaitStatements;
import com.swc.pompages.ReleavantData;
import com.swc.pompages.SWC_Dashboard;
import com.swc.pompages.SWC_LoginScreen;
import com.swc.pompages.SWC_RemoveWaterMeter;
import com.swc.pompages.SWC_SyncWaterMeter;

import junit.framework.Assert;

public class SWC_SyncWaterMeter_TestScripts {

	
	 WebDriver driver;
	 SWC_LoginScreen ls;
	 SWC_Dashboard dash;
	 SWC_SyncWaterMeter sync;

	  @BeforeMethod
	  public void beforeMethod(Method method) throws IOException {
		  
		  GetReport.initializeReport();
		  driver = TestConfiguration.getInstance();
		  ls = new SWC_LoginScreen(driver);
		  String testName = method.getName();
		  String testDescription = method.getAnnotation(Test.class).testName();
		  GetReport.startTestExecution(testName, testDescription );
		  dash = new SWC_Dashboard(driver);
		  ls.waitforLoginPageToLoad();
		  ls.UsernameTextfield().sendKeys(ReleavantData.superadmin_uname);
		  ls.PasswordTextfield().sendKeys(ReleavantData.superadmin_pword);
		  ls.SignInButton().click();
		  dash.SyncLink().click();
		  dash.SyncMeterLink().click();
		  sync = new SWC_SyncWaterMeter(driver);
			 
	  }
	  
	  @Test (priority=1, testName = "Verify the title of the SyncWaterMeter page")
	  public void RmWaterMeter_Title() {
		 

		 String actualPageTitle = sync.SyWaterMeterTitle();
		 Assert.assertEquals(ReleavantData.expectedSyncWaterMeterTitle, actualPageTitle);
		  
	  }
	  
	  @Test (priority=2, testName = "Verify the header of the SyncWaterMeter page")
	  public void RmWaterMeter_Header() {
		 
		
		 String actualPageHeader = sync.SyWaterMeterHeader();
		 Assert.assertEquals(ReleavantData.expectedSyncWaterMeterHeader, actualPageHeader);
		  
	  }
	  
	  @Test (priority=3, testName = "Verify the error message when Sync button is clicked without selecting Apartment")
	  public void SyncWaterMeter_SyncWithoutApartmentField() {
		 DropDownHandlers.selectDDLByIndex(sync.HousingTypeDropDownBox(), 0);
		 sync.SyncButton().click();
		 WaitStatements.ExplicitWaitForAlert(driver);
		 
		 try {
			 boolean actualflag = sync.AlertPresence();
			 Assert.assertTrue(actualflag);
			 sync.HandleAlert(ReleavantData.expectedErrorMessageWhenApartmentIsNotSelected);
				
			 
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
	  }
	  
	  @Test (priority=4, testName = "Verify the error message when Sync button is clicked without selecting Block")
	  public void SyncWaterMeter_SyncWithoutBlockField() {
		 

		 DropDownHandlers.selectDDLByIndex(sync.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(sync.ApartmentsDropDownBox(), "Unizen");
		 sync.SyncButton().click();
		 WaitStatements.ExplicitWaitForAlert(driver);
			 
		 try {
			 boolean actualflag = sync.AlertPresence();
			 Assert.assertTrue(actualflag);
			 sync.HandleAlert(ReleavantData.expectedErrorMessageWhenBlockIsNotSelected);
			 
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
	  }
	  
	  @Test (priority=5, testName = "Verify the error message when Sync button is clicked when no Water Meter is present")
	  public void SyncWaterMeter_BlockSelection() {
		 

		 DropDownHandlers.selectDDLByIndex(sync.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(sync.ApartmentsDropDownBox(), "Unizen");
		 DropDownHandlers.selectDDLByIndex(sync.BlocksDropDownBox(), 1);
	
		 try {
			 boolean actualflag = sync.AlertPresence();
			 Assert.assertFalse(actualflag);
			 
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
		
	 }
	  
	  @Test (priority=6, testName = "Verify the error message when Sync button is clicked without selecting Water Meter")
	  public void SyncWaterMeter_SyncWithoutWaterMeter() throws InterruptedException {
		 
		 DropDownHandlers.selectDDLByIndex(sync.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(sync.ApartmentsDropDownBox(), "ApartmentWithoutWaterMeters");
		 DropDownHandlers.selectDDLByIndex(sync.BlocksDropDownBox(), 1);
		 
		 try {
			 boolean actualflag = sync.AlertPresence();
			 Assert.assertFalse(actualflag);
					 
				 try {
					 
					 sync.SyncButton().click();
					 boolean actualflag1 = sync.AlertPresence();
					 Assert.assertTrue(actualflag1);
					 sync.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsNotSelected);
						
					
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
				
			 
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
		 
	  }
	  
	  @Test(priority=7, testName = "Verify Water Meter can be Synced")
	  public void SyncWaterMeter_SelectAllAndSync() {
		  
		  DropDownHandlers.selectDDLByIndex(sync.HousingTypeDropDownBox(), 0);
		  DropDownHandlers.selectDDLByVisibleText(sync.ApartmentsDropDownBox(), "Unizen");
		  DropDownHandlers.selectDDLByIndex(sync.BlocksDropDownBox(), 1);
		  DropDownHandlers.selectDDLByIndex(sync.WaterMetersDropDownBox(), 1);
		  
		  try {
			  
			  boolean actualflag = sync.AlertPresence();
			  Assert.assertFalse(actualflag);
			  sync.SyncButton().click();
			  
		  }catch (Exception e) {
			  
			  e.printStackTrace();
		  }
		  
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
				 
		  } else if (ITestResult.SKIP == result.getStatus()) {
				 
				 String testName = result.getName().toString();
				 GetReport.passTest(testName);
				 
		  }
		  
		  
		  driver.close();
		  driver.quit();
		  
		  GetReport.closeReport();
	}
}
