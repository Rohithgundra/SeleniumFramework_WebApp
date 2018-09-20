package com.swc.sampleappscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.swc.common.DropDownHandlers;
import com.swc.common.TestConfiguration;
import com.swc.common.WaitStatements;
import com.swc.pompages.ReleavantData;
import com.swc.pompages.SWC_Dashboard;
import com.swc.pompages.SWC_LoginScreen;
import com.swc.pompages.SWC_UserSubscription;

public class WaitTest {

	public static void main(String[] args) {
		
		 WebDriver driver;
		 SWC_LoginScreen ls;
		 SWC_Dashboard dash;
		 SWC_UserSubscription user;
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
		  

			 DropDownHandlers.selectDDLByIndex(user.HousingTypeDropDownBox(), 0);
			 DropDownHandlers.selectDDLByIndex(user.ApartmentsDropDownBox(), 1);
			WaitStatements.ExplicitWait(driver, user.BlocksDropDownBox());
			 DropDownHandlers.selectDDLByIndex(user.BlocksDropDownBox(), 1);
			 WaitStatements.ExplicitWait(driver, user.WaterMetersDropDownBox());
			 DropDownHandlers.selectDDLByIndex(user.WaterMetersDropDownBox(), 1);
			 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			 DropDownHandlers.selectDDLByIndex(user.UserTypeDropDownBox(), 1);
			 user.SetUsernameTextbox().sendKeys("admina");
			 user.CreateUserButton().click();
			 user.HandleAlert(ReleavantData.expectedErrorMessageWhenEmailIDIsNotSet);
	}
}
