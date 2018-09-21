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

import junit.framework.Assert;


public class SWC_RemoveWaterMeter_TestScripts {

	
	 WebDriver driver;
	 SWC_LoginScreen ls;
	 SWC_Dashboard dash;
	 SWC_RemoveWaterMeter rm;

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
		  dash.DeviceMgmtLink().click();
		  dash.RmWaterMeterLink().click();
		  rm = new SWC_RemoveWaterMeter(driver);
			 
	  }
	  
	  @Test (priority=1, testName = "Verify the title of the RemoveWaterMeter page")
	  public void RmWaterMeter_Title() {
		 

		 String actualPageTitle = rm.RmWaterMeterTitle();
		 Assert.assertEquals(ReleavantData.expectedRmWaterMeterTitle, actualPageTitle);
		  
	  }
	  
	  @Test (priority=2, testName = "Verify the header of the RemoveWaterMeter page")
	  public void RmWaterMeter_Header() {
		 
		
		 String actualPageHeader = rm.RmWaterMeterHeader();
		 Assert.assertEquals(ReleavantData.expectedRmWaterMeterHeader, actualPageHeader);
		  
	  }
	  
	  @Test (priority=3, testName = "Verify the error message when Remove button is clicked without selecting Apartment")
	  public void RmWaterMeter_RemoveWithoutApartmentField() {
		 DropDownHandlers.selectDDLByIndex(rm.HousingTypeDropDownBox(), 0);
		 rm.RemoveButton().click();
		 WaitStatements.ExplicitWaitForAlert(driver);
		 
		 try {
			 boolean actualflag = rm.AlertPresence();
			 Assert.assertTrue(actualflag);
			 rm.HandleAlert(ReleavantData.expectedErrorMessageWhenApartmentIsNotSelected);
				
			 
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
	  }
	  
	  @Test (priority=4, testName = "Verify the error message when Remove button is clicked without selecting Block")
	  public void RmWaterMeter_RemoveWithoutBlockField() {
		 

		 DropDownHandlers.selectDDLByIndex(rm.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(rm.ApartmentsDropDownBox(), "Unizen");
		 rm.RemoveButton().click();
		 WaitStatements.ExplicitWaitForAlert(driver);
			 
		 try {
			 boolean actualflag = rm.AlertPresence();
			 Assert.assertTrue(actualflag);
			 rm.HandleAlert(ReleavantData.expectedErrorMessageWhenBlockIsNotSelected);
			 
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
	  }
	  
	  @Test (priority=5, testName = "Verify the error message when a Block without Water Meter is selected")
	  public void RmWaterMeter_BlockSelection() {
		 

		 DropDownHandlers.selectDDLByIndex(rm.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(rm.ApartmentsDropDownBox(), "Unizen");
		 DropDownHandlers.selectDDLByIndex(rm.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWaitForAlert(driver);
	
		 try {
			 boolean actualflag = rm.AlertPresence();
			 Assert.assertTrue(actualflag);
			 rm.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsNotFound);
			 
			 
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
		
	 }
	  
	  @Test (priority=6, testName = "Verify the error message when Remove button is clicked without selecting Water Meter")
	  public void RmWaterMeter_RemoveWithoutWaterMeterField() throws InterruptedException {
		 
		 DropDownHandlers.selectDDLByIndex(rm.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(rm.ApartmentsDropDownBox(), "Unizen");
		 DropDownHandlers.selectDDLByIndex(rm.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWaitForAlert(driver);
		 
		 try {
			 boolean actualflag = rm.AlertPresence();
			 if (actualflag!=false) {
					 
				 driver.switchTo().alert().dismiss();
				 rm.RemoveButton().click();
				 boolean actualflag1 = rm.AlertPresence();
				 Assert.assertTrue(actualflag1);
				 rm.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsNotSelected);
			 }else {
				 
				 try {
					 rm.RemoveButton().click();
					 boolean actualflag2 = rm.AlertPresence();
					 Assert.assertTrue(actualflag2);
					 rm.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsNotSelected);
						
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
				 
			 }
				
			 
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
	  }
	  
	  @Test(priority=7, testName = "Verify Water Meter can be removed")
	  public void RmWaterMeter_SelectAllAndRemove() {
		  
		  DropDownHandlers.selectDDLByIndex(rm.HousingTypeDropDownBox(), 0);
			 DropDownHandlers.selectDDLByVisibleText(rm.ApartmentsDropDownBox(), "Unizen");
			 DropDownHandlers.selectDDLByIndex(rm.BlocksDropDownBox(), 1);
		  DropDownHandlers.selectDDLByIndex(rm.WaterMetersDropDownBox(), 1);
		  
		  try {
			  
			  boolean actualflag = rm.AlertPresence();
			  Assert.assertFalse(actualflag);
			  rm.RemoveButton().click();
			  
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
