package com.swc.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.swc.pompages.SWC_LoginScreen;

public class sample {

	private WebDriver driver;
	public sample(WebDriver driver) {
		this.driver = driver;
	}
	public static void main(String[]args) {
		
	
		System.setProperty("webdriver.chrome.driver", "F:\\GitHub\\SWC_SeleniumFramework\\browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://139.59.14.31:8081/USWM/");
		
		SWC_LoginScreen ls = new SWC_LoginScreen(driver);
		ls.UsernameTextfield().sendKeys("usm");
		
String s = ls.LoginSubHeader();
System.out.println(s);

String m = ls.LoginHeader();
System.out.println(m);
		
		
		
	}


}
