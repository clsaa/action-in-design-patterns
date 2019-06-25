package com.clsaa.edu.pattern.th25_visitor.example01;

public class PersonalCustomer extends Customer{
    @Override
    public void request() {
        System.out.println(this.getName()+" 个人客户提出请求");
    }
}
