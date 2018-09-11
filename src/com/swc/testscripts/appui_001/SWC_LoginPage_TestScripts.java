package com.swc.testscripts.appui_001;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.swc.common.GetReport;
import com.swc.common.RelativePath;
import com.swc.common.SendTestReportMail;
import com.swc.common.TakeScreenshot;
import com.swc.common.TestConfiguration;
import com.swc.pompages.ReleavantData;
import com.swc.pompages.SWC_LoginScreen;

import junit.framework.Assert;

public class SWC_LoginPage_TestScripts implements RelativePath, ReleavantData{
	
	 WebDriver driver;
	 SWC_LoginScreen ls;
	 String className = getClass().getName();

	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  
		  GetReport.initializeReport();
		  driver = TestConfiguration.getInstance();
		  ls = new SWC_LoginScreen(driver);
		  ls.waitforLoginPageToLoad();
		  
	  
	  }
	  
  @Test
  /*Check the title of the Login page*/
  public void LoginPage_Title() {
	 
	 GetReport.startTestExecution(className);
	 String actualPageTitle = ls.LoginScreenTitle();
	 Assert.assertEquals(ReleavantData.expectedPageTitle, actualPageTitle);
	  
  }
  
  @Test
  /*Check the header of the Login page*/
  public void LoginPage_Header() {
	 
	 GetReport.startTestExecution(className);
	 String actualHeader = ls.LoginHeader();
	 Assert.assertEquals(ReleavantData.expectedHeader, actualHeader);
	  
  }
  
  @Test
  /*Check the sub headers present in the login page*/
  public void LoginPage_SubHeader() {
	 
	 GetReport.startTestExecution(className);
	 String actualSubHeader = ls.LoginSubHeader();
	 Assert.assertEquals(ReleavantData.expectedSubHeader, actualSubHeader);
	  
  }
  
  @Test
  /*Check the Username placeholder*/
  public void LoginPage_UsernamePlaceholder() {
	 
	 GetReport.startTestExecution(className);
	 String actualSubHeader = ls.UsernamePlaceholder();
	 Assert.assertEquals(ReleavantData.expectedUsernamePlaceholder, actualSubHeader);
	  
  }
  
  @Test
  /*Check the Username textboxAttribute*/
  public void LoginPage_UsernameAttribute() {
	 
	 GetReport.startTestExecution(className);
	 String actualdUsernameAttribute = ls.UsernameTextBoxAttribute();
	 Assert.assertEquals(ReleavantData.expectedUsernameAttribute, actualdUsernameAttribute);
	  
  }
  
  @Test
  /*Check the Password textboxAttribute*/
  public void LoginPage_PasswordAttribute() {
	 
	 GetReport.startTestExecution(className);
	 String actualdPasswordAttribute = ls.PasswordTextBoxAttribute();
	 Assert.assertEquals(ReleavantData.expectedPasswordAttribute, actualdPasswordAttribute);
	  
  }
  
  
  @Test
  /*Check the Password placeholder*/
  public void LoginPage_PasswordPlaceholder() {
	 
	 GetReport.startTestExecution(className);
	 String actualSubHeader = ls.PasswordPlaceholder();
	 Assert.assertEquals(ReleavantData.expectedPasswordPlaceholder, actualSubHeader);
	  
  }
  
  @Test
  /*Check the Login with Invalid Credentials*/
  public void LoginPage_SignInWithInvalidCredentials() {
	 
	  GetReport.startTestExecution(className);
	  ls.UsernameTextfield().sendKeys("admin");
	  ls.PasswordTextfield().sendKeys("123456");
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualInvalidCredentialsErrorMsg = ls.InvalidCredentialsMessage();
	  Assert.assertEquals(ReleavantData.expectedInvalidCredentialsErrorMsg, actualInvalidCredentialsErrorMsg);
	  	    
  }
  
  @Test
  /*Check the Login with Invalid Username*/
  public void LoginPage_SignInWithInvalidUsername() {
	 
	  GetReport.startTestExecution(className);
	  ls.UsernameTextfield().sendKeys("admin");
	  ls.PasswordTextfield().sendKeys("123456");
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualInvalidUsernameErrorMsg = ls.InvalidCredentialsMessage();
	  Assert.assertEquals(ReleavantData.expectedInvalidUsernameErrorMsg, actualInvalidUsernameErrorMsg);
	  	    
  }
  
  @Test
  /*Check the Login with Invalid Password*/
  public void LoginPage_SignInWithInvalidPassword() {
	 
	  GetReport.startTestExecution(className);
	  ls.UsernameTextfield().sendKeys("admin");
	  ls.PasswordTextfield().sendKeys("123456");
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualInvalidPasswordErrorMsg = ls.InvalidCredentialsMessage();
	  Assert.assertEquals(ReleavantData.expectedInvalidPasswordErrorMsg, actualInvalidPasswordErrorMsg);
	  	    
  }
  
  @Test
  /*Check the Login without providing Username and Password*/
  public void LoginPage_SignInWithBlankCredentials() {
	 
	  GetReport.startTestExecution(className);
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualBlankCredentialsErrorMsg = ls.EmptyUsernameMessage();
	  Assert.assertEquals(ReleavantData.expectedBlankCredentialsErrorMsg, actualBlankCredentialsErrorMsg);
	  	    
  }
  
  @Test
  /*Check the Login without providing Password*/
  public void LoginPage_SignInWithBlankPassword() {
	 
	  GetReport.startTestExecution(className);
	  ls.UsernameTextfield().sendKeys("admin");
	  ls.SignInButton().click();
	  String actualBlankPasswordErrorMsg = ls.EmptyPasswordMessage();
	  Assert.assertEquals(ReleavantData.expectedBlankPasswordErrorMsg, actualBlankPasswordErrorMsg);
	  	    
  }
  
  @Test
  /*Check the Login with valid credentials*/
  public void LoginPage_SignInWithValidCredentials() throws InterruptedException {
	 
	  GetReport.startTestExecution(className);
	  ls.UsernameTextfield().sendKeys("uswm");
	  ls.PasswordTextfield().sendKeys("6");
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualDashboardTitle = driver.getTitle();
	  actualDashboardTitle = actualDashboardTitle.substring(0, 5);
	  Assert.assertEquals(ReleavantData.expectedDashboardTitle, actualDashboardTitle);
	  	    
  }
  
  @Test
  /*Check the Login initially with invalid credentials and later valid credentials*/
  public void LoginPage_SignInAttempts() throws InterruptedException {
	 
	  GetReport.startTestExecution(className);
	  try {
		  ls.UsernameTextfield().sendKeys("inavlid");
		  ls.PasswordTextfield().sendKeys("invalid");
		  ls.SignInButton().click();
			  
		  ls.UsernameTextfield().sendKeys("uswm");
		  ls.PasswordTextfield().sendKeys("6");
		  ls.SignInButton().click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String actualDashboardTitle = driver.getTitle();
		  actualDashboardTitle = actualDashboardTitle.substring(0, 5);
		  Assert.assertEquals(ReleavantData.expectedDashboardTitle, actualDashboardTitle);
		  
	  }catch(Exception e){
		  
		  e.printStackTrace();
		  
	  }
	  	    
  }
  
  @Test
  /*Check the Login initially with invalid credentials, blank fields and later valid credentials*/
  public void LoginPage_RepeatedSignInAttempts() throws InterruptedException {
	 
	  GetReport.startTestExecution(className);
	  try {
		  
		  
		  ls.UsernameTextfield().sendKeys("inavlid");
		  ls.PasswordTextfield().sendKeys("invalid");
		  ls.SignInButton().click();

		  ls.UsernameTextfield().clear();
		  ls.PasswordTextfield().clear();
		  ls.SignInButton();
		  
		  ls.UsernameTextfield().sendKeys("uswm");
		  ls.PasswordTextfield().sendKeys("6");
		  ls.SignInButton().click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String actualDashboardTitle = driver.getTitle();
		  actualDashboardTitle = actualDashboardTitle.substring(0, 5);
		  Assert.assertEquals(ReleavantData.expectedDashboardTitle, actualDashboardTitle);
		  
	  }catch(Exception e){
		  
		  e.printStackTrace();
		  
	  }
	  	    
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
