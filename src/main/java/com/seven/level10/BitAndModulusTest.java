package com.seven.level10;

/**
 * @author QH
 * @date 2019/11/14
 * @description 位运算和取模运算耗时对比
 */
public class BitAndModulusTest {

    public static void main(String[] args) {
        System.out.println("位运算耗时："+bit());
        System.out.println("取模运算耗时："+modulus());
        /**
         * 位运算耗时：622
         * 取模运算耗时：15464
         */
    }

    /**
     * 位运算
     *
     * @return 位运算耗时
     */
    public static long bit() {
        int number = 10_000 * 10;
        int a = 1;
        long start = System.currentTimeMillis();
        for (int i = number; i > 0; i++) {
            a = a & i;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * 取模运算
     *
     * @return 取模运算耗时
     */
    public static long modulus() {
        int number = 10_000 * 10;
        int a = 1;
        long start = System.currentTimeMillis();
        for (int i = number; i > 0; i++) {
            a %= i;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
