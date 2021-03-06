package com.seven.level4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author QH
 * @date 2020/5/18
 * @description 原地删除数组中重复的数字
 */
public class RemoveDuplicateNum {
    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 题解：可以使用（双指针法）快慢指针，i j ，只要nums[i] == nums[j]，增加 j 跳过重复项，
     * 如果 nums[i] != nums[j]，必须把 nums[j] 的值赋值给 nums[i+1]
     *
     */

    public static void main(String[] args) {
        int[] nums = {-3,-1,0,0,0,3,3};
        System.out.println(removeDuplicates(nums));
        for (int num :
                nums) {
            System.out.print(num + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
