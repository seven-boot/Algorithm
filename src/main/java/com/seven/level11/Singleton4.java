package com.seven.level11;

/**
 * @author QH
 * @date 2019/11/12
 * @description 饿汉式 变种  同：{@link Singleton3}
 *
 */
public class Singleton4 {

    private static Singleton4 instance = null;
    static {
        instance = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return instance;
    }
}
