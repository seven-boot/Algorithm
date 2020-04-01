package com.seven.level12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author QH
 * @date 2020/4/1
 * @description LockSupport 实现线程间阻塞和唤醒
 */
public class LockSupportTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Thread threadB = new Thread(() -> {
                if (list.size() != 5) {
                    LockSupport.park();
                }
            System.out.println("线程B收到通知，开始执行自己的业务");
        });

        // A
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add("abc");
                System.out.println("线程A添加了一个元素，list中元素个数为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5) {
                    LockSupport.unpark(threadB);
                }
            }
        });

        threadA.start();
        threadB.start();
    }


    /**
     * 线程A添加了一个元素，list中元素个数为：1
     * 线程A添加了一个元素，list中元素个数为：2
     * 线程A添加了一个元素，list中元素个数为：3
     * 线程A添加了一个元素，list中元素个数为：4
     * 线程A添加了一个元素，list中元素个数为：5
     * 线程A添加了一个元素，list中元素个数为：6
     * 线程B收到通知，开始执行自己的业务
     * 线程A添加了一个元素，list中元素个数为：7
     * 线程A添加了一个元素，list中元素个数为：8
     * 线程A添加了一个元素，list中元素个数为：9
     * 线程A添加了一个元素，list中元素个数为：10
     *
     * LockSupport 是一种非常灵活的实现线程间阻塞和唤醒的工具，使用它不用关注是等待线程先进行还是唤醒线程先运行，
     * 但是得知道线程得名字。
     */
}
