package com.swc.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandlers {
	
	public static void selectDDLByIndex(WebElement ddl, int index) {
		Select set = new Select(ddl);
		set.selectByIndex(index);
	}
	
	public static void selectDDLByValue(WebElement ddl, String value) {
		Select set = new Select(ddl);
		set.selectByValue(value);
	}
	
	public static void selectDDLByVisibleText(WebElement ddl, String text) {
		Select set = new Select(ddl);
		set.selectByVisibleText(text);
	}
	
	public static void deSelectDDLByIndex(WebElement ddl, int index) {
		Select set = new Select(ddl);
		set.deselectByIndex(index);
	}
	
	public static void deSelectDDLByValue(WebElement ddl, String value) {
		Select set = new Select(ddl);
		set.deselectByValue(value);
	}
	
	public static void deSelectDDLByVisibleText(WebElement ddl, String text) {
		Select set = new Select(ddl);
		set.deselectByVisibleText(text);
	}
	
	public static void deSelectAll(WebElement ddl) {
		Select set = new Select(ddl);
		set.deselectAll();
	}

}
