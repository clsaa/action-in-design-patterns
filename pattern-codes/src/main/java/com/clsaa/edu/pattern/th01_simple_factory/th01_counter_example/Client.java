package com.clsaa.edu.pattern.th01_simple_factory.th01_counter_example;

/**
 * @author joyren
 */
public class Client {
    public static void main(String[] args) {
        Api api = new Impl();
        api.print("hah");
    }
}
