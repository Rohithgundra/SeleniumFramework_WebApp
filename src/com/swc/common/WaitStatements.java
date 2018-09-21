package com.swc.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatements {
	
	
	public static WebDriver driver = null;
	
	public static void ImplicitWait(WebDriver driver, int time) {
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	public static void ExplicitWait(WebDriver driver, WebElement element) {
		
             WebDriverWait wait = new WebDriverWait(driver, 30);
             wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void ExplicitWaitForAlert(WebDriver driver) {
		
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
}

}
