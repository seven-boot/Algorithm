package com.seven.level10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author QH
 * @date 2020/3/27
 * @description 手写一个线程池
 */
public class FixedSizeThreadPool {

    /**
     * 思考：
     * 1、需要一个仓库，存储任务队列
     * 2、需要一个存放线程的集合
     * 3、需要初始化仓库和线程集合
     * 4、需要向仓库放任务的方法，不阻塞返回一个特殊值
     * 5、需要向仓库放任务的方法，阻塞
     * 6、需要一个关闭线程池的方法
     */

    // 1、定义仓库
    private BlockingQueue<Runnable> blockingQueue;

    // 2、需要一个存放线程的集合
    private List<Thread> workers;

    // 执行者
    public static class Worker extends Thread {
        private FixedSizeThreadPool pool;

        public Worker(FixedSizeThreadPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            // 去仓库拿
            // 判断线程池是否已经准备关闭，以及线程池中是否还有未处理的线程
            while (this.pool.isWorking || this.pool.blockingQueue.size() > 0) {
                Runnable task = null;

                try {
                    if (this.pool.isWorking) {
                        task = this.pool.blockingQueue.take();
                    }
                    else {
                        task = this.pool.blockingQueue.poll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (task != null) {
                    task.run();
                    System.out.println("线程：" + Thread.currentThread().getName() + "执行完毕");
                }
            }
        }
    }

    // 3、需要初始化仓库和线程集合
    public FixedSizeThreadPool(int poolSize, int taskSize) {
        if (poolSize <= 0 || taskSize <= 0) {
            throw new IllegalArgumentException("非法参数");
        }
        this.blockingQueue = new LinkedBlockingDeque<>(taskSize);
        this.workers = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    // 4、需要向仓库放任务的方法，不阻塞返回一个特殊值
    public boolean submit(Runnable task) {
        if (this.isWorking) {
            return this.blockingQueue.offer(task);
        }
        else {
            return false;
        }
    }

    // 5、需要向仓库放任务的方法，阻塞
    public void execute(Runnable task) {
        try {
            this.blockingQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 6、需要一个关闭线程池的方法
    // a、仓库不能有新的线程进来
    // b、执行完仓库中剩余的线程
    // c、去仓库拿线程不能阻塞了
    // d、把阻塞的线程中断
    private volatile boolean isWorking = true;
    public void shutdown() {
        this.isWorking = false;

        for (Thread thread :
                workers) {
            if (thread.getState().equals(Thread.State.BLOCKED) || thread.getState().equals(Thread.State.WAITING)) {
                thread.interrupt();
            }
        }
    }




    public static void main(String[] args) {
        FixedSizeThreadPool pool = new FixedSizeThreadPool(3, 6);
        for (int i = 0; i < 6; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("一个线程被放到了仓库中");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("一个线程被唤醒了");
                    }
                }
            });
        }
        pool.shutdown();
    }
}
