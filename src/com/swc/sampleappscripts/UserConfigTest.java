package com.swc.sampleappscripts;

import org.openqa.selenium.WebDriver;

import com.swc.common.TestConfiguration;
import com.swc.pompages.SWC_Dashboard;
import com.swc.pompages.SWC_LoginScreen;
import com.swc.pompages.SWC_UserSubscription;

public class UserConfigTest {

	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		SWC_LoginScreen sl;
		SWC_Dashboard sd;
		SWC_UserSubscription us;
		driver = TestConfiguration.getInstance();
		sl = new SWC_LoginScreen(driver);
		sd = new SWC_Dashboard(driver);
		us = new SWC_UserSubscription(driver);
		Thread.sleep(1000);
		sl.UsernameTextfield().sendKeys("uswm");
		sl.PasswordTextfield().sendKeys("6");
		sl.SignInButton().click();
		
		sd.UserMgmtLink().click();
		us.UserSubscriptionLink().click();
		System.out.println(us.UserSubTitle());
		System.out.println(us.UserSubTitle());
		us.CreateUserButton().click();
		
		
 }

}
