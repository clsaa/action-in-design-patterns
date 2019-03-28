package com.clsaa.edu.pattern.th02_facade.th01_counter_example;

/**
 * 生成业务层代码的模块
 */
public class Business {
    public void generate(){
        //1.从配置管理类获取配置信息
        ConfigModel configModel = ConfigManager.getInstance().getConfigData();
        //2.生成代码
        if (configModel.isNeedGenPresentation()){
            System.out.println("生成业务层代码");
        }
    }
}