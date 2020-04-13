package com.seven.level13;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author QH
 * @date 2020/4/13
 * @description 自定义线程池
 */
public class CustomThreadPool01 {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 3, 60, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "thread-name");
                if (thread.getPriority() != Thread.NORM_PRIORITY) {
                    thread.setPriority(Thread.NORM_PRIORITY);
                }
                return thread;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("当前任务已经被拒绝：" + r);
            }
        });

        for (int i = 1; i < 10; i++) {
            poolExecutor.execute(new Task("task-" + i));
        }

        poolExecutor.shutdown();
    }
}

class Task implements Runnable {
    private String id;

    public Task(String id) {
        super();
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("当前任务被执行，任务id为：" + this.id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Task [id=" + id + "]";
    }
}

/*
当前任务已经被拒绝：Task [id=task-6]
当前任务已经被拒绝：Task [id=task-7]
当前任务已经被拒绝：Task [id=task-8]
当前任务已经被拒绝：Task [id=task-9]
当前任务被执行，任务id为：task-1
当前任务被执行，任务id为：task-4
当前任务被执行，任务id为：task-5
当前任务被执行，任务id为：task-2
当前任务被执行，任务id为：task-3

执行结果说明：
task-1：此时池中正好有一个线程，直接执行
task-2：大于corePoolSize，则将任务加入到任务队列，task-2 入队
task-3：还是加入队列
task-4：任务队列满了，创建新线程执行 task-4
task-5：线程数不大于 maximumPoolSize 继续创建新线程
task-6：线程数大于 maximumPoolSize，则执行拒绝策略
后面投递的任务都执行拒绝策略
 */