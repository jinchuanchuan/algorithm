package com.jcc.java.proxy.cglib;

/**
 *  cglib是针对类来实现代理的，原理是对指定的业务类生成一个子类，并覆盖其中业务方法实现代理。因为采用的是继承，所以不能对final修饰的类进行代理。
 */
public class Test {
    public static void main(String[] args) {
        BookImpl book = new BookImpl();
        BookCglib bookCglib = new BookCglib();
        BookImpl book1 = (BookImpl) bookCglib.getInstance(book);
        book.addBook();
    }
}
