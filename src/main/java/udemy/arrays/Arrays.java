package udemy.arrays;

public class Arrays {

    /*
    Ex 1
    Write a function called middle that takes an array
    and returns a new array that contains all but the first and last elements.

    myArray = [1, 2, 3, 4]
    middle(myArray)  # [2,3].
     */
    public static int[] middle(int[] array) {
        if (array.length <= 2) {
            return new int[0];
        }

        int[] newArray = new int[array.length - 2];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i+1];
        }

        return newArray;
    }

    /*
    Ex 2
    Given 2D array calculate the sum of diagonal elements.

    myArray2D= {{1,2,3},
                {4,5,6},
                {7,8,9}};

    sumDiagonalElements(myArray2D) # 15
     */
    public static int sumDiagonalElements(int[][] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }

        return sum;
    }

    /*
    Ex 3
    Given an array, write a function to get first,
    second best scores from the array and return it in new array.

    Array may contain duplicates.

    Example

    myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
    firstSecond(myArray) // {90, 87}
     */
    public static int[] findTopTwoScores(int[] array) {
        int firstScore = Integer.MIN_VALUE;
        int secondScore = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstScore) {
                secondScore = firstScore;
                firstScore = array[i];
            } else if (array[i] > secondScore && array[i] < firstScore) {
                secondScore = array[i];
            }
        }

        return new int[] {firstScore, secondScore};
    }

    /*
    Ex 4
    Write Java function called findMissingNumberInArray that
    takes an integer array containing n-1 unique elements from a range of 1 to n,
    with one missing number, and returns the missing number.

    Example

    myArray = {1,2,3,4,6}
    findMissingNumberInArray(myArray, 6) // 5
    Hint:

    Use the formula (n * (n + 1)) / 2 which  calculates the sum of the first n natural numbers.
     */
    public static int findMissingNumberInArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return 0;
    }

    /*
    Ex 5
    Write a function which takes integer array as a parameter
    and returns a new integer array with unique elements. (remove duplicates)

    Example

    removeDuplicates({1, 1, 2, 2, 3, 4, 5})
    Output : [1, 2, 3, 4, 5]
     */
    public static int[] removeDuplicates(int[] arr) {
        int[] uniqueArr = new int[arr.length];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < uniqueArr.length; j++) {
                if (arr[i] == uniqueArr[j]) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueArr[index] = arr[i];
                index++;
            }
        }

        return java.util.Arrays.copyOf(uniqueArr, index);
    }

    /*
    Ex 9
    Write a program to check if an array contains a number in Java.

    int[] intArray = {1,2,3,4,5,6};
    searchInArray(intArray, 6); // 5
     */
    public static int searchInArray(int[] array, int valueToSearch) {
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToSearch) {
                index = i;
            }
        }

        return index;
    }

    /*
    Ex 10
    How to find maximum product of two integers in the array where all elements are positive.

    Example

    int[] intArray = {10,20,30,40,50};
    maxProduct(intArray) // (40,50)
     */
    public static String maxProduct(int[] intArray) {
        int maxProduct = Integer.MIN_VALUE;
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                int currentProduct = intArray[i] * intArray[j];
                if (currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                    index1 = i;
                    index2 = j;
                }
            }
        }

        return intArray[index1] + "," + intArray[index2];
    }

    /*
    Ex 12
    You are given two integer arrays. Write a program to check if they are permutation of each other.

    Example

    int[] array1 = {1,2,3,4,5};
    int[] array2 = {5,1,2,3,4};
    permutation(array1, array2)
    Output

    true
     */
    public static boolean permutation(int[] array1, int[] array2) {
        boolean isPresent = false;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) {
                return false;
            }
        }

        return true;
    }

    /*
    Interview Q1
    Create function which calculates sum and product of elements in array
     */
    public static void spofArray(int[] array) {
        int sum = 0;
        int product = 1;

        for (int number : array) {
            sum += number;
            product *= number;
        }

        System.out.println("Sum = " + sum);
        System.out.println("Product = " + product);
    }

    /*
    Interview Q2
    Create function which prints the pairs from given array
    [1,3,4,5]
    11 , 13, 14, 15
    31, 33, 34, 35
    41, 43 , 44 , 45
     */
    public static void printPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + array[j]);
            }
        }
    }

    /*
    Interview Q6
    Create function which takes an array and reverses it
     */
    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i];
            array[i] = temp;
        }

        return array;
    }

}
