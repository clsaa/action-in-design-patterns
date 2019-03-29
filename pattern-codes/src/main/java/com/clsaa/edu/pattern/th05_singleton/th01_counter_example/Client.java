package com.clsaa.edu.pattern.th05_singleton.th01_counter_example;

public class Client {
	public static void main(String[] args) {
		//创建读取应用配置的对象
		AppConfig config = new AppConfig();
		
		String paramA = config.getParameterA();
		String paramB = config.getParameterB();
		
		System.out.println("paramA="+paramA+",paramB="+paramB);
		
		
	}
}