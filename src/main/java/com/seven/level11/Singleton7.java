package com.seven.level11;

/**
 * @author QH
 * @date 2019/11/12
 * @description 双重检验锁
 * 第二种方式的升级版 {@link Singleton2}
 */
public class Singleton7 {

    private volatile static Singleton7 instance;

    private Singleton7() {
    }

    public static Singleton7 getInstance() {
        if (instance == null) {
            synchronized (Singleton7.class) {
                if (instance == null) {
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }

    /**
     *  七种单例设计模式：
     * @see Singleton1
     * @see Singleton2
     * @see Singleton3
     * @see Singleton4
     * @see Singleton5
     * @see Singleton6
     * @see Singleton7
     * 总结：
     * 一般情况下，不建议使用第1种和第2种懒汉方式，建议使用饿汉方式。
     * 只有在要明确实现lazy loading 效果时，才会使用静态内部类方式。
     * 如果涉及到反序列化创建对象时，可以尝试使用枚举方式。如果有其它特殊的需求，可以考虑使用双检锁方式
     */
}
