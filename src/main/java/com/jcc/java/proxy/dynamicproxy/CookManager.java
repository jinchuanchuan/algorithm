package com.jcc.java.proxy.dynamicproxy;

public class CookManager implements ICook {
    @Override
    public void dealWithFood() {
        System.out.println("food had been dealed with");
    }

    @Override
    public void cook() {
        System.out.println("cook food");
    }
}
