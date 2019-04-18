package com.jcc.java.queue.doSelfBlockingQueue;

/**
 * @description: 自定义实现阻塞队列
 * https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484984&idx=1&sn=0d06df51824fff38ff678030aa467a63&chksm=fba6ee3bccd1672d37a7d7598a91026819fe0533c6752088efe9ec67d138d230fb9d45f822e7&mpshare=1&scene=1&srcid=0413lsQd00ecXTR0KouYoHMF&key=a9d4b584c7843618fc35abea4d3364fdec1faaa088feb5d6b14585b528b7ac9e2cbbae835b72471ae1e5f1648139055f997c2ffc462e2893328a0620902c1937ecb0425cf5827b9babc5fe823fa62f59&ascene=1&uin=MTYxNjc4MDExOQ%3D%3D&devicetype=Windows+10&version=62060739&lang=zh_CN&pass_ticket=rBpZrNeHVmE5XVrNqtHLXs4mmGko40sJnjoA6mc4KcYwEHAuxqRsK9vCAoLrHJmc
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
