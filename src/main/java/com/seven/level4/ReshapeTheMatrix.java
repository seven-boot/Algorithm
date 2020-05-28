package com.seven.level4;

import java.util.Arrays;

/**
 * @author QH
 * @date 2020/5/25
 * @description 改变矩阵维度
 */
public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] ints = matrixReshape(nums, 1, 4);
        for (int[] num : ints){
            System.out.println(Arrays.toString(num));
        }
    }

    /**
     * Input:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 1, c = 4
     *
     * Output:
     * [[1,2,3,4]]
     *
     * Explanation:
     * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
     *
     * @param nums 输入矩阵
     * @param r row 行
     * @param c column 列
     * @return
     */
    private static int[][] matrixReshape(int[][] nums, int r, int c) {
        // 判断新矩阵是否能容得下原始矩阵，否则返回原矩阵
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] reshapeNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapeNums[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return reshapeNums;
    }
}
