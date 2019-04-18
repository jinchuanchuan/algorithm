package com.jcc.java.queue.doSelfBlockingQueue;

/**
 * @description:
 * @author: jcc
 * @date: 2019-04-18 11:38
 * @Modified By:
 */
public class ArrayQueue<E> {
    /**
     * 队列数量
     */
    private int count = 0;
    /**
     * 最终的数据存储
     */
    private Object[] items;
    /**
     * 队列满时的阻塞锁
     */
    private Object full = new Object();
    /**
     * 队列空时的阻塞锁
     */
    private Object empty = new Object();
    /**
     * 写入数据时的下标
     */
    private int putIndex;
    /**
     * 获取数据时的下标
     */
    private int getIndex;

    /**
     * 构造函数
     * @param size
     */
    public ArrayQueue(int size) {
        items = new Object[size];
    }

    /**
     * 从队列尾部写入数据
     * @param e
     */
    public void put(E e){
        //1.队列满时，禁止写,写入的线程需要被阻塞。
        synchronized(full){
            while (count == items.length) {
                try {
                    full.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
        //2.队列达到最大的时，要从头写入
        synchronized(empty) {
            items[putIndex] = e;
            count++;
            putIndex++;
            if(count == items.length) {
                putIndex = 0;
            }

            empty.notify();
        }
    }

    /**
     * 从队列头获取数据
     * @return E
     * 当队列为空时，获取队列的线程需要被阻塞，直到队列中有数据时才被唤醒
     */
    public E get() {
        synchronized(empty) {
            if(count == 0){
                try {
                    empty.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            return null;
            }
        }
        synchronized (full) {
            Object result = items[getIndex];
            items[getIndex] = null;
            count--;
            getIndex++;
            if(getIndex == items.length) {
                getIndex = 0;
            }
            full.notify();
            return (E)result;
        }
    }
    public int size(){
        return items.length;
    }

    public boolean isEmpty(){
        if (items.length <= 0) {
            return true;
        }
        return false;
    }
}
