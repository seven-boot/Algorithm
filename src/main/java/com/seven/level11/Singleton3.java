package com.seven.level11;

/**
 * @author QH
 * @date 2019/11/12
 * @description 饿汉式
 * 这种方式基于类加载机制避免了多线程的同步问题，不过instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
 * 在单例模式种大多数都是调用getInstance 方法，但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
 * 这时候初始化instance显然没有达到lazy loading 的效果
 */
public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
