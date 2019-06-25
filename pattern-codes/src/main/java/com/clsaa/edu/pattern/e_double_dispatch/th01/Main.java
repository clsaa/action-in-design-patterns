package com.clsaa.edu.pattern.e_double_dispatch.th01;

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();
        handler.handle(new Spi() {
        });
        handler.handle(new PlatformBundle());
        handler.handle(new PrivateBundle());

        Spi spi = new PrivateBundle();
        handler.handle(spi);
    }
}
