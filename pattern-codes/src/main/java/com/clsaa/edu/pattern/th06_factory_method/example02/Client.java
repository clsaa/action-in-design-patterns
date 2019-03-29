package com.clsaa.edu.pattern.th06_factory_method.example02;

public class Client {
    public static void main(String[] args) {
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportDBOperate();
        //调用输出数据的功能方法
        operate.export("测试数据");
    }
}