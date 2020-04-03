package com.seven.level13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author QH
 * @date 2020/4/2
 * @description
 */
public class Test02 {

    static volatile List<Integer> list = new ArrayList<>(10000);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            FutureTask task = new FutureTask(new CountCallable((i - 1) * 1000 + 1, i * 1000));
            pool.execute(task);
            System.out.println(task.get());
        }
        pool.shutdown();
    }


}

class CountCallable implements Callable<List<Integer>> {

    private int start;
    private int end;

    public CountCallable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
//            System.out.println(i + 1);
        }
        return list;
    }
}