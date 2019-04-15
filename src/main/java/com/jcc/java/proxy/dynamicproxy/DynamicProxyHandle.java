package com.jcc.java.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandle implements InvocationHandler {

    Object realCookManager;

    public DynamicProxyHandle(CookManager cookManager){
        this.realCookManager = cookManager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke start");
        System.out.println(method.getName());
        method.invoke(realCookManager,args);
        System.out.println("invoke end");
        return null;
    }
}
