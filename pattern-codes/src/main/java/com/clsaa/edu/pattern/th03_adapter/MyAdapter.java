package com.clsaa.edu.pattern.th03_adapter;

import com.clsaa.edu.pattern.th03_adapter.th01_counter_example.LogFileOperateApi;
import com.clsaa.edu.pattern.th03_adapter.th01_counter_example.LogModel;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends DefaultAdapter{
	/**
	 * 持有需要被适配的接口对象
	 */
	private LogFileOperateApi adaptee;
	
	private TimeUtil adaptee2 = null;
	/**
	 * 构造方法，传入需要被适配的对象
	 * @param adaptee 需要被适配的对象
	 */
	public MyAdapter(LogFileOperateApi adaptee,TimeUtil times) {
		this.adaptee = adaptee;
		this.adaptee2 = times;
	}
	


	@Override
	public List<LogModel> getAllLog() {
		return adaptee.readLogFile();
	}

	@Override
	public void removeLog(LogModel lm) {
		//1：先读取文件的内容
		List<LogModel> list = adaptee.readLogFile();
		//2：删除相应的日志对象
		list.remove(lm);
		//3：重新写入文件
		adaptee.writeLogFile(list);
	}
}