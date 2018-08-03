package com.swc.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers implements RelativePath {
	
	public static String getDataFromPropertyFile(String filename, String key) {
		
		String data = null;
		try {
			File f = new File(config_properties_path);
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			data = (String)prop.get(key);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	public static String readExcel(String filepath, String sheetName, int rowNum, int cellIndex) {
		
		String data = null;
		try {
			File f = new File(filepath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row rw = sh.getRow(rowNum);
			Cell c = rw.getCell(cellIndex);
			c.setCellType(Cell.CELL_TYPE_STRING);
			data = c.getStringCellValue();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
