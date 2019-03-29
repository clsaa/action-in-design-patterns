package com.clsaa.edu.pattern.th05_singleton.example03;


public class Client {
	public static void main(String[] args) {
		//创建读取应用配置的对象
		AppConfig config = AppConfig.getInstance();
		String paramA = config.getParameterA();
		String paramB = config.getParameterB();
		System.out.println("paramA="+paramA+",paramB="+paramB);
	}
}