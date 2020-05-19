package com.seven.level4;

import java.util.Arrays;

/**
 * @author QH
 * @date 2020/5/19
 * @description 数组排序
 */
public class SortAry {
    public static void main(String[] args) {
//        int[] nums = {5, 3, 7, 2, 6};
        int[] nums = {9, 8, 7, 6, 5};
        // 具体的排序方式
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序，让数组中的每一个数，依次与后面的数进行比较，如果前面的数大于后面的数，就进行位置的交换
     */
    private static int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp;
                if (nums[i] > nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    /**
     * 冒泡排序，相邻两个数进行比较，第一波比较之后，最大的数在最后.
     * 每比较完之后，后面的数就减少一个比较，但是比较了，也没关系
     */
    private static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }
}
