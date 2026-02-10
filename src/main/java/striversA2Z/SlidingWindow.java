package striversA2Z;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {
    /*
    Given a string, S. Find the length of the longest substring without repeating characters.
    S = "abcddabac"
    4
     */
    public static int findLongestSubstring(String s) {

        /*
        While the right pointer is less than String length
            if the Set doesn't contain the character
                add
                increment right pointer
                compare the current length to max length
            else if the Set does contain the character
                remove the character at left pointer and increment left pointer
                till the set doesn't contain the current character
                the left pointer is now at the start of the new window
         */
        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int maxLength = 0;

        while (r < s.length()) {
            Character c = s.charAt(r);

            if (!set.contains(c)) {
                set.add(c);
                r++;
                maxLength = Math.max(maxLength, r - l);
            } else {
                while (set.contains(c)) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
        }

        return maxLength;
    }

    public static int maxConsecutiveOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int zeros = 0;
        int maxLength = 0;

        /*
        While the right pointer is less than array size
            if current int is 0 increment zero counter
            if zero count is less than or equal k
                compare current length to max length
            else if zero count is greater than k
                check left pointer is equal to 0
                    if yes then decrement zero counter and move left pointer
         */
        while (r < nums.length) {
            if (nums[r] == 0) zeros++;

            if (zeros <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            } else {
                while (zeros > k) {
                    if (nums[l] == 0) {
                        zeros--;
                    }
                    l++;
                }
            }

            r++;
        }

        return maxLength;
    }

    /*
    There is only one row of fruit trees on the farm, oriented left to right. A
    n integer array called fruits represents the trees,
    where fruits[i] denotes the kind of fruit produced by the ith tree.
    The goal is to gather as much fruit as possible, adhering to the owner's stringent rules

    fruits = [1, 2, 1]
    3

    fruits = [1, 2, 3, 2, 2]
    4
     */
    public static int fruitsIntoBaskets(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxCount = 0;
        int currentCount = 0;

        /*
        While the right pointer is less than array size
            Put the current integer in basket map
            While the basket size is greater than 2
                From left pointer
                Remove each fruit from the corresponding basket till empty
                If basket is empty remove from map
            Check if current count of fruits from right to left is greater than max
         */
        while (r < fruits.length) {
            baskets.put(fruits[r], baskets.getOrDefault(fruits[r], 0) + 1);

            while (baskets.size() > 2) {
                if (baskets.get(fruits[l]) == 1) {
                    baskets.remove(fruits[l]);
                } else {
                    baskets.put(fruits[l], baskets.get(fruits[l]) - 1);
                }
                l++;
            }

            currentCount = r - l + 1;
            maxCount = Math.max(maxCount, currentCount);

            r++;
        }

        return maxCount;
    }
}
