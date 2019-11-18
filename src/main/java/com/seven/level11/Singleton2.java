package com.seven.level11;

/**
 * @author QH
 * @date 2019/11/12
 * @description 懒汉式，线程安全 lazy loading
 * 这种写法是线程安全的，但是效率很低，因为99%的情况下是不需要同步的
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
