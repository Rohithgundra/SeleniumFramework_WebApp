package com.swc.testscripts;

import org.testng.annotations.Test;

import com.swc.common.DataHandlers;
import com.swc.common.TestConfiguration;
import com.swc.pompages.SWC_LoginScreen;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class testNGScript {
	
	  WebDriver driver;
	  SWC_LoginScreen ls;
	  String excel = "C:\\Users\\srita\\Desktop\\Test Data.xlsx";
	  String uname = DataHandlers.readExcel(excel, "Sheet1", 1, 0);
	  
  @Test
  public void f() {
	 
	  ls.UsernameTextfield().sendKeys(uname);
	  ls.PasswordTextfield().sendKeys(uname);
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = TestConfiguration.getInstance();
	  ls = new SWC_LoginScreen(driver);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
