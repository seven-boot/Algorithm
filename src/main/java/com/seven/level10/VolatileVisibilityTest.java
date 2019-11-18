package com.seven.level10;

/**
 * @author QH
 * @date 2019/11/18
 * @description volatile-可见性测试
 */
public class VolatileVisibilityTest {
    /**
     * Volatile缓存可见性实现原理：
     * 底层实现主要是通过汇编lock前缀指令，它会锁定这块内存区域的缓存（缓存行锁定）并回写到主内存
     * IA-32架构软件开发者手册对lock指令的解释：
     * 1、会将当前处理器缓存行的数据 立即 写回到系统内存
     * 2、这个写回内存的操作会引起在其他CPU里缓存了该地址的数据无效（MESI协议）
     */

    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting data...");
                while (!initFlag) {
                }
                System.out.println("======success");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                preparingData();
            }
        }).start();
    }

    static void preparingData() {
        System.out.println("preparing data...");
        initFlag = true;
        System.out.println("preparing data end...");
    }
}
