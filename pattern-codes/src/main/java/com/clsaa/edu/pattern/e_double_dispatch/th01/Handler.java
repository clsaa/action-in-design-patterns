package com.clsaa.edu.pattern.e_double_dispatch.th01;


public class Handler {

    public void handle(Spi spi) {
        System.out.println("It is spi");
    }

    public void handle(PrivateBundle event) {
        System.out.println("It is PrivateBundle");
    }

    public void handle(PlatformBundle event) {
        System.out.println("It is PlatformBundle");
    }
}

