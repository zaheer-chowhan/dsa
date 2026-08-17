package com.java.dsa.arrays;

/**
 * Problem: Search in a Sorted Array
 * Given a sorted integer array nums in ascending order and an integer target,
 * return the index of target.
 * If target does not exist in the array, return -1.
 * Example 1
 * nums = [1, 3, 5, 7, 9, 11]
 * target = 7
 * Output:
 * 3
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 11};
        int target = 3;
        System.out.println("search::::::::"+search(nums, target));
        System.out.println("searchUsingBinarySearch::::::::"+searchUsingBinarySearch(nums, target));
    }

    public static int searchUsingBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while( left <= right){
            int mid = left + (right - left) /2;
            if(nums [mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1 ;
            }
        }
        return  -1;
    }

    public static int search(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
