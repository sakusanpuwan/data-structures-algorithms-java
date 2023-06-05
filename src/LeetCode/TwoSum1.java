package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    //    Given an array of integers nums and an integer target,
    //    return indices of the two numbers such that they add up to target.

    /*
        Approach 1 - Brute Force
        Loop through each element and find if adding to another value = target
        Complexity Analysis - Time - O(n^2) / Space - O(1)
     */

    public int[] approach1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }

        return null;
    }

    /*
        Approach 2 - Two-Pass Hash Table
        Hash-Table - Map each element in the array to its index
        Complexity Analysis - Time - O(n) / Space - O(n)
     */

    public int[] approach2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();

        // for each num in array put num as Key and index as Value in map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i );
        }

        /*
        for each num in array
        find complement value
        if the map has that complement key
        and if the complement isn't the same as the current num
        return current num index and complements index(map value)
         */
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i , map.get(complement)};
            }
        }

        return null;
    }

    /*
    Approach 3 - One-Pass Hash Table
    Hash-Table - Map each element in the array to its index and checking if complement already exists
    Complexity Analysis - Time - O(n) / Space - O(n) (MAX)
    */

    public int[] approach3(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i],i );
        }

        return null;
    }
}
