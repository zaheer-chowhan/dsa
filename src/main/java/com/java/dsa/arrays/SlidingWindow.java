package com.java.dsa.arrays;

/**
 * Problem Statement
 * Given an integer array nums and an integer k, find the maximum sum of any contiguous subarray of size k.
 * A contiguous subarray means the elements must be next to each other.
 *
 * Example 1
 * Input:
 * nums = [2, 1, 5, 1, 3, 2]
 * k = 3
 *
 * Output:
 * 9
 * Explanation
 * The subarrays of size 3 are:
 * [2, 1, 5] → 8
 * [1, 5, 1] → 7
 * [5, 1, 3] → 9  ← maximum
 * [1, 3, 2] → 6
 *
 * Therefore:
 * Output = 9
 */
public class SlidingWindow {

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("maxSubArray ::::"+maxSubArray(nums, k));
        System.out.println("maxSubArrayUsingSlidingWindow ::::"+maxSubArrayUsingSlidingWindow(nums, k));
    }

    public static int maxSubArrayUsingSlidingWindow(int[] nums, int k){

        if (nums.length < k) {
            return -1;
        }

        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;
        for(int i = 1; i <= nums.length - k ; i++){
            currentSum = (currentSum - nums[i - 1] ) + nums[(k - 1) + i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;

    }

    public static int maxSubArray(int[] nums, int k) {

        if (nums.length < k) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {

            int currentSum = 0;

            for (int j = i; j < i + k; j++) {
                currentSum += nums[j];
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
