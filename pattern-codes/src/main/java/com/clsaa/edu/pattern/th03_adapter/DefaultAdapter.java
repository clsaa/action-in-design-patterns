package com.clsaa.edu.pattern.th03_adapter;

import com.clsaa.edu.pattern.th03_adapter.th01_counter_example.LogModel;

import java.util.List;

public class DefaultAdapter implements LogDbOperateApi{

	@Override
	public void createLog(LogModel lm) {
		System.out.println("DB createLog===========");
	}

	@Override
	public void updateLog(LogModel lm) {
		System.out.println("DB updateLog===========");
	}

	@Override
	public void removeLog(LogModel lm) {
		
	}

	@Override
	public List<LogModel> getAllLog() {
		return null;
	}

}