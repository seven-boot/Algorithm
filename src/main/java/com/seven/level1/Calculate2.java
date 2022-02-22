package com.seven.level1;

/**
 * @author QH
 * @date 2019/9/19
 * @description 两个大数相乘
 */
public class Calculate2 {

    public static void main(String[] args) {
        String num1 = "990";
        String num2 = "1234";
        System.out.println(addStrings(num1, num2));
    }

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 注意：
     *
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     *
     * @param num1
     * @param num2
     * @return
     */
    private static String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int max = Math.max(chars1.length, chars2.length);
        int min = Math.min(chars1.length, chars2.length);
        int[] result1 = new int[max];
        int[] n1 = new int[chars1.length];
        int[] n2 = new int[chars2.length];

        for (int i = 0; i < chars1.length; i++) {
            n1[chars1.length - 1 - i] = chars1[i] - '0';
        }
        for (int i = 0; i < chars2.length; i++) {
            n2[chars2.length - 1 - i] = chars2[i] - '0';
        }

        for (int i = 0; i < min; i++) {
            result1[i] = n1[i] + n2[i];
        }
        if (max > min) {
            for (int i = min; i < max; i++) {
                result1[i] = n1.length > n2.length ? n1[i] : n2[i];
            }
        }

        int length = result1.length;
        for (int i = 0; i < length; i++) {
            int tmp = result1[i];
            result1[i] = result1[result1.length - 1 - i];
            result1[result1.length - 1 - i] = tmp;
            length--;
        }


        for (int i = result1.length - 1; i > 0; i--) {
            result1[i - 1] += result1[i] / 10;
            result1[i] = result1[i] % 10;
        }

        String str = "";
        for (int i = 0; i < result1.length; i++) {
            str += "" + result1[i];
        }

        return str;
    }

}
