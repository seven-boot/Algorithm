package com.seven.level11;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author QH
 * @date 2019/11/12
 * @description 借助 CAS 实现单例
 */
public class Singleton8 {

    private static final AtomicReference<Singleton8> INSTANCE = new AtomicReference<Singleton8>();

    private Singleton8() {
    }

    public static Singleton8 getInstance() {
        for (;;) {
            Singleton8 instance = INSTANCE.get();
            if (instance != null) {
                return instance;
            }

            instance = new Singleton8();
            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }

    public static void main(String[] args) {
        Singleton8 instance1 = getInstance();
        Singleton8 instance2 = getInstance();
        System.out.println(instance1 == instance2);
    }
}
