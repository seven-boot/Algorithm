package com.seven.level14;

/**
 * @author QH
 * @date 2020/4/13
 * @description FutureData 实现了一个快速返回的 RealData 包装。它只是一个包装，或者说是一个 RealData 的虚拟实现，因此，它可以很快
 * 被构造并返回。当使用 FutureData 的 getResult() 方法时，程序会阻塞，等待 RealData 被注入到程序中，才使用 RealData 的 getResult
 * 方法返回
 */
public class FutureData implements Data {

    RealData realData = null;
    boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        // RealData 已经被注入到 FutureData 中了，通知 getResult 方法
        notifyAll();
    }


    @Override
    public String getResult() throws InterruptedException {
        if (!isReady) {
            // 一直等待到RealData注入到FutureData中
            wait();
        }
        return realData.getResult();
    }
}
