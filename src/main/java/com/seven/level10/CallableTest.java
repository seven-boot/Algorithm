package com.seven.level10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author QH
 * @date 2020/3/30
 * @description Callable 带返回值线程创建方式
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "aaa";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new CallableTest());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
