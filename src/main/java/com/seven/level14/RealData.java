package com.seven.level14;

/**
 * @author QH
 * @date 2020/4/13
 * @description RealData 是最终需要使用的数据模型，它的构造很慢
 */
public class RealData implements Data {

    protected String data;

    public RealData(String data) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
    }

    @Override
    public String getResult() throws InterruptedException {
        return data;
    }
}
