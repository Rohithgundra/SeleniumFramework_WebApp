package com.swc.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataHandlers {
	
	public static String getDataFromPropertyFile(String filename, String key) {
		
		String data = null;
		try {
			File f = new File("C:\\Users\\user\\OneDrive - Unizen Technologies\\SmartWaterController\\UZ_SWC_SeleniumTool\\data\\"+filename+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			data = (String)prop.get(key);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
