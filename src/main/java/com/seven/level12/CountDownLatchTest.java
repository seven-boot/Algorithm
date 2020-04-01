package com.seven.level12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author QH
 * @date 2020/4/1
 * @description JUC 工具类 CountDownLatch
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(1);
        List<String> list = new ArrayList<>();

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
                    count.countDown();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                if (list.size() != 5) {
                    try {
                        count.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程B收到通知，开始执行自己的业务");
                    break;
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
     * 运行结果：
     *
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
     *
     */
}
