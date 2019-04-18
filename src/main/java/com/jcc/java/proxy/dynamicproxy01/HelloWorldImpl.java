package com.jcc.java.proxy.dynamicproxy01;

/**
 * @description:
 * @author: jcc
 * @date: 2019-04-18 10:11
 * @Modified By:
 */
public class HelloWorldImpl implements HelloWorldInterface{
    @Override
    public void sayHello() {
        System.out.println("hello world！");
    }
}
