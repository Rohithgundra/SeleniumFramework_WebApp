package com.swc.testscripts;

import org.codehaus.plexus.util.Os;
import org.openqa.selenium.WebDriver;

import com.swc.common.TestConfiguration;
import com.swc.pompages.SWC_LoginScreen;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		SWC_LoginScreen sl;
		driver = TestConfiguration.getInstance();
		sl = new SWC_LoginScreen(driver);
		Thread.sleep(1000);
		sl.UsernameTextfield().sendKeys("hello");
		String s = sl.UsernamePlaceholder();
		String s1 = sl.PasswordPlaceholder();
		String s2 = sl.UsernameTextBoxAttribute();
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		
		String s3 = System.getProperty("os.name");
		String s4 = System.getProperty("os.version");
		System.out.println(s3);
		System.out.println(s4);
		driver.quit();
	}

}
