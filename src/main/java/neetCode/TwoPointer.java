package neetCode;

import java.util.*;
import java.util.Arrays;

public class TwoPointer {
    /*
    Given a string s, return true if it is a palindrome, otherwise return false.

    A palindrome is a string that reads the same forward and backward.
    It is also case-insensitive and ignores all non-alphanumeric characters.

    Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        s = s.toLowerCase();

        while (left < right) {
            if (!Character.isDigit(s.charAt(left)) && !Character.isAlphabetic(s.charAt(left))) {
                left++;
            } else if (!Character.isDigit(s.charAt(right)) && !Character.isAlphabetic(s.charAt(right))) {
                right--;
            } else {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }

    /*
    Given an array of integers numbers that is sorted in non-decreasing order.

    Return the indices (1-indexed) of two numbers, [index1, index2],
    such that they add up to a given target number target and index1 < index2.
    Note that index1 and index2 cannot be equal,
    therefore you may not use the same element twice.

    There will always be exactly one valid solution
     */
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (r > l) {
            if (numbers[r] + numbers[l] == target) {
                return new int[] {l + 1, r + 1};
            } else if (numbers[r] + numbers[l] > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[2];
    }

    /*
    Given an integer array nums,
    return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0,
    and the indices i, j and k are all distinct.

    The output should not contain any duplicate triplets.
    You may return the output and the triplets in any order.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                if (nums[i] + nums[l] + nums[r] == 0) {
                    int[] arr = new int[] {nums[i], nums[l], nums[r]};
                    Arrays.sort(arr);
                    if (!set.contains(Arrays.toString(arr))) {
                        list.add(List.of(nums[i], nums[l], nums[r]));
                        set.add(Arrays.toString(arr));
                        r--;
                    }
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return list;
    }

    public static int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;

        while (l < r) {
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            int area = width * height;

            maxArea = Math.max(maxArea, area);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }



}
