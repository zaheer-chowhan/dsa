package com.java.dsa.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *Given a sorted integer array, remove duplicate elements in-place and return the resulting array containing only unique elements.
 * Example
 * Input:
 * [1, 1, 2, 2, 3, 4, 4]
 * Output:
 * [1, 2, 3, 4]
 */
public class RemoveDuplicateNumbers {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3, 4, 4};
        System.out.println("---------->>>>"+Arrays.toString(removeDuplicates(nums)));
        System.out.println("--removeDuplicatesOptimized-------->>>>"+Arrays.toString(removeDuplicatesOptimized(nums)));
        System.out.println("--removeDuplicatesMoreOptimized-------->>>>"+Arrays.toString(removeDuplicatesMoreOptimized(nums)));
    }

    public static int[] removeDuplicatesMoreOptimized(int[] nums){
        int unique = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[unique] = nums[i];
                unique++;
            }
        }
        return Arrays.copyOf(nums, unique);
    }
    public static int[] removeDuplicatesOptimized(int[] nums){
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int unique = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                result[unique] = nums[i];
                unique++;
            }
        }
        result = Arrays.copyOf(result, unique);
        return result;
    }

    public static int[] removeDuplicates(int[] nums){
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != result[i - 1]){
                result[i] = nums[i];
            }
        }
        return result;
    }
}
