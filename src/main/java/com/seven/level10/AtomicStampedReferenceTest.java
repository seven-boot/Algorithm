package com.seven.level10;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author QH
 * @date 2019/10/21
 * @description 解决atomic类 cas操作 ABA 问题，解决方式是在更新时设置版本号的方式来解决，每次更新就要设置一个不一样的版本号，
 * 修改的时候，不但要比较值有没有变，还要比较版本号对不对
 */
public class AtomicStampedReferenceTest {

    final static AtomicStampedReference<String> ATOMIC_REFERENCE = new AtomicStampedReference<>("jack", 0);
    final static AtomicMarkableReference<String> ATOMIC_MARKABLE_REFERENCE = new AtomicMarkableReference<>("jack", false);

    /*public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int num = i;
            final int stamp = ATOMIC_REFERENCE.getStamp();
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Math.abs((int) (Math.random() * 100)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (ATOMIC_REFERENCE.compareAndSet("jack", "nick", stamp, stamp + 1)) {
                        System.out.println("我是线程："+num+",我获得了锁进行了对象修改！");
                    }
                }
            }.start();
        }
        new Thread() {
            @Override
            public void run() {
                int stamp = ATOMIC_REFERENCE.getStamp();
                while (!ATOMIC_REFERENCE.compareAndSet("nick", "jack", stamp, stamp + 1));
                System.out.println("已经改回为原始值！");
            }
        }.start();
    }*/

    public static void main(String[] args) {
        System.out.println("mark:"+ATOMIC_MARKABLE_REFERENCE.isMarked());
        boolean thread1 = ATOMIC_MARKABLE_REFERENCE.isMarked();
        System.out.println("mark:"+ATOMIC_MARKABLE_REFERENCE.isMarked());
        boolean thread2 = ATOMIC_MARKABLE_REFERENCE.isMarked();
        System.out.println("change result:"+ATOMIC_MARKABLE_REFERENCE.compareAndSet("jack", "nick", thread1, !thread1));

        System.out.println("mark:"+ATOMIC_MARKABLE_REFERENCE.isMarked());
        boolean thread3 = ATOMIC_MARKABLE_REFERENCE.isMarked();
        System.out.println("change result:"+ATOMIC_MARKABLE_REFERENCE.compareAndSet("nick", "jack", thread3, !thread3));

        System.out.println("change result:"+ATOMIC_MARKABLE_REFERENCE.compareAndSet("jack", "nick", thread2, !thread2));
    }
}
