package com.swc.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TakeScreenshot {
	
	public static WebDriver driver;
	
	public  static void captureScreenShot(WebDriver driver, String testName) throws IOException {

			    
			try {
				 File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 File target = new File(".\\screenshots\\"+ testName + ".png");
				 FileUtils.copyFile(scrShot, target);
			}catch (Exception e) {
				
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			
			 
		 }
		

}
