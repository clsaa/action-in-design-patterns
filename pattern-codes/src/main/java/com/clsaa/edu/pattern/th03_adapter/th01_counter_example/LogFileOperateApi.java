package com.clsaa.edu.pattern.th03_adapter.th01_counter_example;

import java.util.List;

public interface LogFileOperateApi {
    List<LogModel> readLogFile();

    void writeLogFile(List<LogModel> logs);
}
