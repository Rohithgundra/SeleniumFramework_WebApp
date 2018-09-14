package com.swc.testscripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.swc.common.DropDownHandlers;
import com.swc.common.TestConfiguration;
import com.swc.pompages.SWC_Dashboard;
import com.swc.pompages.SWC_LoginScreen;

public class DashboardTest {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		SWC_LoginScreen sl;
		SWC_Dashboard sd;
		driver = TestConfiguration.getInstance();
		sl = new SWC_LoginScreen(driver);
		sd = new SWC_Dashboard(driver);
		Thread.sleep(1000);
		sl.UsernameTextfield().sendKeys("uswm");
		sl.PasswordTextfield().sendKeys("6");
		sl.SignInButton().click();
		
		
		
		String [] you = {"Housing Type", "Apartments", "Blocks", "Water Meters", "From Date", "To Date", "Filter By", "Action"};
		
		
		/* Working code....................*/
//		for (int i =0; i<sd.FindAllLabels().size(); i++) {
//			String text = sd.FindAllLabels().get(i).getText();
//			if (text.equals(you[i])) {
//				System.out.println("Matched");
//			}else {
//				System.out.println("Failed to Match");
//			}
//		}
		
				
		/* Example for cross verifying WebElement list w.r.t to expected list */	
//		for (int i = 0; i<sd.FindAllLabels().size(); i++) {
//			
//			String text = sd.FindAllLabels().get(i).getText();
//			System.out.println(text);
//			Assert.assertEquals(you[i], text);
//			System.out.println(you[i]);
//		}
		
		

		/* Example for selecting Dropdown box */		
//		DropDownHandlers.selectDDLByIndex(sd.ApartmentsTypeDropDownBox(), 2);

        /* Example for filling up the calendar textbox */
//	    driver.findElement(By.id("fromDate")).sendKeys("08/29/2018 6:28 PM");
		
		
		driver.findElement(By.linkText("Settings")).click();
		
		sd.SignOutLink().click();
		
//		driver.quit();
	
			
		
}



}

