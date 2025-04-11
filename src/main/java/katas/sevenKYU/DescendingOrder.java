package katas.sevenKYU;

import java.util.Comparator;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/5467e4d82edf8bbf40000155/train/java
Descending Order
----------------
Your task is to make a function that can take any non-negative integer as an argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.

Examples:
Input: 42145 Output: 54421

Input: 145263 Output: 654321

Input: 123456789 Output: 987654321
 */
public class DescendingOrder {
    public static int sortDesc(final int num) {

        String result = String.valueOf(num).chars()
                .mapToObj(character -> String.valueOf(Character.getNumericValue(character)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        return Integer.parseInt(result);
    }
}
