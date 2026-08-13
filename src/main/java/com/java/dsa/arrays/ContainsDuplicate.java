package com.java.dsa.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem Statement
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * Example 1
 * Input: nums = [1, 2, 3, 1]
 * Output:true
 * Constraints
 * 1 <= nums.length
 * nums[i] can be positive, negative, or zero.
 * Return true as soon as you can determine that a duplicate exists.
 * Otherwise return false.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println("OUTPUT ::::::::::"+containsDuplicate(nums));
        System.out.println("containsDuplicateUsingHashset ::::::::::"+containsDuplicateUsingHashset(nums));




    }

    public static boolean containsDuplicateUsingStreamsSolutions2(int[] nums){

        Set<Integer> seen = new HashSet<>();
        return IntStream.of(nums).anyMatch(x-> !seen.add(x));
    }
    public static boolean containsDuplicateUsingStreams(int[] nums){
        Long count = IntStream.of(nums).distinct().count();
        return count != nums.length;
    }
    public static boolean containsDuplicateUsingHashset(int[] nums){

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }

    public static boolean containsDuplicate(int[] nums){

        for(int i = 0; i < nums.length; i++ ){

            for(int j = i + 1; j < nums.length; j++ ){

                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
