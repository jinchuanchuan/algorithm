package com.jcc.java.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        CookManager cookManager = new CookManager();
        DynamicProxyHandle dynamicProxyHandle = new DynamicProxyHandle(cookManager);
        ICook cook = (ICook) Proxy.newProxyInstance(dynamicProxyHandle.getClass().getClassLoader(),cookManager.getClass().getInterfaces(), dynamicProxyHandle);
        System.out.println(cook.getClass().getName());
        cook.dealWithFood();
        System.out.println("--------------------------------------");
        cook.cook();
    }
}
