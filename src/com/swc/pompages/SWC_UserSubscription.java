package com.swc.pompages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class SWC_UserSubscription {

	
public WebDriver driver;
	
	public SWC_UserSubscription(WebDriver driver) {
		this.driver = driver;
	}
	
	public String UserSubTitle() {
		return driver.getTitle();
		
	}
	
	public String UserSubHeader() {
		
		return driver.findElement(By.xpath("//h5[@class = 'text-blue text-left ']")).getText();
	}
	
	public WebElement UserSubscriptionLink() {
		
		return driver.findElement(By.linkText("User Subscription"));
		
	}
	
    public List<WebElement> FindAllLabelsInUserSubscription() { //>>>>>>>>Not working
		
			List<WebElement> listOfLabels = driver.findElements(By.xpath("//td//b"));
			for (int i = 0; i < listOfLabels.size(); i++){
				
				listOfLabels.size();
								}
			return listOfLabels;
			
		
	}
	
	 public WebElement HousingTypeDropDownBox() {
	    	
	    	return driver.findElement(By.id("typeId"));
	    }
	    
	 public WebElement ApartmentsDropDownBox() {
	    	
	    	return driver.findElement(By.id("orgid"));
	   }
	 
	 public WebElement BlocksDropDownBox() {
	    	
	    	return driver.findElement(By.id("appid"));
	   }
	 
	 public WebElement WaterMetersDropDownBox() {
	    	
	    	return driver.findElement(By.id("devid"));
	   }
	
	 public WebElement UserTypeDropDownBox() {
	    	
	    	return driver.findElement(By.id("usertype"));
	   }
	 
	 public WebElement SetUsernameTextbox() {
	    	
	    	return driver.findElement(By.id("uname"));
	   }
	 
	 public String GetUsernameTextboxAttribute() {
	    	
	    	return driver.findElement(By.id("uname")).getAttribute("placeholder");
	   }
	 
	 public WebElement EmailIDTextbox() {
	    	
	    	return driver.findElement(By.id("email"));
	   }
	 
	 public String GetEmailIDTextboxAttribute() {
	    	
	    	return driver.findElement(By.id("email")).getAttribute("placeholder");
	   }
	 
	 public WebElement MobileNumberTextbox() {
	    	
	    	return driver.findElement(By.id("contact"));
	   }
	 
	 public String GetMobileNumberTextboxAttribute() {
	    	
	    	return driver.findElement(By.id("contact")).getAttribute("placeholder");
	   }
	 
	 
	 public WebElement AddLocationButton() {
	    	
	    	return driver.findElement(By.xpath("//input[@value = 'Add Location']"));
	   }
	 
	 public WebElement CreateUserButton() {
	    	
	    	return driver.findElement(By.xpath("//input[@value = 'Create user']"));
	   }
	 
	 public boolean HandleAlert(String expectedMsg) {
		 try {
			 String actualMsg = driver.switchTo().alert().getText();
			 driver.switchTo().alert().accept();
			 Assert.assertEquals(expectedMsg, actualMsg);
			 return true;
	
		 }catch (NoAlertPresentException Ex) {
			 return false;
		 }
	 }
	 
	 public boolean AlertPresence() {
		 try {
			 driver.switchTo().alert();
			 return true;
			 
		 }catch (NoAlertPresentException Ex) {
			 return false;
		 }
	 }
	 
	 public WebElement AddLocationWindowSearchBar() {
		 
		 return driver.findElement(By.xpath("//input[@type = 'text']"));
	 }
	 
	 public WebElement AddLocationWindowSubmitButton() {
		 
		 return driver.findElement(By.xpath("//input[@type = 'submit']"));
	 }
	 
	 public WebElement AddLocationWindowSelectFirstValue() {
		 
		 return driver.findElement(By.xpath("//a[@href = '#']"));
	 }
	 
}
