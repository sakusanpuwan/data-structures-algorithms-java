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
    {1,2,2,3}, x = 2 -> 1
    {3,5,8,15,19}, x = 9 -> 3
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

    /*
    The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key i.e. x.
    arr[] = {1,2,2,3}, x = 2
    arr[] = {3,5,8,9,15,19}, x = 9
     */
    public static int findUpperBound(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        int index = 0;

        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] > x) {
                index = midIndex;
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }

        return index;
    }

    /*
    You are given a sorted array arr of distinct values and a target value x. You need to search for the index of the target value in the array.
    {1,2,4,7}, x = 6 -> 3
    {1,2,4,7}, x = 2 -> 1
     */
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

    /*
    given a sorted array arr of n integers and an integer x.
    Find the floor and ceiling of x in arr[0..n-1].
    The floor of x is the largest element in the array which is smaller than or equal to x.
    The ceiling of x is the smallest element in the array greater than or equal to x
    {3, 4, 4, 7, 8, 10}, x= 5 -> [4,7]
    {3, 4, 4, 7, 8, 10}, x= 8 -> [8, 8]
     */
    public static String findFloorAndCeil(int[] array, int x) {
        int leftFloor = 0;
        int leftCeiling = 0;
        int rightFloor = array.length - 1;
        int rightCeiling = array.length - 1;
        int floor = Integer.MIN_VALUE;
        int ceiling = 0;

        while (leftFloor <= rightFloor || leftCeiling <= rightCeiling) {
            int midFloorIndex = leftFloor + (rightFloor - leftFloor) / 2;
            int midCeilingIndex = leftCeiling + (rightCeiling - leftCeiling) / 2;

            if (leftFloor <= rightFloor) {
                if (array[midFloorIndex] <= x) {
                    floor = array[midFloorIndex];
                    leftFloor = midFloorIndex + 1;
                } else {
                    rightFloor = rightFloor - 1;
                }
            }

            if (leftCeiling <= rightCeiling) {
                if (array[midCeilingIndex] >= x) {
                    ceiling = array[midCeilingIndex];
                    rightCeiling = midCeilingIndex - 1;
                } else {
                    leftCeiling = midCeilingIndex + 1;
                }
            }

        }

        return floor + "," + ceiling;
    }


}
