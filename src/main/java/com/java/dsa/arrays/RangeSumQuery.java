package com.java.dsa.arrays;

import java.util.Arrays;

/**
 * Problem Statement
 *
 * Given an integer array nums, answer multiple queries where each query asks
 * for the sum of elements between two indices left and right (inclusive).
 * Return the sum for each query.
 *
 * Example
 * nums = [1, 2, 3, 4, 5]
 * Query:
 * left = 1
 * right = 3
 * The elements are:
 * [2, 3, 4]
 * So:
 * Output = 9
 */
public class RangeSumQuery {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int left = 1, right = 3;
        System.out.println("Result :::"+rangeSum(nums, left, right));
        System.out.println("rangeSumUsingPrefix :::"+rangeSumUsingPrefix(nums, left, right));
        System.out.println("rangeSumUsingPrefixOptimized :::"+rangeSumUsingPrefixOptimized(nums, left, right));

    }

    public static int rangeSumUsingPrefixOptimized(int[] nums, int left, int right){
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for(int i = 0; i < nums.length; i++){
            prefix[i + 1] = nums[i] + prefix[i];
        }
        System.out.println("------------->>>>"+Arrays.toString(prefix));
        return prefix[right + 1] - prefix[left];
    }

    public static int rangeSumUsingPrefix(int[] nums, int left, int right){
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }

    public static int rangeSum(int[] nums, int left, int right){
        int result = 0;

        for(int i = left; i <= right; i++){
            result = result + nums[i];
        }
        return result;
    }
}

