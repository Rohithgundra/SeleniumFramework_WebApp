package com.swc.common;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestConfiguration implements RelativePath {

	WebDriver driver = null;
	
	public static WebDriver getInstance() {
		
		WebDriver  driver = null;
		
		String browserType = DataHandlers.getDataFromPropertyFile("browser");
		
		String url = DataHandlers.getDataFromPropertyFile("url");
		
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
		
		
		try {
			  HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			      conn.setUseCaches(false);
			      conn.connect();
			      int status = conn.getResponseCode();
			      
			      if(status == 200) {
			    	  driver.get(url);
			    	  try {
						  
						  String parent = driver.getWindowHandle();
						  Set<String> windows = driver.getWindowHandles();
						  Iterator<String> it = windows.iterator();
						  while(it.hasNext())
						  {
							  
							 String child_window=it.next();
							 if(!parent.equals(child_window)) {
								 driver.switchTo().window(child_window);
								 driver.close();
							 }
							
						  }
							 driver.switchTo().window(parent);
					  }catch(Exception e) {
						  e.printStackTrace();
					  }
			      }else {
			    	  System.out.println("Not getting 200 response from server");
			    	  JOptionPane.showMessageDialog(null, "Not getting 200 response from server", "Server Error", JOptionPane.ERROR_MESSAGE);
			    	  JOptionPane.getRootFrame().dispose();
		
			    	  driver.quit();
			      }
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return driver;
	}
	
}
	

