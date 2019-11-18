package com.seven.level11;

/**
 * @author QH
 * @date 2019/11/12
 * @description 静态内部类
 * 这种方式同样利用了classloader 的机制来保证初始化instance时只有一个线程，它跟第三种和第四种方式不同的是（很细微的差别）：
 * 第三种和第四种方式是只要Singleton类被加载了，那么instance就会被实例化（没有达到lazy loading效果），
 * 而这种方式是Singleton类被装载了，instance不一定被初始化。因为SingletonHolder 类没有被主动使用，只有显式通过调用getInstance方法时，
 * 才会显式装载SingletonHolder类，从而实例化instance。想象一下，如果实例化instance很消耗资源，我想让它延迟加载，
 * 另外一方面。我不希望在Singleton类加载时就实例化，因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，
 * 那么这个时候实例化instance显然是不合适的。这个时候，这种方式相比第三和第四种方式就显得很合理。
 */
public class Singleton5 {

    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
