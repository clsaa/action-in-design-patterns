package com.clsaa.edu.pattern.th25_visitor.example02;

public class ElementA extends Element {
    @Override
    public void accept(Visitor visitor) {
        //回调访问者对象相应方法
        visitor.visit(this);
    }

    public void operation() {
        System.out.println("element a");
    }
}
