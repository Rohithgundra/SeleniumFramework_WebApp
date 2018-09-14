package com.swc.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	 
	 public WebElement EmailIDTextbox() {
	    	
	    	return driver.findElement(By.id("email"));
	   }
	 
	 public WebElement MobileNumberTextbox() {
	    	
	    	return driver.findElement(By.id("contact"));
	   }
	 
	 
	 public WebElement AddLocationButton() {
	    	
	    	return driver.findElement(By.xpath("//input[@value = 'Add Location']"));
	   }
	 
	 public WebElement CreateUserButton() {
	    	
	    	return driver.findElement(By.xpath("//input[@value = 'Create user']"));
	   }
	 
	 public boolean HandleAlert() {
		 try {
			 driver.switchTo().alert().accept();
			 return true;
	
		 }catch (NoAlertPresentException Ex) {
			 return false;
		 }
	 }
	 
	 
}
