package com.clsaa.edu.pattern.th01_simple_factory;

/**
 * @author joyren
 */
public class SimpleFactory {
    public static Api createApi(int condition) {
        Api api = null;
        if (condition == 1) {
            api = new ImplA();
        } else if (condition == 2) {
            api = new ImplB();
        }
        return api;
    }
}