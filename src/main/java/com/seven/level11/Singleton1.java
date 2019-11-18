package com.seven.level11;

/**
 * @author QH
 * @date 2019/11/12
 * @description 单例模式（懒汉式、线程不安全） lazy loading
 *  在多线程下不能正常工作
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 instance1 = getInstance();
        Singleton1 instance2 = getInstance();
        System.out.println(instance1 == instance2);
    }
}
