package com.clsaa.edu.pattern.e_double_dispatch.th02;

public class PrivateBundle implements Spi {
    public void doSomething(Handler handler) {
        handler.handle(this);
    }
}


