package com.swc.common;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestConfiguration implements RelativePath {

	WebDriver driver = null;
	
	public static WebDriver getInstance() {
		
		WebDriver  driver = null;
		
		String browserType = DataHandlers.getDataFromPropertyFile("config", "browser");
		
		String url = DataHandlers.getDataFromPropertyFile("config", "url");
		
		if(browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty(Chrome_properties, Chrome_path);
			driver = new ChromeDriver();
			
		} else if (browserType.equalsIgnoreCase("mozilla")) {
			
			System.setProperty(Firefox_properties, Firefox_path);
			driver = new FirefoxDriver();
			
		} else if (browserType.equalsIgnoreCase("edge")) {
			
			System.setProperty(MicrosoftEdge_properties, MicrosoftEdge_path);
			driver = new EdgeDriver();
			
		} else if (browserType.equalsIgnoreCase("opera")) {
			
		} else {
			System.out.println("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
}
	

