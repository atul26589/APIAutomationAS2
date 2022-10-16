package com.tmb.constants;

import lombok.Getter;

//Singleton-->Single Instance for an class at a particular point of time
//creational design pattern

@Getter
public class FrameworkConstantswithSingleton {
	private static  FrameworkConstantswithSingleton INSTANCE=null;
	private FrameworkConstantswithSingleton() {}
	
	public static synchronized FrameworkConstantswithSingleton getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new FrameworkConstantswithSingleton();
		}
		return INSTANCE;
	}
	private  final String getRequestJSONFolderpath=System.getProperty("user.dir") + "/src/main/resources/";
	private  final String getResponseJSONFolderpath=System.getProperty("user.dir") + "/output/";

}
