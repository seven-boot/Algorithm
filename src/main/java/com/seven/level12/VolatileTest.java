package com.seven.level12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QH
 * @date 2020/4/1
 * @description 这种方式会牺牲部分CPU性能，因为 线程B 不断的通过while检测条件是否成立，这种方式会浪费 CPU 资源。
 *  就类似于现实生活中，某个人一直看着手机屏幕在等待是否有电话进来，而不是在干别的事情，当有电话来时，响铃通知
 */
public class VolatileTest {
    /**
     * 定义一个共享变量来实现通信
     */
    static volatile boolean notice = false;

    public static void main(String[] args) {
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
                    notice = true;
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                if (notice) {
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
}
