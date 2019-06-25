package com.clsaa.edu.pattern.e_double_dispatch.th02;

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();
        new PlatformBundle().doSomething(handler);
        Spi platformBundle = new PlatformBundle();
        platformBundle.doSomething(handler);

        new PrivateBundle().doSomething(handler);
        Spi privateBundle = new PrivateBundle();
        privateBundle.doSomething(handler);
    }
}
