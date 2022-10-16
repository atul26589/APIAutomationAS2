package com.tmb.constants;

import lombok.Getter;

public class FrameworkConstants {

	
	
	private static @Getter final String getRequestJSONFolderpath=System.getProperty("user.dir") + "/src/main/resources/";
	private static @Getter final String getResponseJSONFolderpath=System.getProperty("user.dir") + "/output/";
	private static @Getter final String propertyFilepath=System.getProperty("user.dir") + "/src/main/resources/config.properties";
}
