package com.swc.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SWC_LoginScreen {
	
	static WebDriver driver;
	
	public SWC_LoginScreen(WebDriver driver) {
		this.driver = driver;
	}
	

	public static String LoginScreenTitle() {
		
		return driver.getTitle();
		
	}
	
	public static String LoginHeader() {
		
		return driver.findElement(By.xpath("//div[@class='login-logo']")).getText();
		
	}
	
	public static String LoginSubHeader() {
		
		return driver.findElement(By.xpath("//p[@class='login-box-msg']")).getText();
	
	}
	
	public static WebElement UsernameTextfield() {
		
		return driver.findElement(By.id("uname"));
	}
	
    public static WebElement PasswordTextfield() {
    	
    	return driver.findElement(By.id("pass"));
		
	}
    
    public static WebElement SignInButton() {
    	
    	return driver.findElement(By.xpath("//button[@type = 'submit']"));
    }
    
    public static WebElement ForgotButton() {
		
    	return null;
    	
    }

}
