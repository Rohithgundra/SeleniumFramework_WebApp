package com.swc.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SWC_LoginScreen {
	
	public WebDriver driver;
	
	public SWC_LoginScreen(WebDriver driver) {
		this.driver = driver;
	}
	

	public String LoginScreenTitle() {
		
		return driver.getTitle();
		
	}
	
	public String LoginHeader() {
		
		return driver.findElement(By.xpath("//div[@class='login-logo']")).getText();
		
	}
	
	public String LoginSubHeader() {
		
		return driver.findElement(By.xpath("//p[@class='login-box-msg']")).getText();
	
	}
	
	public WebElement UsernameTextfield() {
		
		return driver.findElement(By.id("uname"));
	}
	
    public WebElement PasswordTextfield() {
    	
    	return driver.findElement(By.id("pass"));
		
	}
    
    public WebElement SignInButton() {
    	
    	return driver.findElement(By.xpath("//button[@type = 'submit']"));
    }
    
    public String InvalidCredentialsMessage() {
    	
    	return driver.findElement(By.xpath("//div[@class='failure']")).getText();
    }
    
    public String EmptyUsernameMessage() {
    	
    	return driver.findElement(By.xpath("//span[@id='namevalid']")).getText();
    }
    
    public String EmptyPasswordMessage() {
    	
    	return driver.findElement(By.xpath("//span[@id='passvalid']")).getText();
    }
    
    public WebElement ForgotLink() {
		
    	return null;
    	
    }
    
    public String UsernamePlaceholder() {
    	
    	return driver.findElement(By.xpath("//input[@placeholder='Username']")).getAttribute("placeholder");
    }
    
    public String PasswordPlaceholder() {
    	
    	return driver.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("placeholder");
    }
    
    public void waitforLoginPageToLoad() {
    	
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wrapper']")));
    }
    
    public String UsernameTextBoxAttribute() {
    	
    	return driver.findElement(By.xpath("//input[@placeholder='Username']")).getAttribute("type");
    }
    
    public String PasswordTextBoxAttribute() {
    	
    	return driver.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("type");
    }

}
