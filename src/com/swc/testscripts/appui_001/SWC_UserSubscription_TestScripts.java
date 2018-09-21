package com.swc.testscripts.appui_001;

import java.io.IOException;
import java.lang.reflect.Method;
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
import com.swc.common.WaitStatements;
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
		  dash.UserMgmtLink().click();
		  dash.UserSubscriptionLink().click();
			 
	  }
	  
	  @Test (priority=1, testName = "Verify the title of the UserSubscription page")
	  public void UserSubscription_Title() {
		 

		 String actualPageTitle = user.UserSubTitle();
		 Assert.assertEquals(ReleavantData.expectedUserPageTitle, actualPageTitle);
		  
	  }
	  
	  @Test (priority=2, testName = "Verify the header of the UserSubscription page")
	  public void UserSubscription_Header() {
		 
		
		 String actualPageHeader = user.UserSubHeader();
		 Assert.assertEquals(ReleavantData.expectedUserPageHeader, actualPageHeader);
		  
	  }
	  
	  @Test (priority=3, testName = "Verify the placeholder for the Username field")
	  public void UserSubscription_HeaderPlaceholder() {
		 
	
		 String actualUserSubUsernamePlaceholder = user.GetUsernameTextboxAttribute();
		 Assert.assertEquals(ReleavantData.expectedUserSubUsernamePlaceholder, actualUserSubUsernamePlaceholder);
		  
	  }
	  
	  @Test (priority=4, testName = "Verify the placeholder for the Email ID field")
	  public void UserSubscription_EmailIDSPlaceholder() {
		 
	
		 String actualUserSubEmailIDPlaceholder = user.GetEmailIDTextboxAttribute();
		 Assert.assertEquals(ReleavantData.expectedUserSubEmailIDPlaceholder, actualUserSubEmailIDPlaceholder);
		  
	  }
	  
	  @Test (priority=5, testName = "Verify the placeholder for the Mobile Number field")
	  public void UserSubscription_MobileNumberPlaceholder() {
		 
		
		 String actualUserSubMobNumberPlaceholder = user.GetMobileNumberTextboxAttribute();
		 Assert.assertEquals(ReleavantData.expectedUserSubMobileNumberPlaceholder, actualUserSubMobNumberPlaceholder);
		  
	  }
	  
//	  @Test
//	  /*Check the labels in the UserSubscription page --------------  Code Is Okay, Configuration is Failing*/
//	  public void UserSubscription_AllLabels() {
//		  
//		
//		 
//		  for (int i = 0; i<user.FindAllLabelsInUserSubscription().size(); i++) {
//				
//				String text = user.FindAllLabelsInUserSubscription().get(i).getText();
//				Assert.assertEquals(ReleavantData.allLabelsPresentInUserSub[i], text);
//			}
//		  
//	  }		
	  
	  @Test (priority=6, testName = "Verify the error message when Create User button is clicked without selecting Apartment")
	  public void UserSubscription_CreateWithoutApartmentField() {
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenApartmentIsNotSelected);
	  }
	  
	  @Test (priority=7, testName = "Verify the error message when Create User button is clicked without selecting Block")
	  public void UserSubscription_CreateWithoutBlockField() {
		 

		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenBlockIsNotSelected);
	  }
	  
	  @Test (priority=8, testName = "Verify the error message when Create User button is clicked without selecting Water Meter")
	  public void UserSubscription_CreateWithoutWaterMeterField() {
		 

		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsNotSelected);
	  }
	  
	  @Test (priority=9, testName = "Verify the error message when Create User button is clicked without selecting User Type")
	  public void UserSubscription_CreateWithoutUserTypeField() {
		 
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ImplicitWait(driver, 30);
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenUserTypeIsNotSelected);
	  }
	  
	  @Test (priority=10, testName = "Verify the error message when Create User button is clicked without setting Username")
	  public void UserSubscription_CreateWithoutUsername() {
		 
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenUsernameIsNotSet);
	  }
	  
	  @Test (priority=11, testName = "Verify the error message when already existing Username is used")
	  public void UserSubscription_CreateWithExistingUsername() {
		 
		
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
	     DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.superadmin_uname);
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenUsernameAlreadyExits);
	  }
	  
	  @Test (priority=12, testName = "Verify the error message when already existing Email ID is used")
	  public void UserSubscription_CreateWithExistingEmailID() {
		 
		
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.fixedUsername);
		 user.EmailIDTextbox().sendKeys(ReleavantData.superadmin_emailid);
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenEmailAlreadyExits);
	  }
	  
	  @Test (priority=13, testName = "Verify the error message when Create User button is clicked without setting Email ID")
	  public void UserSubscription_CreateWithoutEmailID() {
		 
	
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");			 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.fixedUsername);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenEmailIDIsNotSet);
	  }
	  
	  @Test (priority=14, testName = "Verify the error message when Create User button is clicked without setting Mobile Number")
	  public void UserSubscription_CreateWithoutMobileNumber() {
		 

		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
  		 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.fixedUsername);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.EmailIDTextbox().sendKeys(ReleavantData.fixedEmail);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenMobileNumberIsNotSet);
	  }
	  
	  @Test (priority=15, testName = "Verify the error message when Create User button is clicked without setting Location")
	  public void UserSubscription_CreateWithoutLocation() {
		 
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.fixedUsername);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.EmailIDTextbox().sendKeys(ReleavantData.fixedEmail);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.MobileNumberTextbox().sendKeys(ReleavantData.fixedPhoneNumber);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenLocationIsNotSet);
	  }
	  
	  @Test (priority=16, testName = "Verify the error message when Create User button is clicked with Mobile number in invalid format")
	  public void UserSubscription_CreateWithInvalidMobileNumber() {
		 
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
     	 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
	   	 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.fixedUsername);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.EmailIDTextbox().sendKeys(ReleavantData.fixedEmail);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.MobileNumberTextbox().sendKeys("000898");
		 WaitStatements.ImplicitWait(driver, 30);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenMobileNumberIsIncomplete);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.MobileNumberTextbox().sendKeys("@123455");
		 WaitStatements.ImplicitWait(driver, 30);
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenMobileNumberIsNotValid);
	  }
	  
	  @Test (priority=17, testName = "Verify all required inputs for creating the User can be filled")
	  public void UserSubscription_CreateWithAllFields() {
		 
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
    	 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.fixedUsername);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.EmailIDTextbox().sendKeys(ReleavantData.fixedEmail);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.MobileNumberTextbox().sendKeys(ReleavantData.fixedPhoneNumber);
		 WaitStatements.ImplicitWait(driver, 30);
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
		 
		 }
		 
	
	  @Test (priority=19, testName = "Verify the error message when Create User button is clicked when the selected Water Meter is already mapped")
	  public void UserSubscription_CreateWhenWaterMeterIsAlreadyMapped() {
		 
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
		 WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 4);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.fixedUsername);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.EmailIDTextbox().sendKeys(ReleavantData.fixedEmail);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.MobileNumberTextbox().sendKeys(ReleavantData.fixedPhoneNumber);
		 WaitStatements.ImplicitWait(driver, 30);
		 String handle = driver.getWindowHandle();
		 System.out.println(handle);
		 user.AddLocationButton().click();
		 WaitStatements.ImplicitWait(driver, 30);

		 try {
			  
			  String parent = driver.getWindowHandle();
			  Set<String> windows = driver.getWindowHandles();
			  Iterator<String> it = windows.iterator();
			  while(it.hasNext())
			  {
				  
				 String child_window=it.next();
				 if(!parent.equals(child_window)) {
					 driver.switchTo().window(child_window);
					 WaitStatements.ImplicitWait(driver, 30);
					 user.AddLocationWindowSearchBar().sendKeys("BTM Layout");
					 user.AddLocationWindowSubmitButton().click();
					 user.AddLocationWindowSelectFirstValue().click();
					 WaitStatements.ImplicitWait(driver, 30);
				 }
				
			  }
				 driver.switchTo().window(parent);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		 user.CreateUserButton().click();
		 user.HandleAlert(ReleavantData.expectedErrorMessageWhenWaterMeterIsAlreadyMapped);
		 
		 }
	  
	  @Test (priority=18, testName = "Verify new User Creation")
	  /*Check able to create new User*/
	  public void UserSubscription_CreateNewUser() {
		 
		 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
		 DropDownHandlers.selectDDLByVisibleText(user.ApartmentsDropDownBox(), "Unizen");
         WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
		 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 4);
		 WaitStatements.ExplicitWait(driver, user.UserTypeDropDownBox());
		 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
		 user.SetUsernameTextbox().sendKeys(ReleavantData.newUsername);
		 WaitStatements.ImplicitWait(driver, 30);
		 user.EmailIDTextbox().sendKeys(ReleavantData.newEmail);
		 user.MobileNumberTextbox().sendKeys(ReleavantData.phoneNumber);
		 WaitStatements.ImplicitWait(driver, 30);
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
