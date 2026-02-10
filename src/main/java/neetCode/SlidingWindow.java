package neetCode;

import java.util.*;
import java.util.Arrays;

public class SlidingWindow {
    /*
    You are given an integer array prices where prices[i]
    is the price of NeetCoin on the ith day.

    You may choose a single day to buy one NeetCoin and
    choose a different day in the future to sell it.

    Return the maximum profit you can achieve.
    You may choose to not make any transactions,
    in which case the profit would be 0.

    [10,1,5,6,7,1]
    6
     */
    public static int buyStocks(int[] prices) {

        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int currentPrice: prices) {
            if (currentPrice < buyPrice) {
                buyPrice = currentPrice;
            } else {
                maxProfit = Math.max(maxProfit, currentPrice - buyPrice);
            }
        }

        return maxProfit;
    }

    /*
    Given a string s, find the length of the longest substring without duplicate characters.

    A substring is a contiguous sequence of characters within a string.
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();

        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                max = Math.max(max, r - l);
            } else {
                while (set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
        }

        return max;
    }

    /*
    You are given a string s consisting of only uppercase english characters and an integer k.
    You can choose up to k characters of the string and replace them with any other uppercase English character.

    After performing at most k replacements,
    return the length of the longest substring which contains only one distinct character.
     */
    public static int characterReplacement(String s, int k) {

        /*
        For each character in set (duplicate ignored)
            See if that character produces the largest window
            Start at 0
            If current char == char to check
                Extend right pointer
                Check if current max > max
            If current char != char to check
                If count < k
                    Keep extending right pointer (change different letter to char to check)
                    Check if current max > max
            Else if current char != char to check && count ! < k
                Slide left pointer to right
                Set right pointer to left pointer and start new window
         */
        Set<Character> set = new HashSet<>();

        for (Character c: s.toCharArray()) {
            set.add(c);
        }


        int max = 0;

        for (Character c: set) {
            int l = 0;
            int r = 0;
            int count = 0;

            while (r < s.length()) {
                Character currentChar = s.charAt(r);
                if (currentChar.equals(c)) {
                    r++;
                    max = Math.max(max, r - l);
                } else if (count < k) {
                    count++;
                    r++;
                    max = Math.max(max, r - l);
                } else {
                    l++;
                    r = l;
                    count = 0;
                }
            }
        }

        return max;
    }

    /*
    You are given two strings s1 and s2.

    Return true if s2 contains a permutation of s1, or false otherwise.
    That means if a permutation of s1 exists as a substring of s2, then return true.

    Both strings only contain lowercase letters.
     */
    public static boolean checkInclusion(String s1, String s2) {

        if (s1.isEmpty() || s2.isEmpty()) return false;

        if (s2.length() < s1.length()) return false;

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for (Character c: s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            s2Arr[s2.charAt(i) - 'a']++;
            if (Arrays.equals(s1Arr, s2Arr)) return true;

            if (i >= s1.length() - 1) {
                s2Arr[s2.charAt(i - (s1.length() - 1)) - 'a']--;
            }
        }

        return false;
    }
}
