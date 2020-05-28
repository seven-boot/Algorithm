package com.seven.level4;

import java.util.Arrays;

/**
 * @author QH
 * @date 2020/5/18
 * @description 把数组中的 0 移到末尾
 */
public class MoveZeroes {
    /**
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     * 解题思路：首先题目并没有要求排序，不考虑排序的情况下
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 0, 32, 9};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int num :
                nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
