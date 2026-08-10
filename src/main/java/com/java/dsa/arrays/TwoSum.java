package com.java.dsa.arrays;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem Statement
 * Given an integer array nums and an integer target,
 * return the indices of the two numbers such that they add up to target.
 * Input:
 * nums = [2, 7, 11, 15]
 * target = 9
 * Output:
 * [0, 1]
 */
public class TwoSum {

    public static void main(String[] args) {

        int arr[] = {2,11,7,15};
        int target = 9;

        System.out.println("Solution 1 ");
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));

        System.out.println("Solution 2 using HashMap");
        int[] map = twoSumUsingMap(arr, target);
        System.out.println(Arrays.toString(map));

        System.out.println("Solution 3 using Streams");
        System.out.println(Arrays.toString(twoSumUsingStreams(arr, target)));
    }

    public static int[] twoSumUsingMap(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static int[] twoSum(int[] nums, int target) {
        // your logic
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumUsingStreams(int[] nums, int target) {

        return IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i ->
                        IntStream.range(i + 1, nums.length)
                                .filter(j -> nums[i] + nums[j] == target)
                                .mapToObj(j -> new int[]{i, j})
                )
                .findFirst()
                .orElse(new int[]{});
    }


}
