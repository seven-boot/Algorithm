package com.seven.level14;

/**
 * @author QH
 * @date 2020/4/13
 * @description Client 主要实现了获取 FutureData，开启构造 RealData 的线程，并在接受请求后，很快返回 FutureData
 */
public class Client {

    public Data request(final String string) {
        final FutureData futureData = new FutureData();

        // ReadData 的构建很慢，所以放到单独的线程中运行
        new Thread(() -> {
            RealData realData = new RealData(string);
            futureData.setRealData(realData);
        }).start();

        // 不用等
        return futureData;
    }
}
