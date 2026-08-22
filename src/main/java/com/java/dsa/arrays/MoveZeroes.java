package com.java.dsa.arrays;

import java.util.Arrays;

/**
 * Problem Statement
 * Given an integer array nums, move all 0s to the end of the array while maintaining the relative order of the non-zero elements.
 * You must modify the array in-place without making a copy of the array.
 * Example 1
 * Input:
 * nums = [0, 1, 0, 3, 12]
 * Output:
 * [1, 3, 12, 0, 0]
 */
public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroesOptimized(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroesOptimized(int[] nums) {

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {

            if (nums[fast] != 0) {

                // swap nums[slow] and nums[fast]
                nums[slow] = nums[fast];
                nums[fast] = 0;
                System.out.println(Arrays.toString(nums));

                slow++;
            }
        }
    }

    public static void moveZeroes(int[] nums){

        for(int i = 0 ; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] != 0 && nums [i] == 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }
}
