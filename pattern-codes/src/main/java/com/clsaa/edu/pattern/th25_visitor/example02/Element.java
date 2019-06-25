package com.clsaa.edu.pattern.th25_visitor.example02;

/**
 * 被访问的元素的接口
 */
public abstract class Element {
    /**
     * 接收访问者的访问
     * @param visitor 访问者对象
     */
    public abstract void accept(Visitor visitor);
}
