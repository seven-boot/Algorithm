package com.seven.level11;

/**
 * @author QH
 * @date 2019/11/12
 * @description 枚举
 * 这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题,
 * 而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊，
 *
 */
public enum  Singleton6 {

    // 单例
    INSTANCE;

    public void whateverMethod() {
    }

}
