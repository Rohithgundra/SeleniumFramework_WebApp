package com.swc.pompages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SWC_Dashboard {
	
	public WebDriver driver;
	
	public SWC_Dashboard(WebDriver driver) {
		this.driver = driver;
	}
	
	public String Dashboard() {
		return driver.getTitle();
	}
	
//	public String HeaderWaterConsumption() {
//		return driver.findElement(By.xpath("//h3[@class = 'box-title']")).getText();
//	}
	
	
    public List<WebElement> FindAllLabels() {
		
			List<WebElement> listOfLabels = driver.findElements(By.xpath("//label"));
			for (int i = 0; i < listOfLabels.size(); i++){
				
				listOfLabels.size();
								}
			return listOfLabels;
			
		
	}
    
    public List<WebElement> FindAllSubPagesLinks() {
		
		List<WebElement> listOfSubPagesLinks = driver.findElements(By.xpath("//a//span//b"));
		
		for (int i = 0; i < listOfSubPagesLinks.size(); i++){
			
			listOfSubPagesLinks.size();
			
		}
		return listOfSubPagesLinks;	
		
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
    
    public WebElement FiltersByDropDownBox() {
    	
    	return driver.findElement(By.id("filter"));
    }
	
    public WebElement FromDate() {
    	
    	return driver.findElement(By.id("fromDate"));
    }
    
   public WebElement ToDate() {
    	
    	return driver.findElement(By.id("toDate"));
    }
   
   public WebElement SubmitButton() {
	   
	   return driver.findElement(By.xpath("//input[@type='submit']"));
   }
   
   public WebElement SettingsLink() {
	
	   return driver.findElement(By.linkText("Settings"));
	   
   }
   
   public WebElement UserMgmtLink() {
		
	   return driver.findElement(By.linkText("User Mgmt"));
	   
   }
   
   public WebElement DeviceMgmtLink() {
		
	   return driver.findElement(By.linkText("Device Mgmt"));
	   
   }
   
   public WebElement PayBillsLink() {
		
	   return driver.findElement(By.linkText("Pay Bills"));
	   
   }
   
   public WebElement ReportsLink() {
		
	   return driver.findElement(By.linkText("Reports"));
	   
   }
   
   public WebElement LogsLink() {
		
	   return driver.findElement(By.linkText("Logs"));
	   
   }
   
   public WebElement SyncLink() {
		
	   return driver.findElement(By.linkText("Sync"));
	   
   }
   
   public WebElement SignOutLink() {
		
	   return driver.findElement(By.linkText("Sign-Out"));
	   
   }
   
   public boolean HandleAlert() {
		 try {
			 driver.switchTo().alert().accept();
			 return true;
	
		 }catch (NoAlertPresentException Ex) {
			 return false;
		 }
	 }
   
   public WebElement UserSubscriptionLink() {
		
	   return driver.findElement(By.linkText("User Subscription"));
	   
   }
   

}
