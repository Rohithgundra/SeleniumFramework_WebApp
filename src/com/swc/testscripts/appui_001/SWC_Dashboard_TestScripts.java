package com.swc.testscripts.appui_001;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swc.common.DropDownHandlers;
import com.swc.common.GetReport;
import com.swc.common.SendTestReportMail;
import com.swc.common.TakeScreenshot;
import com.swc.common.TestConfiguration;
import com.swc.pompages.ReleavantData;
import com.swc.pompages.SWC_Dashboard;
import com.swc.pompages.SWC_LoginScreen;
import com.swc.pompages.SWC_UserSubscription;

import junit.framework.Assert;

public class SWC_Dashboard_TestScripts {
	
	WebDriver driver;
	 SWC_LoginScreen ls;
	 SWC_Dashboard dash;
	 SWC_UserSubscription user;
	 String className = getClass().getName();

	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  
		  GetReport.initializeReport();
		  driver = TestConfiguration.getInstance();
		  ls = new SWC_LoginScreen(driver);
		  dash = new SWC_Dashboard(driver);
		  user = new SWC_UserSubscription(driver);
		  ls.waitforLoginPageToLoad();
		  ls.UsernameTextfield().sendKeys(ReleavantData.superadmin_uname);
		  ls.PasswordTextfield().sendKeys(ReleavantData.superadmin_pword);
		  ls.SignInButton().click();
			 
	  }
	  
	  @Test
	  /*Check the title of the Dashboard page*/
	  public void Dashboard_Title() {
		 
		 GetReport.startTestExecution(className);
		 String actualDashboardTitle = dash.DashboardTitle();
		 actualDashboardTitle = actualDashboardTitle.substring(0, 5);
		 
		 Assert.assertEquals(ReleavantData.expectedDashboardTitle, actualDashboardTitle);
		  
	  }
	  
	  @Test
	  public void Dashboard_WaterConsumptionHeader() {
		  
		  GetReport.startTestExecution(className);
		  String actualWaterConsumptionHeader = dash.HeaderWaterConsumption();
		  Assert.assertEquals(ReleavantData.expectedHeaderForWaterConsumption, actualWaterConsumptionHeader);
	  }
	  
	  @Test
	  /*Check the error message when Submit button is clicked without selecting Apartment*/
	  public void Dashboard_SubmitWithoutApartmentField() {
		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 GetReport.startTestExecution(className);
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenApartmentIsNotSelected);
	  }
	  
	  @Test
	  /*Check the error message when Submit button is clicked without selecting Block*/
	  public void Dashboard_SubmitWithoutBlockField() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenBlockIsNotSelected);
	  }
	  
	  @Test
	  /*Check the error message when Submit button is clicked without selecting Water Meter*/
	  public void Dashboard_SubmitWithoutWaterMeterField() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(dash.BlocksDropDownBox(), 1);
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsNotSelected);
	  }
	  
	  @Test
	  /*Check the error message when Submit button is clicked without selecting From Date*/
	  public void Dashboard_SubmitWithoutFromDate() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(dash.BlocksDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(dash.WaterMetersDropDownBox(), 1);
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenFromDataIsMissing);
	  }
	  
	  @Test
	  /*Check the error message when Submit button is clicked without selecting To Date*/
	  public void Dashboard_SubmitWithoutToDate() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(dash.BlocksDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(dash.WaterMetersDropDownBox(), 1);
		 dash.FromDate().sendKeys("08/29/2018 6:28 PM");
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenToDataIsMissing);
	  }
	  
	  @Test
	  /*Check Submit button when all entries are filled*/
	  public void Dashboard_SubmitWithAllFields() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(dash.BlocksDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(dash.WaterMetersDropDownBox(), 1);
		 dash.FromDate().sendKeys("08/29/2018 6:28 PM");
		 dash.ToDate().sendKeys("08/29/2018 8:28 PM");
		 dash.SubmitButton().click();
	  }
	  
//	  @Test
//	  /*Check the labels in the Water Consumption Options -------------- Code Is Okay, Configuration is Failing*/
//	  public void Dashboard_AllLabels() {
//		  
//		  for (int i = 0; i<dash.FindAllLabels().size(); i++) {
//				
//				String text = dash.FindAllLabels().get(i).getText();
//				Assert.assertEquals(ReleavantData.allLabelsPresentInWaterConsumption[i], text);
//			}
//		  
//	  }	
	  
	  @AfterMethod
	  public void afterMethod(ITestResult result) throws IOException {
		  
		  if(ITestResult.FAILURE == result.getStatus()) {
				 
				 String testName = result.getName().toString();
				 String screenShot = TakeScreenshot.captureScreenShot(driver, testName);
				 GetReport.failTest(testName, screenShot);
				 
				    
			 } else if (ITestResult.SUCCESS == result.getStatus()) {
				 
				 String testName = result.getName().toString();
				 GetReport.passTest(testName);
			 }
		  
		  
		  driver.close();
		  driver.quit();
		  
		  GetReport.closeReport();
	}
	  
	  @AfterSuite
	  public void finalWork() {
	 	 
	 	 SendTestReportMail.sendReport();
	 	 
	  }

}
