package com.java.dsa.arrays;

import java.util.Arrays;

/**
 * Problem Statement
 *
 * Given an integer array nums, return an array answer such that:
 *
 * answer[i] = product of all elements of nums except nums[i]
 * Example 1
 * Input:
 * [1, 2, 3, 4]
 *
 * Output:
 * [24, 12, 8, 6]
 *
 * Because:
 * index 0 → 2 × 3 × 4 = 24
 * index 1 → 1 × 3 × 4 = 12
 * index 2 → 1 × 2 × 4 = 8
 * index 3 → 1 × 2 × 3 = 6
 */

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        productExceptSelf(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void productExceptSelf(int[] nums) {
        // your solution

            int[] left = productOfAllLeft(nums);
            int[] right = productOfAllRight(nums);

            for(int i = 0; i < nums.length; i++){
                nums[i] = right[i + 1] * left[i];
            }

    }

    public static int[] productOfAllLeft(int[] nums){
        int[] result = new int[nums.length + 1];
        result[0] = 1;
        for(int i = 0; i < nums.length; i++){

            result[i + 1] = nums[i] * result[i];

        }
        return result;
    }
    public static int[] productOfAllRight(int[] nums){
        int[] result = new int[nums.length + 1];
        result[nums.length] = 1;
        int rightProducts = 1;
        for(int i = nums.length -1 ; i >= 0; i--){
            rightProducts = rightProducts * nums[i];
            result[i] =rightProducts;
        }
        return result;
    }


}
