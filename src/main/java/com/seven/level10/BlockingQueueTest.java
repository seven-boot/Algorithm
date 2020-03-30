package com.seven.level10;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author QH
 * @date 2020/3/30
 * @description 有两个线程 A、B。A线程每200ms就生成一个【0-100】之间的随机数，B线程每2s打印出A线程所产生的增量随机数。
 */
public class BlockingQueueTest {

    // 2s 时 200ms 的10倍，所以队列长度为 10
    private static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                int value = random.nextInt(101);
                System.out.println("生成的随机数：" + value);
                blockingQueue.offer(value);
            }
        }, 0, 200, TimeUnit.MILLISECONDS);// 每200ms执行一次

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    System.out.println("打印A线程生成的值");
                    List<Integer> list = new LinkedList<>();
                    blockingQueue.drainTo(list);
                    list.forEach(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
