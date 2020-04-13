package com.seven.level14;

/**
 * @author QH
 * @date 2020/4/13
 * @description main 函数主要负责调用Client发起请求，并使用返回的数据
 */
public class Main {

    public static void main(String[] args) {
        Client client = new Client();

        // 这里立即返回，因为获取的是 FutureData，而非 RealData
        Data data = client.request("name");
        System.out.println("请求完毕");

        try {
            // 其他业务处理，充分利用等待时间
            Thread.sleep(2000);

            // 使用真实数据
            System.out.println("数据=" + data.getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
