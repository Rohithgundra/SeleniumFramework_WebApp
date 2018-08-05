package com.swc.testscripts;


import org.openqa.selenium.WebDriver;


import com.swc.common.DataHandlers;
import com.swc.common.RelativePath;
import com.swc.common.TestConfiguration;
import com.swc.pompages.SWC_LoginScreen;

public class script implements RelativePath {
	
	static WebDriver driver;
	static String excel = "C:\\Users\\srita\\Desktop\\Test Data.xlsx";
	static String uname = DataHandlers.readExcel(excel, "Sheet1", 1, 0);
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = TestConfiguration.getInstance();
		SWC_LoginScreen ls = new SWC_LoginScreen(driver);
			
		Thread.sleep(1000);
		ls.UsernameTextfield().sendKeys(uname);
		ls.PasswordTextfield().sendKeys(uname);
		
		driver.quit();
		
	}

}
