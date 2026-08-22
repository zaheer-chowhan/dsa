package com.java.dsa.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an integer array nums, find the element that appears more than n / 2 times, where n is the length of the array.
 *
 * You may assume that the majority element always exists.
 *
 * Example 1
 * Input:
 * [3, 2, 3]
 *
 * Output:
 * 3
 *
 * Because 3 appears 2 times and:
 *
 * n / 2 = 3 / 2 = 1
 * Example 2
 * Input:
 * [2, 2, 1, 1, 1, 2, 2]
 *
 * Output:
 * 2
 *
 * 2 appears 4 times, which is more than:
 *
 * 7 / 2 = 3
 */
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2, 1, 1,3, 3, 3, 5, 1, 1};
//        int[] nums = {3, 2, 3};
        System.out.println("majorityElement===>>>"+majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if(element == nums[i]){
                element = nums[i];
                count++;
            }
            else {
                count--;
            }
            if (count == 0) {
                element = nums[i];
                count = 1;
            }
        }
        return element;
    }
    public static int majorityElementUsingHashMap(int[] nums) {
        // your solution
        int element = -1;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++){

            if(map.get(nums[i]) != null){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet() ){

            if(nums.length / 2 < m.getValue() ){
                element = m.getKey();
                break;
            }
        }
        return element;
    }
}
