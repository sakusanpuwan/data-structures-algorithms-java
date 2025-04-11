package katas.sevenKYU;

/*
https://www.codewars.com/kata/54ff3102c1bad923760001f3/train/java
Vowel Count
------------
Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.
 */

import java.util.List;

public class VowelCount {
    public static int getCount(String str) {
        List<Character> vowelList = List.of('a','e','i','o','u');

        int vowelCount = (int) str.chars() // IntStream
                .mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
                .filter(vowelList::contains)
                .count();

        return vowelCount;
    }
}
