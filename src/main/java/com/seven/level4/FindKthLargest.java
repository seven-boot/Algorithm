package com.seven.level4;

import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5, 2, 12, 9};
        System.out.println(findKthLargest(nums, 3));
    }


    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (heap.peek() < num){
                heap.poll();
                heap.add(num);
            }
        }
        return heap.poll();
    }
}
