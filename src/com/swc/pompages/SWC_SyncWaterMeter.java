package com.swc.pompages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class SWC_SyncWaterMeter {
	
	public WebDriver driver;
	
	public SWC_SyncWaterMeter(WebDriver driver) {
		this.driver = driver;
	}
	
	public String SyWaterMeterTitle() {
		return driver.getTitle();
		
	}
	
    public String SyWaterMeterHeader() {
		
		return driver.findElement(By.xpath("//h5[contains(@class,'text-blue text-left')]//b[contains(text(),'Sync-Water Meter')]")).getText();
	}
    

    
    public List<WebElement> FindAllLabelsInSyWaterMeterKLink() { //>>>>>>>>Not working
		
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
	 
	 public WebElement SyncButton() {
	    	
	    	return driver.findElement(By.xpath("//input[@value='Sync']"));
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
	 
}