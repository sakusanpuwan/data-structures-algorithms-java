package striversA2Z;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    /*
    Find the Largest element in an array
    Problem Statement: Given an array, we have to find the largest element in the array.
     */
    public static int findLargestElement(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int number: array) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    /*
    Find Second Smallest and Second Largest Element in an array
    Problem Statement: Given an array, find the second smallest and second largest element in the array.
    Print ‘-1’ in the event that either of them doesn’t exist.
     */
    public static int[] findSecondSmallestAndLargest(int[] array) {

        if (array.length < 2) {
            System.out.println("-1");
            return new int[2];
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int number: array) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }

            if (number < smallest) {
                secondSmallest = smallest;
                smallest = number;
            } else if (number < secondSmallest && number != smallest) {
                secondSmallest = number;
            }
        }

        return new int[] {secondSmallest, secondLargest};
    }

    /*
    Check if an Array is Sorted
    Problem Statement: Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not.
    If the array is sorted then return True, Else return False.
     */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*
    Remove Duplicates in-place from Sorted Array

    Problem Statement: Given an integer array sorted in non-decreasing order,
    remove the duplicates in place such that each unique element appears only once.
    The relative order of the elements should be kept the same.

    If there are k elements after removing the duplicates,
    then the first k elements of the array should hold the final result.
    It does not matter what you leave beyond the first k elements.
     */
    public static int[] removeDuplicates(int[] array) {
        int currentIndex = 1;
        int lastIndex = 0;

        while (currentIndex < array.length) {
            if (array[currentIndex] != array[lastIndex]) {
                lastIndex++;
                array[lastIndex] = array[currentIndex];
            }
            currentIndex++;
        }

        System.out.println(java.util.Arrays.toString(array));
        return array;
    }

    /*
    Left Rotate the Array by One
    Problem Statement: Given an integer array nums, rotate the array to the left by one.
     */
    public static int[] leftRotate(int[] array) {
        int first = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = first;

        return array;
    }

    /*
    Rotate array by K elements
    Problem Statement: Given an array of integers, rotating array of elements by k elements either left or right.
     */
    public static int[] rotateByK(int[] array, int k, String direction) {
        if ("LEFT".equals(direction)) {
            int[] temp = java.util.Arrays.copyOf(array, k);

            for (int i = 0; i < array.length - k; i++) {
                array[i] = array[i + k];
            }

            for (int i = array.length - k; i < array.length; i++) {
                array[i] = temp[i - (array.length - k)];
            }
        }

        return array;
    }

    /*
    Move all Zeros to the end of the array
    Problem Statement: You are given an array of integers,
    your task is to move all the zeros in the array to the end of the array
    and move non-negative integers to the front by maintaining their order.
     */
    public static int[] moveZeros(int[] array) {
        int currentIndex = 0;
        int lastDigitIndex = -1;

        // 2 pointers at current index and last index of non-zero
        // Increment current index
        // If current digit is not zero then replace last digit index + 1 with current
        // Add zero to current

        while (currentIndex < array.length) {
            if (array[currentIndex] != 0) {
                array[lastDigitIndex + 1] = array[currentIndex];
                lastDigitIndex++;
                array[currentIndex] = 0;
            }
            currentIndex++;
        }

        return array;
    }

    /*
    Linear Search
    Problem Statement: Given an array, and an element num the task is to find if num is present in the given array or not.
    If present print the index of the element or print -1.
     */
    public static int linearSearch(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }

        return -1;
    }

    /*
    Union of Two Sorted Arrays
    Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
    The union of two arrays can be defined as the common and distinct elements in the two arrays.
    NOTE: Elements in the union should be in ascending order.
     */
    public static int[] unionOfArrays(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        List<Integer> union = new ArrayList<>();
 
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
 
        while (i < arr1.length) {
            if (union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while (j < arr2.length) {
            if (union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /*
    Find the missing number in an array
    Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N.
    Find the number(between 1 to N), that is not present in the given array.
     */
    public static int findMissingNumber(int n, int[] array) {
        for (int i = 1; i < n; i++) {
            if (array[i] != i) {
                return i;
            }
        }

        return 0;
    }

    /*
    Count Maximum Consecutive One's in the array
    Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.
     */
    public static int maxConsecutiveOnes(int[] array) {
        int maxCount = 0;
        int currentCount = 0;

        for (int number : array) {
            if (number == 1) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }
}
