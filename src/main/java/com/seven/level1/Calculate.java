package com.seven.level1;

/**
 * @author QH
 * @date 2019/9/19
 * @description 两个大数相乘
 */
public class Calculate {

    public static void main(String[] args) {
        String num1 = "123456789101112131415";
        String num2 = "151413121110987654321";
        System.out.println(multiply(num1, num2));
    }

    private static String multiply(String num1, String num2) {
        // 把字符串转成char数组
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        // 声明存放结果和
        int[] result = new int[chars1.length + chars2.length];
        int[] n1 = new int[chars1.length];
        int[] n2 = new int[chars2.length];

        // 把char转换成int数组
        for (int i = 0; i < chars1.length; i++) {
            n1[i] = chars1[i] - '0';
        }
        for (int j = 0; j < chars2.length; j++) {
            n2[j] = chars2[j] - '0';
        }

        // 逐个相乘
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
//                System.out.println(n1[i]);
//                System.out.println(n2[j]);
                result[i + j] += n1[i] * n2[j];
//                System.out.println(result[i+j]);
            }
        }

        // 从后往前，满十进位
        for (int i = result.length - 1; i > 0 ; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        // 转成String并返回
        String resultStr = "";
        for (int i = 0; i < result.length - 1; i++) {
            resultStr += "" + result[i];
        }

        return resultStr;
    }

}
