package com.seven.level12;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author QH
 * @date 2020/5/11
 * @description
 */
public class CyclicBarrierTest {

    private static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
            new One(cyclicBarrier, i).start();
            new Two(cyclicBarrier, i).start();
            new Three(cyclicBarrier, i).start();
        }

    }

    static class One extends Thread {
        private CyclicBarrier cyclicBarrier;
        private int num;
        public One(CyclicBarrier cyclicBarrier, int num) {
            this.cyclicBarrier = cyclicBarrier;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                int time = getRandom().nextInt(5000);
                Thread.sleep(time);
                System.out.println("小明翻越了第" +num+ "个障碍物，使用了" + time + "秒");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Two extends Thread {
        private CyclicBarrier cyclicBarrier;
        private int num;
        public Two(CyclicBarrier cyclicBarrier, int num) {
            this.cyclicBarrier = cyclicBarrier;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                int time = getRandom().nextInt(5000);
                Thread.sleep(time);
                System.out.println("小红翻越了第" +num+ "个障碍物，使用了" + time + "秒");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Three extends Thread {
        private CyclicBarrier cyclicBarrier;
        private int num;
        public Three(CyclicBarrier cyclicBarrier, int num) {
            this.cyclicBarrier = cyclicBarrier;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                int time = getRandom().nextInt(5000);
                Thread.sleep(time);
                System.out.println("小亮翻越了第" +num+ "个障碍物，使用了" + time + "秒");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
