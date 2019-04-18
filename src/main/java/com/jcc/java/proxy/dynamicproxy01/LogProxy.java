package com.jcc.java.proxy.dynamicproxy01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: jcc
 * @date: 2019-04-18 10:12
 * @Modified By:
 */
public class LogProxy implements InvocationHandler {
    Object target;

    public Object getProxyObject(Object obj) {
        this.target = obj;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前...");
        method.invoke(target,args);
        System.out.println("调用后...");
        return null;
    }

    public static void main(String[] args) {
        HelloWorldImpl helloWorld= new HelloWorldImpl();
        LogProxy logProxy = new LogProxy();
        HelloWorldInterface helloWorldInterface = (HelloWorldInterface) logProxy.getProxyObject(helloWorld);
        helloWorldInterface.sayHello();
    }
}
