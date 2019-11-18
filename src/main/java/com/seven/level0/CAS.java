package com.seven.level0;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author QH
 * @date 2019/10/23
 * @description CAS：比较并交换
 */
public class CAS {

    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {// 模拟网络延时
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left < 1) {
                    System.out.println("抢完了");
                    return;
                }
                System.out.print(Thread.currentThread().getName()+"抢了一件商品");
                System.out.println("还剩"+left);
            }).start();
        }
    }
}
