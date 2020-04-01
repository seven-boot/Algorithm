package com.seven.level12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QH
 * @date 2020/4/1
 * @description 使用Object类的wait和notify方法
 */
public class ObjectWithWatiAndNotifyTest {

    public static void main(String[] args) {
        // 定义一个锁对象
        Object lock = new Object();
        List<String> list = new ArrayList<>();

        // A
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    list.add("abc");
                    System.out.println("线程A添加了一个元素，list中元素个数为：" + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == 5) {
                        // 唤醒 B线程
                        lock.notify();
                        // A线程等待
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });

        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() != 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程B收到通知，开始执行自己的业务");
                        // 继续唤醒A线程，或者A线程通知到B线程的时候，并不用wait，这里就不用notify了
                        lock.notify();
                        break;
                    }
                }
            }
        });

        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }


    /**
     * 线程A添加了一个元素，list中元素个数为：1
     * 线程A添加了一个元素，list中元素个数为：2
     * 线程A添加了一个元素，list中元素个数为：3
     * 线程A添加了一个元素，list中元素个数为：4
     * 线程A添加了一个元素，list中元素个数为：5
     * 线程A添加了一个元素，list中元素个数为：6
     * 线程A添加了一个元素，list中元素个数为：7
     * 线程A添加了一个元素，list中元素个数为：8
     * 线程A添加了一个元素，list中元素个数为：9
     * 线程A添加了一个元素，list中元素个数为：10
     * 线程B收到通知，开始执行自己的业务
     *
     * 由打印结果可知，在线程A 发出notify 唤醒提醒后，依然走完了自己线程的业务之后，
     * 线程B 才开始执行，这也正好说明了，notify 方法不释放锁，而 wait 方法释放锁
     *
     */
}
