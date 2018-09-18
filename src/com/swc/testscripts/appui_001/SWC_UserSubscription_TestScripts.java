package com.swc.testscripts.appui_001;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

public class SWC_UserSubscription_TestScripts {
	
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
		  dash.UserMgmtLink().click();
		  dash.UserSubscriptionLink().click();
			 
	  }
	  
	  @Test
	  /*Check the title of the UserSubscription page*/
	  public void UserSubscription_Title() {
		 
		 GetReport.startTestExecution(className);
		 String actualPageTitle = user.UserSubTitle();
		 Assert.assertEquals(ReleavantData.expectedUserPageTitle, actualPageTitle);
		  
	  }
	  
	  @Test
	  /*Check the header of the UserSubscription page*/
	  public void UserSubscription_Header() {
		 
		 GetReport.startTestExecution(className);
		 String actualPageHeader = user.UserSubHeader();
		 Assert.assertEquals(ReleavantData.expectedUserPageHeader, actualPageHeader);
		  
	  }
	  
	  @Test
	  /*Check the placeholder for the Username field*/
	  public void UserSubscription_HeaderPlaceholder() {
		 
		 GetReport.startTestExecution(className);
		 String actualUserSubUsernamePlaceholder = user.GetUsernameTextboxAttribute();
		 Assert.assertEquals(ReleavantData.expectedUserSubUsernamePlaceholder, actualUserSubUsernamePlaceholder);
		  
	  }
	  
	  @Test
	  /*Check the placeholder for the Email ID field*/
	  public void UserSubscription_EmailIDSPlaceholder() {
		 
		 GetReport.startTestExecution(className);
		 String actualUserSubEmailIDPlaceholder = user.GetEmailIDTextboxAttribute();
		 Assert.assertEquals(ReleavantData.expectedUserSubEmailIDPlaceholder, actualUserSubEmailIDPlaceholder);
		  
	  }
	  
	  @Test
	  /*Check the placeholder for the Mobile Number field*/
	  public void UserSubscription_MobileNumberPlaceholder() {
		 
		 GetReport.startTestExecution(className);
		 String actualUserSubMobNumberPlaceholder = user.GetMobileNumberTextboxAttribute();
		 Assert.assertEquals(ReleavantData.expectedUserSubMobileNumberPlaceholder, actualUserSubMobNumberPlaceholder);
		  
	  }
	  
//	  @Test
//	  /*Check the labels in the UserSubscription page -------------- Code Not working*/
//	  public void UserSubscription_AllLabels() {
//		  
//		
//		 
//		  for (int i = 0; i<user.FindAllLabelsInUserSubscription().size(); i++) {
//				
//				String text = user.FindAllLabelsInUserSubscription().get(i).getText();
//				Assert.assertEquals(ReleavantData.allLabelsPresent[i], text);
//			}
//		  
//	  }		
	  
	  @Test
	  /*Check the error message when Create User button is clicked without selecting Apartment*/
	  public void UserSubscription_CreateWithoutApartmentField() {
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 GetReport.startTestExecution(className);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenApartmentIsNotSelected);
	  }
	  
	  @Test
	  /*Check the error message when Create User button is clicked without selecting Block*/
	  public void UserSubscription_CreateWithoutBlockField() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenBlockIsNotSelected);
	  }
	  
	  @Test
	  /*Check the error message when Create User button is clicked without selecting Water Meter*/
	  public void UserSubscription_CreateWithoutWaterMeterField() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsNotSelected);
	  }
	  
	  @Test
	  /*Check the error message when Create User button is clicked without selecting User Type*/
	  public void UserSubscription_CreateWithoutUserTypeField() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenUserTypeIsNotSelected);
	  }
	  
	  @Test
	  /*Check the error message when Create User button is clicked without setting Username*/
	  public void UserSubscription_CreateWithoutUsername() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenUsernameIsNotSet);
	  }
	  
	  @Test
	  /*Check the error message when already existing Username is used*/
	  public void UserSubscription_CreateWithExistingUsername() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.superadmin_uname);
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenUsernameAlreadyExits);
	  }
	  
	  @Test
	  /*Check the error message when already existing Email ID is used*/
	  public void UserSubscription_CreateWithExistingEmailID() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys("americano");
		 user.EmailIDTextbox().sendKeys(ReleavantData.superadmin_emailid);
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenEmailAlreadyExits);
	  }
	  
	  @Test
	  /*Check the error message when Create User button is clicked without setting Email ID*/
	  public void UserSubscription_CreateWithoutEmailID() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys("admin");
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenEmailIDIsNotSet);
	  }
	  
	  @Test
	  /*Check the error message when Create User button is clicked without setting Mobile Number*/
	  public void UserSubscription_CreateWithoutMobileNumber() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys("admin");
		 user.EmailIDTextbox().sendKeys("email@unizen.com");
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenMobileNumberIsNotSet);
	  }
	  
	  @Test
	  /*Check the error message when Create User button is clicked without setting Location*/
	  public void UserSubscription_CreateWithoutLocation() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys("admin");
		 user.EmailIDTextbox().sendKeys("email@unizen.com");
		 user.MobileNumberTextbox().sendKeys("0008988980");
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenLocationIsNotSet);
	  }
	  
	  @Test
	  /*Check the error message when Create User button is clicked with Mobile number in invalid format*/
	  public void UserSubscription_CreateWithInvalidMobileNumber() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys("admin");
		 user.EmailIDTextbox().sendKeys("email@unizen.com");
		 user.MobileNumberTextbox().sendKeys("000898");
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenMobileNumberIsIncomplete);
		 user.MobileNumberTextbox().sendKeys("@123455");
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenMobileNumberIsNotValid);
	  }
	  
	  @Test
	  /*Check all required inputs for creating the User can be filled*/
	  public void UserSubscription_CreateWithAllFields() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys("admin");
		 user.EmailIDTextbox().sendKeys("email@unizen.com");
		 user.MobileNumberTextbox().sendKeys("0008988000");
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 String handle = driver.getWindowHandle();
		 System.out.println(handle);
		 user.AddLocationButton().click();

		 try {
			  
			  String parent = driver.getWindowHandle();
			  Set<String> windows = driver.getWindowHandles();
			  Iterator<String> it = windows.iterator();
			  while(it.hasNext())
			  {
				  
				 String child_window=it.next();
				 if(!parent.equals(child_window)) {
					 driver.switchTo().window(child_window);
					 user.AddLocationWindowSearchBar().sendKeys("BTM Layout");
					 user.AddLocationWindowSubmitButton().click();
					 user.AddLocationWindowSelectFirstValue().click();
					 driver.close();
				 }
				
			  }
				 driver.switchTo().window(parent);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		 
		 }
		 
	
	  @Test
	  /*Check the error message when Create User button is clicked when the selected Water Meter is already mapped*/
	  public void UserSubscription_CreateWhenWaterMeterIsAlreadyMapped() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys("kurama");
		 user.EmailIDTextbox().sendKeys("email@unizen.com");
		 user.MobileNumberTextbox().sendKeys("0008988000");
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 String handle = driver.getWindowHandle();
		 System.out.println(handle);
		 user.AddLocationButton().click();

		 try {
			  
			  String parent = driver.getWindowHandle();
			  Set<String> windows = driver.getWindowHandles();
			  Iterator<String> it = windows.iterator();
			  while(it.hasNext())
			  {
				  
				 String child_window=it.next();
				 if(!parent.equals(child_window)) {
					 driver.switchTo().window(child_window);
					 user.AddLocationWindowSearchBar().sendKeys("BTM Layout");
					 user.AddLocationWindowSubmitButton().click();
					 user.AddLocationWindowSelectFirstValue().click();
				 }
				
			  }
				 driver.switchTo().window(parent);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsAlreadyMapped);
		 
		 }
	  
	  @Test
	  /*Check able to create new User*/
	  public void UserSubscription_CreateNewUser() {
		 
		 GetReport.startTestExecution(className);
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 5);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.newUsername);
		 user.EmailIDTextbox().sendKeys(ReleavantData.newEmail);
		 user.MobileNumberTextbox().sendKeys(ReleavantData.phoneNumber);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 String handle = driver.getWindowHandle();
		 System.out.println(handle);
		 user.AddLocationButton().click();

		 try {
			  
			  String parent = driver.getWindowHandle();
			  Set<String> windows = driver.getWindowHandles();
			  Iterator<String> it = windows.iterator();
			  while(it.hasNext())
			  {
				  
				 String child_window=it.next();
				 if(!parent.equals(child_window)) {
					 driver.switchTo().window(child_window);
					 user.AddLocationWindowSearchBar().sendKeys("BTM Layout");
					 user.AddLocationWindowSubmitButton().click();
					 user.AddLocationWindowSelectFirstValue().click();
				 }
				
			  }
				 driver.switchTo().window(parent);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedSucessMessageWhenNewUserIsCreated);
		 
		 }
		 
		

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
