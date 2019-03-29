package com.clsaa.edu.pattern.th05_singleton;

public class Singleton {
    private static class SingletonHolder {
        /**
         * 类初始化器，由JVM保证线程安全
         */
        private static Singleton instance = new Singleton();
    }

    /**
     * 私有化构造方法
     */
    private Singleton() {
        throw new UnsupportedOperationException();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
