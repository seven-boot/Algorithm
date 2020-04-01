package com.seven.level12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author QH
 * @date 2020/4/1
 * @description FutureTask 使用举例
 */
public class UseFutureTest implements Callable<String> {
    private String query;
    private long queryTime;

    public UseFutureTest(String query, long queryTime) {
        this.query = query;
        this.queryTime = queryTime;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(queryTime);
        return this.query + "执行完成";
    }

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask1 = new FutureTask<>(new UseFutureTest("query1", 5000));
        FutureTask<String> futureTask2 = new FutureTask<>(new UseFutureTest("query2", 10000));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(futureTask1);
        executorService.submit(futureTask2);
        executorService.shutdown();

        Thread.sleep(2000);
        System.out.println("2秒之后阻塞获取任务结果");

        System.out.println("-------------");
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
    }


    /**
     * Future 设计模式是一种提高性能的编程模式，FutureTask 类就是实现这种方式的封装类，
     * 它的主要思想是：如果有一个很耗时的操作，就开一个线程去做它，主线程继续执行后续的操作，等主线程执行完后，再调用方法去获取那个线程的执行结果，
     * 如果那个线程还没执行完，主线程阻塞等待。这是一种并行的方式，可以在程序中使用以提高系统响应速度。
     * 注意：
     * 1、自己定义的任务需要实现Callable、或者Runnable接口（实现Callable接口可以有明确的返回值，并且可以抛出异常）
     * 2、FutureTask需要使用线程池提交，而不能使用start 方法启动任务，使用完线程池记得关闭
     */
}
