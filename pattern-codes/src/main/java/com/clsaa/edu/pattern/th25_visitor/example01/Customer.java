package com.clsaa.edu.pattern.th25_visitor.example01;

import lombok.Getter;
import lombok.Setter;

/**
 * 各种客户的父类
 */

@Getter
@Setter
public abstract class Customer {
    private String id;
    private String name;

    /**
     * 客户提出服务请求的方法
     */
    public abstract void request();
}
