package com.clsaa.edu.pattern.th25_visitor.example02;

public class VisitorA implements Visitor {
    public void visit(ElementA element) {
        //把要访问elementA时,需要执行的新逻辑放在这里
        //也可以访问元素已有的功能
        element.operation();
    }

    public void visit(ElementB element) {
        //把要访问elementA时,需要执行的新逻辑放在这里
        //也可以访问元素已有的功能
        element.operation();
    }
}
