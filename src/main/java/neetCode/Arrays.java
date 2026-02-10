package neetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Arrays {
    /*
    Given an integer array nums,
    return true if any value appears more than once in the array,
    otherwise return false.
     */
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (Integer integer: nums) {
            if (set.contains(integer)) {
                return true;
            } else {
                set.add(integer);
            }
        }

        return false;
    }

    /*
    Given two strings s and t, return true if the two strings are anagrams of each other,
    otherwise return false.

    An anagram is a string that contains the exact same characters as another string,
    but the order of the characters can be different.
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] letterCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'a']++;
            letterCount[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < letterCount.length; i++) {
            if (letterCount[i] != 0) return false;
        }

        return true;
    }

    /*
    Given an array of integers nums and an integer target,
    return the indices i and j such that nums[i] + nums[j] == target and i != j.

    You may assume that every input has exactly one pair of indices i and j
    that satisfy the condition.

    Return the answer with the smaller index first.
     */
    public static int[] twoSum(int[] nums, int target) {
        // Key = Target - 1st Number
        // Value = 1st Number Index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[] {0,0};
    }

    /*
    Given an array of strings strs, group all anagrams together into sublists.
    You may return the output in any order.

    An anagram is a string that contains the exact same characters as another string,
    but the order of the characters can be different.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Key is sorted String
        // Value is List of Strings
        Map<String, List<String>> anagrams = new HashMap<>();

        /*
        For each String in List
            Sort the array of Characters into an ordered String
            Use ordered String as Key to check anagram map
                If it exists
                    Add current substring to List
                Else
                    Add Key and initial List
         */

        for (String substring: strs) {
            char[] charArr = substring.toCharArray();
            java.util.Arrays.sort(charArr);
            String sortedString = new String(charArr);

            if (anagrams.containsKey(sortedString)) {
                anagrams.get(sortedString).add(substring);
            } else {
                List<String> list = new ArrayList<>();
                list.add(substring);
                anagrams.put(sortedString, list);
            }
        }

        return new ArrayList<>(anagrams.values());
    }

    /*
    Given an integer array nums and an integer k,
    return the k most frequent elements within the array.

    The test cases are generated such that the answer is always unique.
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = freq.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();

        int[] result = new int[k];

        for (int i = 0; i < result.length; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }

    /*
    Given an integer array nums,
    return an array output where output[i] is the product of all the elements of nums
    except nums[i].
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];

        prefix[0] = 1;
        suffix[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[nums.length - 1 - i] = suffix[nums.length - i] * nums[nums.length - i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public static boolean isValidSudoku(char[][] board) {
        // Check rows & cols
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            rowSet.clear();
            colSet.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                } else {
                    rowSet.add(board[i][j]);
                }

                if (board[j][i] != '.' && colSet.contains(board[j][i])) {
                    return false;
                } else {
                    colSet.add(board[j][i]);
                }
            }


        }

        return true;
    }

    /*
    Given an array of integers nums, return the length of the
    longest consecutive sequence of elements that can be formed.

    A consecutive sequence is a sequence of elements
    in which each element is exactly 1 greater than the previous element.
    The elements do not have to be consecutive in the original array.

    [2,20,4,10,3,4,5]
    4
     */
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        if (nums.length == 1) return 1;

        java.util.Arrays.sort(nums);

        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else if (nums[i] != nums[i - 1]) {
                currentCount = 1;
            }
        }

        return maxCount;
    }

}
