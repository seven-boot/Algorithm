package com.seven.level0;

/**
 * @author QH
 * @date 2019/10/18
 * @description 线程不安全：数据有负数、相同
 */
public class UnsafeTest {

    public static void main(String[] args) {
        // 一份资源
        Unsafe12306 web = new Unsafe12306();
        // 多个代理
        new Thread(web, "黄1").start();
        new Thread(web, "黄2").start();
        new Thread(web, "黄3").start();
    }
}

class Unsafe12306 implements Runnable{

    private int ticketNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            test2();
        }
    }

    /*private synchronized void test() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        // 模拟延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
    }*/

    /**
     * 尽可能锁定合理的范围，范围（不是代码的范围，是指的数据的完整性）
     *
     * 下边这种方式采用双重校验锁，即double-checked locking
     * https://www.runoob.com/design-pattern/singleton-pattern.html
     *
     */
    public void test2() {
        if (ticketNums <= 0) {  // 考虑的是没有票的情况
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNums <= 0) {  // 考虑的是最后一张票的情况
                flag = false;
                return;
            }
            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }

    }
}