package com.swc.testscripts.appui_001;

import java.io.IOException;
import java.lang.reflect.Method;
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

	  @BeforeMethod
	  public void beforeMethod(Method method) throws IOException {
		  
		  GetReport.initializeReport();
		  driver = TestConfiguration.getInstance();
		  ls = new SWC_LoginScreen(driver);
		  String testName = method.getName();
		  String testDescription = method.getAnnotation(Test.class).testName();
		  GetReport.startTestExecution(testName, testDescription );
		  
	  
	  }

	  
  @Test (priority=1, testName = "Verify the Title of the Login Page")	
  public void LoginPage_Title() {
	 
	 String actualPageTitle = ls.LoginScreenTitle();
	 Assert.assertEquals(ReleavantData.expectedPageTitle, actualPageTitle);
	  
  }
  
  @Test (priority=2, testName = "Verify the Header of the Login Page")	
  public void LoginPage_Header() {
	 
	 String actualHeader = ls.LoginHeader();
	 Assert.assertEquals(ReleavantData.expectedHeader, actualHeader);
	  
  }
  
  @Test (priority=3, testName = "Verify the SubHeader of the Login Page")	
  public void LoginPage_SubHeader() {
	 
	 String actualSubHeader = ls.LoginSubHeader();
	 Assert.assertEquals(ReleavantData.expectedSubHeader, actualSubHeader);
	  
  }
  
  @Test (priority=4, testName = "Verify the Username Placeholder")		
  public void LoginPage_UsernamePlaceholder() {
	 
	 String actualSubHeader = ls.UsernamePlaceholder();
	 Assert.assertEquals(ReleavantData.expectedUsernamePlaceholder, actualSubHeader);
	  
  }
  
  @Test (priority=5, testName = "Verify the Username Attribute")
  public void LoginPage_UsernameAttribute() {
	 
	 String actualdUsernameAttribute = ls.UsernameTextBoxAttribute();
	 Assert.assertEquals(ReleavantData.expectedUsernameAttribute, actualdUsernameAttribute);
	  
  }
  
  @Test (priority=6, testName = "Verify the Password Attribute")
  public void LoginPage_PasswordAttribute() {
	 
	 String actualdPasswordAttribute = ls.PasswordTextBoxAttribute();
	 Assert.assertEquals(ReleavantData.expectedPasswordAttribute, actualdPasswordAttribute);
	  
  }
  
  
  @Test (priority=7, testName = "Verify the Password Placeholder")	
  public void LoginPage_PasswordPlaceholder() {
	 
	 String actualSubHeader = ls.PasswordPlaceholder();
	 Assert.assertEquals(ReleavantData.expectedPasswordPlaceholder, actualSubHeader);
	  
  }
  
  @Test (priority=8, testName = "Verify the Login with Invalid Credentials")	
  public void LoginPage_SignInWithInvalidCredentials() {
	 
	  ls.UsernameTextfield().sendKeys("admin");
	  ls.PasswordTextfield().sendKeys("123456");
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualInvalidCredentialsErrorMsg = ls.InvalidCredentialsMessage();
	  Assert.assertEquals(ReleavantData.expectedInvalidCredentialsErrorMsg, actualInvalidCredentialsErrorMsg);
	  	    
  }
  
  @Test (priority=9, testName = "Verify the Login with Invalid Username")	
  public void LoginPage_SignInWithInvalidUsername() {
	 
	  ls.UsernameTextfield().sendKeys("admin");
	  ls.PasswordTextfield().sendKeys("123456");
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualInvalidUsernameErrorMsg = ls.InvalidCredentialsMessage();
	  Assert.assertEquals(ReleavantData.expectedInvalidUsernameErrorMsg, actualInvalidUsernameErrorMsg);
	  	    
  }
  
  @Test (priority=10, testName = "Verify the Login with Invalid Password")	
  public void LoginPage_SignInWithInvalidPassword() {
	 
	  ls.UsernameTextfield().sendKeys("admin");
	  ls.PasswordTextfield().sendKeys("123456");
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualInvalidPasswordErrorMsg = ls.InvalidCredentialsMessage();
	  Assert.assertEquals(ReleavantData.expectedInvalidPasswordErrorMsg, actualInvalidPasswordErrorMsg);
	  	    
  }
  
  @Test (priority=11, testName = "Verify the Login with Blank Credentials")	
  public void LoginPage_SignInWithBlankCredentials() {
	 
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualBlankCredentialsErrorMsg = ls.EmptyUsernameMessage();
	  Assert.assertEquals(ReleavantData.expectedBlankCredentialsErrorMsg, actualBlankCredentialsErrorMsg);
	  	    
  }
  
  @Test (priority=12, testName = "Verify the Login with Blank Password")	
  public void LoginPage_SignInWithBlankPassword() {
	 
	  ls.UsernameTextfield().sendKeys("admin");
	  ls.SignInButton().click();
	  String actualBlankPasswordErrorMsg = ls.EmptyPasswordMessage();
	  Assert.assertEquals(ReleavantData.expectedBlankPasswordErrorMsg, actualBlankPasswordErrorMsg);
	  	    
  }
  
  @Test (priority=13, testName = "Verify the Login with Valid Credenetials")	
  public void LoginPage_SignInWithValidCredentials() throws InterruptedException {
	 
	  ls.UsernameTextfield().sendKeys(ReleavantData.superadmin_uname);
	  ls.PasswordTextfield().sendKeys(ReleavantData.superadmin_pword);
	  ls.SignInButton().click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualDashboardTitle = driver.getTitle();
	  actualDashboardTitle = actualDashboardTitle.substring(0, 5);
	  Assert.assertEquals(ReleavantData.expectedDashboardTitle, actualDashboardTitle);
	  	    
  }
  
  @Test (priority=14, testName = "Verify the Login with Invalid and followed by Valid Credenetials")	
  public void LoginPage_SignInAttempts() throws InterruptedException {
	 
	  try {
		  ls.UsernameTextfield().sendKeys("inavlid");
		  ls.PasswordTextfield().sendKeys("invalid");
		  ls.SignInButton().click();
			  
		  ls.UsernameTextfield().sendKeys(ReleavantData.superadmin_uname);
		  ls.PasswordTextfield().sendKeys(ReleavantData.superadmin_pword);
		  ls.SignInButton().click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String actualDashboardTitle = driver.getTitle();
		  actualDashboardTitle = actualDashboardTitle.substring(0, 5);
		  Assert.assertEquals(ReleavantData.expectedDashboardTitle, actualDashboardTitle);
		  
	  }catch(Exception e){
		  
		  e.printStackTrace();
		  
	  }
	  	    
  }
  
  @Test (priority=15, testName = "Verify the Login with Invalid, followed by Blank and Valid Credenetials")	
  public void LoginPage_RepeatedSignInAttempts() throws InterruptedException {
	 
	  try {
		  
		  
		  ls.UsernameTextfield().sendKeys("inavlid");
		  ls.PasswordTextfield().sendKeys("invalid");
		  ls.SignInButton().click();

		  ls.UsernameTextfield().clear();
		  ls.PasswordTextfield().clear();
		  ls.SignInButton();
		  
		  ls.UsernameTextfield().sendKeys(ReleavantData.superadmin_uname);
		  ls.PasswordTextfield().sendKeys(ReleavantData.superadmin_pword);
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
  
//  @AfterSuite
//  public void finalWork() {
// 	 
// 	 SendTestReportMail.sendReport();
// 	 
//  }
  
}
