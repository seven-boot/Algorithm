package com.seven.level10;

/**
 * @author QH
 * @date 2019/11/18
 * @description volatile-原子性测试
 */
public class VolatileAtomicTest {

    public static volatile int num = 0;

    public static void increase() {
        num++;  // num = num + 1
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(num);    // 1000*10
    }
}
