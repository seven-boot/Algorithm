package com.seven.level12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author QH
 * @date 2020/4/1
 * @description
 */
public class ReentrantLockAndConditionTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        List<String> list = new ArrayList<>();

        // A
        Thread threadA = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                list.add("abc");
                System.out.println("线程A添加了一个元素，list中元素个数为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5) {
                    condition.signal();
                }
            }
            lock.unlock();
        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            if (list.size() != 5) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程B收到通知，开始执行自己的业务");
                lock.unlock();
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
     *
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
     * 显然这种方式使用起来并不是很好，代码编写复杂，而且线程B在被线程A唤醒之后，由于没有获得锁还是不能立即执行，
     * 也就是说，A在唤醒操作之后，并不释放锁。这种方式跟 Object 的 wait 和 notify 一样
     */
}
