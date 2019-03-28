package com.clsaa.edu.pattern.th01_simple_factory.th01_counter_example;


/**
 * @author joyren
 */
public class Impl implements Api {

    @Override
    public void print(String s) {
        System.out.println(s+" impl");
    }
}