package com.seven.level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QH
 * @date 2020/5/27
 * @description 给定一个无序数组和一个目标值，找出数组中两个数之和等于目标值的所有组合，并指出其时间复杂度
 */
public class FindMatchedGroup {

    public static void main(String[] args) {
        int[] nums = {1, 6, 4, 2, 9, 12};
        List<String> result = findMatchedGroup(nums, 10);
        System.out.println(result.toString());
    }


    private static List<String> findMatchedGroup(int[] nums, int sum) {
        int len = nums.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                if (nums[i] + nums[j] == sum) {
                    list.add(nums[i] + "+" + nums[j]);
                }
            }
        }
        return list;
    }
}
