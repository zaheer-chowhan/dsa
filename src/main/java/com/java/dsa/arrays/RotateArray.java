package com.java.dsa.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k positions.
 * Example 1
 * Input:
 * nums = [1, 2, 3, 4, 5, 6, 7]
 * k = 3
 * Output:
 * [5, 6, 7, 1, 2, 3, 4]
 */
public class RotateArray {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("BEFORE::::"+Arrays.toString(nums));
//        rotate(nums, 3);
        rotateOptimalSolution(nums, 3);
        System.out.println("AFTER::::"+Arrays.toString(nums));
    }

    public static void rotateOptimalSolution(int[] nums, int k) {
        // three reversals
        reverseOptimized(nums, 0, nums.length -1);
        reverseOptimized(nums, 0, k -1);
        reverseOptimized(nums, k, nums.length -1);
    }

    private static void reverseOptimized(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    private static void reverse(int[] nums, int left, int right) {
        // your code
        right = left == 0 ? right  : right + left;
        for(int i = left; i <= right / 2; i++){
            int leftVal = nums[i];
            nums[i] = nums[right - i];
            nums[right - i] = leftVal;
        }
    }
    public static void rotateOptimize(int[] nums, int k) {

        for(int i = 0; i < nums.length; i++){

            int temp = nums[i];
            int kthVal = nums[k+i];
            int nextkthval = nums[k + i + 1];

            nums[i] = nextkthval;
            nums[k+i] = temp;
            nums[k + i + 1] = kthVal;
            if(i == k - 1){
                break;
            }
        }

    }

    public static void rotate(int[] nums, int k) {
        int temp = nums[0];
        while(k > 0) {
            int count = 0;
            temp = nums[count];
            for (int i = 1; i < nums.length; i++) {
                nums[count] = nums[i];
                count++;
            }
            nums[nums.length-1] = temp;
            k--;
        }
    }
}
