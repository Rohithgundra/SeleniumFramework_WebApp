package com.swc.testscripts;

import org.testng.annotations.Test;

	import com.swc.common.DataHandlers;
	import com.swc.common.TakeScreenshot;
	import com.swc.common.TestConfiguration;
	import com.swc.pompages.SWC_LoginScreen;

	import org.testng.annotations.BeforeMethod;


	import java.io.IOException;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;

	public class testNG {
		
		  WebDriver driver;
		  TakeScreenshot tsr;
		  SWC_LoginScreen ls;
		  String excel = "C:\\Users\\srita\\Desktop\\SWC_TestData.xlsx";
		  String uname = DataHandlers.readExcel(excel, "Login", 2, 0);
		  
	  @Test
	  public void sampleTest() {
		 
//		  ls.UsernameTextfield().sendKeys(uname);
//		  ls.PasswordTextfield().sendKeys(uname);
		  driver.findElement(By.id("UN0")).sendKeys("uname");
	  }
	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  
		  driver = TestConfiguration.getInstance();
		  ls = new SWC_LoginScreen(driver);
		  
	  }

	  @AfterMethod
	  public void afterMethod(ITestResult result) throws IOException {
		  
		  if(ITestResult.FAILURE == result.getStatus()) {
				 
				 String testName = result.getName().toString();
				 TakeScreenshot.captureScreenShot(driver, testName);
				    
			 }
		  
		  driver.close();
	  }
	  
	}
		  



