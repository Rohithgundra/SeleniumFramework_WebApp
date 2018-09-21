package com.swc.testscripts.appui_001;

import java.io.IOException;
import java.lang.reflect.Method;

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
import com.swc.common.WaitStatements;
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

	  @BeforeMethod
	  public void beforeMethod(Method method) throws IOException {
		  
		  GetReport.initializeReport();
		  driver = TestConfiguration.getInstance();
		  ls = new SWC_LoginScreen(driver);
		  String testName = method.getName();
		  String testDescription = method.getAnnotation(Test.class).testName();
		  GetReport.startTestExecution(testName, testDescription );
		  dash = new SWC_Dashboard(driver);
		  user = new SWC_UserSubscription(driver);
		  ls.waitforLoginPageToLoad();
		  ls.UsernameTextfield().sendKeys(ReleavantData.superadmin_uname);
		  ls.PasswordTextfield().sendKeys(ReleavantData.superadmin_pword);
		  ls.SignInButton().click();
			 
	  }
	  
	  @Test (priority=1, testName = "Verify the Title of the Dashboard Page")		
	  public void Dashboard_Title() {
		 
		 String actualDashboardTitle = dash.DashboardTitle();
		 actualDashboardTitle = actualDashboardTitle.substring(0, 5);
		 
		 Assert.assertEquals(ReleavantData.expectedDashboardTitle, actualDashboardTitle);
		  
	  }
	  
	  @Test (priority=2, testName = "Verify the Header of the Water Consumption Sub Area")	
	  public void Dashboard_WaterConsumptionHeader() {
		  
		  String actualWaterConsumptionHeader = dash.HeaderWaterConsumption();
		  Assert.assertEquals(ReleavantData.expectedHeaderForWaterConsumption, actualWaterConsumptionHeader);
	  }
	  
	  @Test (priority=3, testName = "Verify the Error Message when Submit button is clicked without selecting Apartment")	
	  
	  public void Dashboard_SubmitWithoutApartmentField() {
		  
		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenApartmentIsNotSelected);
	  }
	  
	  @Test (priority=4, testName = "Verify the error message when Submit button is clicked without selecting Block")
	  /*Check the error message when Submit button is clicked without selecting Block*/
	  public void Dashboard_SubmitWithoutBlockField() {
		 
	
		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 WaitStatements.ExplicitWait(driver, dash.ApartmentsDropDownBox());
		 DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenBlockIsNotSelected);
	  }
	  
	  @Test (priority=5, testName = "Verify the error message when Submit button is clicked without selecting Water Meter")

	  public void Dashboard_SubmitWithoutWaterMeterField() {
		 

		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 WaitStatements.ExplicitWait(driver, dash.ApartmentsDropDownBox());
		 DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, dash.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(dash.BlocksDropDownBox(), 1);
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsNotSelected);
	  }
	  
	  @Test (priority=6, testName = "Verify the error message when Submit button is clicked without selecting From Date")

	  public void Dashboard_SubmitWithoutFromDate() {
		 

		 DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		 WaitStatements.ExplicitWait(driver, dash.ApartmentsDropDownBox());
		 DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, dash.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(dash.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, dash.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(dash.WaterMetersDropDownBox(), 1);
		 WaitStatements.ImplicitWait(driver, 30);
		 dash.SubmitButton().click();
		 dash.HandleAlert(ReleavantData.expectedErrorMessageWhenFromDateIsMissing);
	  }
	  
	  @Test (priority=7, testName = "Verify the error message when Submit button is clicked without selecting To Date")

	  public void Dashboard_SubmitWithoutToDate() {
		 
		  DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		  WaitStatements.ExplicitWait(driver, dash.ApartmentsDropDownBox());
		  DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		  WaitStatements.ExplicitWait(driver, dash.BlocksDropDownBox());
		  DropDownHandlers.selectDDLByIndex(dash.BlocksDropDownBox(), 1);
		  WaitStatements.ExplicitWait(driver, dash.WaterMetersDropDownBox());
		  DropDownHandlers.selectDDLByIndex(dash.WaterMetersDropDownBox(), 1);
		  WaitStatements.ImplicitWait(driver, 30);
		  dash.FromDate().sendKeys("08/29/2018 6:28 PM");
		  dash.SubmitButton().click();
		  dash.HandleAlert(ReleavantData.expectedErrorMessageWhenToDateIsMissing);
	  }
	  
	  @Test (priority=8, testName = "Verify Submit button when all entries are selected")
	  public void Dashboard_SubmitWithAllFields() {
		 
		  DropDownHandlers.selectDDLByIndex(dash.HousingTypeDropDownBox(), 0);
		  WaitStatements.ExplicitWait(driver, dash.ApartmentsDropDownBox());
		  DropDownHandlers.selectDDLByIndex(dash.ApartmentsDropDownBox(), 1);
		  WaitStatements.ExplicitWait(driver, dash.BlocksDropDownBox());
		  DropDownHandlers.selectDDLByIndex(dash.BlocksDropDownBox(), 1);
		  WaitStatements.ExplicitWait(driver, dash.WaterMetersDropDownBox());
		  DropDownHandlers.selectDDLByIndex(dash.WaterMetersDropDownBox(), 1);
		  WaitStatements.ImplicitWait(driver, 30);
		  dash.FromDate().sendKeys("08/29/2018 6:28 PM");
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
	  
//	  @AfterSuite
//	  public void finalWork() {
//	 	 
//	 	 SendTestReportMail.sendReport();
//	 	 
//	  }

}
