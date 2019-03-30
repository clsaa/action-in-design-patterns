package com.clsaa.edu.pattern.th07_abstract_factory.example03;

/**
 * 抽象工厂的接口，声明创建抽象产品对象的操作
 */
public interface AbstractFactory {
	/**
	 * 创建CPU的对象
	 * @return CPU的对象
	 */
	public CPUApi createCPUApi();
	/**
	 * 创建主板的对象
	 * @return 主板的对象
	 */
	public MainboardApi createMainboardApi();
}