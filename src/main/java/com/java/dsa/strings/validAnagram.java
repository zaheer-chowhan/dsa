package com.java.dsa.strings;


import ch.qos.logback.core.model.INamedModel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Problem Statement
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An anagram is a word or phrase formed by rearranging all the letters of another word or phrase, using each character exactly once.
 * Example 1
 * Input:
 * s = "anagram"
 * t = "nagaram"
 * Output: true
 */
public class validAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("isAnagram ::::"+isAnagram(s,t));
        System.out.println("isAnagram ::::"+isAnagramOptimized(s,t));
    }

    public static boolean isAnagramOptimized(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String s, String t){

        if(s.length() != t.length()){
            return false;
        }
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        char[] ct = t.toCharArray();
        Arrays.sort(ct);
        for(int i =0; i < s.length(); i++){
            if(ca[i] != ct[i]){
                return false;
            }
        }
        return true;
    }
}
