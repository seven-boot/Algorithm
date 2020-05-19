package com.seven.level4;

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
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int item :
                nums) {
            System.out.println(item);
        }
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int item :
                nums) {
            if (item != 0) {
                nums[index++] = item;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
