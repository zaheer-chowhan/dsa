package com.java.dsa.strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem Statement
 *
 * Given a string s, find the first non-repeating character in it and return its index.
 * If no such character exists, return -1.
 * Example 1
 * Input: s = "leetcode"
 * Output: 0
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {

        String s = "leetcodel";
        System.out.println("firstUniqChar :::"+firstUniqChar(s));
        System.out.println("firstUniqCharUsingFrequency :::"+firstUniqCharUsingFrequency(s));
        System.out.println("firstUniqCharUsingStreams :::"+firstUniqCharUsingStreams(s));
    }

    public static long firstUniqCharUsingStreams(String s){
        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        return IntStream.range(0, s.length()).filter(i -> count[s.charAt(i) - 'a'] == 1).findFirst().orElse(-1);
    }
    public static int firstUniqCharUsingFrequency(String s){
        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
