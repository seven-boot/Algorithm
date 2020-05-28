package com.seven.level4;

/**
 * @author QH
 * @date 2020/5/25
 * @description 找出数组中最长的连续1 II
 */
public class MaxConsecutiveOnesII {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 1, 0, 1};
//        int[] nums = {1, 0, 0, 1, 1, 1, 1, 0, 0, 1};
        System.out.println(findMaxConsecutiveOnesII(nums));
    }

    /**
     * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
     *
     * 示例 1：
     *
     * 输入：[1,0,1,1,0]
     * 输出：4
     * 解释：翻转第一个 0 可以得到最长的连续 1。
     *      当翻转以后，最大连续 1 的个数为 4。
     *  
     *
     * 注：
     *
     * 输入数组只包含 0 和 1.
     * 输入数组的长度为正整数，且不超过 10,000
     */


    /**
     * 方法一：使用双指针，left = 0，right = 0；zeros 记录 left 和 right 之间 0 的个数。left 和 right 相当于滑动窗口
     * 1、当 zeros == 0 时，right 一直往右扩展，直到遇到 0 或者到达终点，此时如果 right 的下一位为 1 的时候，right 继续往右移动，
     * 直到 right 遇到第 2 个 0，此时 left 和 right 之间只有一个 0，计算窗口的大小，取最大值
     * 2、当 zeros == 1 时，left 往右收缩，直到 left 遇到 0，zeros = zeros - 1 = 0.此时进入下一轮循环，直到 right 到达终点
     *
     * @param nums
     * @return
     */
    private static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, max = 0, zeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[left++] == 0) {
                    zeros--;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    /**
     * 方法二、类似动态规划，使用两个变量 dp0、dp1 分别记录当前位置 i 不含有 0 的最大子数组长度、含一个 0 的最大子数组长度。
     * 当 i == 1，dp0 = dp0 + 1，dp1 = dp1 + 1
     * 当 i == 0，dp0 = 0，dp1 = dp0 + 1.由于 dp1 之前已经含有一个 0 了，所以再遇到 0 需要更新成 dp0（不含0） 并且加 1（相当于当前 dp1 又含了个 0），
     * 然后 dp0 初始化成 0（因为 dp0 不能含有 0）
     *
     * 另外定义一个变量保存 dp1 的最大值
     *
     * @param nums
     * @return
     */
    private static int findMaxConsecutiveOnesII(int[] nums) {
        int dp1 = 0, dp0 = 0, max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                dp1 = dp1 + 1;
                dp0 = dp0 + 1;
            } else {
                dp1 = dp0 + 1;
                dp0 = 0;
            }
            max = Math.max(dp1, Math.max(max, dp0));
        }
        return max;
    }
}
