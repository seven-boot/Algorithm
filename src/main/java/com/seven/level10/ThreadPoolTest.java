package com.seven.level10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author QH
 * @date 2020/3/30
 * @description 线程池使用跟不使用的区别
 */
public class ThreadPoolTest {

    // 不使用线程池

    /**
     * 结果：
     * 936
     * 10000
     * @param args
     * @throws InterruptedException
     */
    /*public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final List<Integer> l = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(l.size());
    }*/

    // 使用线程池

    /**
     * 结果：
     * 16
     * 10000
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final List<Integer> l = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(l.size());
    }
}
