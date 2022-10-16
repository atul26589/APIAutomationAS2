package com.tmb.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;

import enums.PropertiesType;

public class PropertyUtils {

	private PropertyUtils() {}
	// read the content only once and store it in java collection(hashmap)
private static Properties properties=new Properties();
	private static Map<String,String> MAP=new HashMap<>();
	
	 static  {
	
		//FileInputStream inputStream = null;
		try(FileInputStream inputStream = new FileInputStream(FrameworkConstants.getPropertyFilepath())) {
			properties.load(inputStream);
			//inputStream = new FileInputStream("");
		} 
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		properties.entrySet().forEach(e->MAP.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));
}
	
	public static String getValue(PropertiesType key) {
		return MAP.get(key.name().toLowerCase());
	}

}
