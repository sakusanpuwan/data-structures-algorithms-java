package katas.sixKyu;

import java.util.HashMap;
import java.util.Map;

/*
https://www.codewars.com/kata/54da5a58ea159efa38000836/train/java

Given an array of integers, find the one that appears an odd number of times.
There will always be only one integer that appears an odd number of times.
Examples
[7] should return 7, because it occurs 1 time (which is odd).
[0] should return 0, because it occurs 1 time (which is odd).
[1,1,2] should return 2, because it occurs 1 time (which is odd).
[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 */
public class FindOdd {
    public static int findIt(int[] a) {
        HashMap<Integer,Integer> numberCountMap = new HashMap<>();

        if (a.length == 1) {
            return a[0];
        }

        for (Integer number : a) {
            int currentCount = numberCountMap.getOrDefault(number, 0);
            numberCountMap.put(number, currentCount + 1);
        }

        for (Map.Entry<Integer, Integer> entry: numberCountMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value % 2 != 0) {
                return key;
            }
        }

        throw new IllegalStateException("No number with an odd count found");
    }
}