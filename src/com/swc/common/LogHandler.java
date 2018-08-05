package com.swc.common;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogHandler implements RelativePath {
	
	static Logger log;
	
	public static void getLogs(String className) {
		
		log = Logger.getLogger(className);
		
		PropertyConfigurator.configure(log_properties_path);
		
	}
	
	public static void logInfo(String msg) {
		
		log.info(msg);
	}
	
	public static void logError(String msg) {
		log.error(msg);
	}

}
