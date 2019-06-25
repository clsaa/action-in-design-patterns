package com.clsaa.edu.pattern.th25_visitor.example01;

public class EnterpriseCustomer extends Customer {
    @Override
    public void request() {
        System.out.println(this.getName() + " 企业提出服务请求");
    }
}
