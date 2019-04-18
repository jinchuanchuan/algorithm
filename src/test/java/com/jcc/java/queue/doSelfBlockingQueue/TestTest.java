package com.jcc.java.queue.doSelfBlockingQueue;

import org.junit.Test;

/**
 * @description:
 * @author: jcc
 * @date: 2019-04-18 12:47
 * @Modified By:
 */
public class TestTest {
    @Test
    public void put() {
        ArrayQueue<String> queue = new ArrayQueue<>(3);
        queue.put("123");
        queue.put("456");
        queue.put("789");
        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.get());
        }
    }

}