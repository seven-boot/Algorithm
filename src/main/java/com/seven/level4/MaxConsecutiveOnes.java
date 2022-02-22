package com.seven.level4;

/**
 * @author QH
 * @date 2020/5/25
 * @description 找出数组中最长的连续1
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     *
     * 示例 1:
     *
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * 注意：
     *
     * 输入的数组只包含 0 和1。
     * 输入数组的长度是正整数，且不超过 10,000。
     *
     * @param nums 给定数组
     * @return
     */
    /*private static int findMaxConsecutiveOnes(int[] nums) {
        int len = 0, max = 0;
        for (int num : nums) {
            len = num == 0 ? 0 : len + 1;
            max = Math.max(len, max);
        }
        return max;
    }*/

    private static int findMaxConsecutiveOnes(int[] nums) {
        int pre = -1, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(i - pre - 1, max);
                pre = i;
            }
        }
        return Math.max(nums.length - pre - 1, max);
    }
}
