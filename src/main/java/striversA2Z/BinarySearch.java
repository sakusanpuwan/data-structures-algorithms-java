package striversA2Z;

import java.util.Arrays;

public class BinarySearch {
    /*
    Binary Search: Explained
    Problem statement: You are given a sorted array of integers and a target,
    your task is to search for the target in the given array.
    Assume the given array does not contain any duplicate numbers.
     */
    public static int binarySearch(int[] array, int target) {
        int index = Arrays.binarySearch(array, target);

        if (index == -1) {
            return -1;
        }

        return array[index];
    }

    public static int binarySearchDirect(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] == target) {
                return midIndex;
            } else if (array[midIndex] < target) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }

        return -1;
    }

    /*
    Lower Bound
    Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.
     */
    public static int findLowerBound(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        int low = -1;

        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] >= key) {
                low = midIndex;
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }

        return low;
    }

    public static int insertPosition(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int index = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }
}
