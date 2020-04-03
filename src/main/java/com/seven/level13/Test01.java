package com.seven.level13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author QH
 * @date 2020/4/2
 * @description 随机填充1-10000的一万个数字到数组中，要求全部填充且不能有序
 */
public class Test01 {

    static volatile List<Integer> list = new ArrayList<>(10000);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            CountRunnable runnable = new CountRunnable((i -1) * 1000 + 1, i * 1000);
            pool.execute(runnable);
        }
        pool.shutdown();
    }
}

class CountRunnable implements Runnable {
    
    private int start;
    private int end;

    public CountRunnable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {

            System.out.println(i + 1);
        }
    }
}
