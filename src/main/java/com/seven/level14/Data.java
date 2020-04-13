package com.seven.level14;

/**
 * @author QH
 * @date 2020/4/13
 * @description Data 提供了 getResult（） 方法，无论futureData 或者 RealData 都实现了这个接口
 */
public interface Data {

    String getResult() throws InterruptedException;
}
