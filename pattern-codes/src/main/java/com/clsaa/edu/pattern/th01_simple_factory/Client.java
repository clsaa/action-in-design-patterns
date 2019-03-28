package com.clsaa.edu.pattern.th01_simple_factory;

public class Client {
    public static void main(String[] args) {
        Api api = SimpleFactory.createApi(1);
        api.print("haha");
    }
}
