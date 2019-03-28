package com.clsaa.edu.pattern.th02_facade.th01_counter_example;

/**
 * 配置管理模块
 */
public class ConfigManager {
    private volatile static ConfigManager configManager;
    private static ConfigModel configModel;

    private ConfigManager() {
    }

    public static ConfigManager getInstance() {
        if (ConfigManager.configManager == null) {
            synchronized (ConfigManager.class) {
                if (ConfigManager.configManager == null) {
                    ConfigManager.configManager = new ConfigManager();
                    ConfigManager.configModel = new ConfigModel();
                    //从配置文件加载配置
                    ConfigManager.configModel.setNeedGenPresentation(true);
                    ConfigManager.configModel.setNeedGenBusiness(true);
                    ConfigManager.configModel.setNeedGenDAO(true);
                }
            }
        }
        return ConfigManager.configManager;
    }


    public ConfigModel getConfigData() {
        return ConfigManager.configModel;
    }
}