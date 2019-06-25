package com.clsaa.edu.pattern.th25_visitor.example02;

public class ElementB extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operation() {
        System.out.println("element b");
    }
}
