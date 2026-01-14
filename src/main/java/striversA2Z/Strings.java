package striversA2Z;

import java.util.*;
import java.util.Arrays;

public class Strings {

    /*
    Problem Statement: A valid parentheses string is defined by the following rules:

    It is the empty string "".
    If A is a valid parentheses string, then so is "(" + A + ")".
    If A and B are valid parentheses strings, then A + B is also valid.

    A primitive valid parentheses string is a non-empty valid string that cannot
    be split into two or more non-empty valid parentheses strings.

    Given a valid parentheses string s, your task is to remove the outermost parentheses
    from every primitive component of s and return the resulting string.
     */
    public static String removeOuterParentheses(String s) {
        List<String> primitives = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        // ( = 1
        // ) = -1
        int count = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                count++;
            }

            if (')' == s.charAt(i)) {
                count--;
            }

            if (i != 0 && count == 0) {
                primitives.add(s.substring(left, i + 1));
                left = i + 1;
            }
        }

        for (String primitive: primitives) {
            stringBuilder.append(primitive, 1, primitive.length() - 1);
        }

        return stringBuilder.toString();
    }

    /*
    Input: s = "welcome to the jungle"
    Output: "jungle the to welcome"

    Input: s = " amazing coding skills "
    Output: "skills coding amazing"
     */
    public static String reverseWords(String s) {
        int right = s.length() - 1; // Set right index
        StringBuilder sb = new StringBuilder();

        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') right--; // Skip spaces
            if (right < 0 ) break;

            int left = right; // Set start position of left pointer to right pointer
            while (left >= 0 && s.charAt(left) != ' ') left--; // Move left till space is hit

            sb.append(s, left + 1, right + 1).append(' ');
            right = left - 1;
        }

        return sb.toString();
    }

    /*
    Given a string s, representing a large integer,
    the task is to return the largest-valued odd integer (as a string)
    that is a substring of the given string s.
    The number returned should not have leading zero's.
    But the given input string may have leading zero.

    s = "0214638"
    "21463"
     */
    public static String largestOddNumber(String s) {
        int left = 0;
        int largest = Integer.MIN_VALUE;

        while (left <= s.length() - 1 && s.charAt(left) == '0') left++;

        for (int i = left; i < s.length(); i++) {
            if (s.charAt(i) % 2 != 0) {
                int current = Integer.parseInt(s.substring(left, i + 1));
                largest = Math.max(current, largest);
            }
        }

        return String.valueOf(largest);
    }

    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
    str = ["flower", "flow", "flight"]
     "fl"
     */
    public static String longestPrefix(String[] array) {
        Arrays.sort(array); // Sorts in ascending order

        // Just need to compare first and last word (imagine a dictionary)
        String firstWord = array[0];
        String lastWord = array[array.length - 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.min(firstWord.length(), lastWord.length()); i++) {
            if (firstWord.charAt(i) != lastWord.charAt(i)) {
                return sb.toString();
            }

            sb.append(firstWord.charAt(i));
        }

        return sb.toString();
    }

    /*
    Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character
    while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.
    s = "paper", t = "title"
    s = "foo", t = "bar"
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Need to 2 maps to have bidirectional mapping
        Map<Character, Character> sTMap = new HashMap<>();
        Map<Character, Character> tSMap= new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sTMap.containsKey(sChar) && sTMap.get(sChar) != tChar) return false;
            if (tSMap.containsKey(tChar) && tSMap.get(tChar) != sChar) return false;

            sTMap.put(sChar, tChar);
            tSMap.put(tChar, sChar);
        }

        return true;
    }

    /*
    Given two strings s and goal, return true if and only
    if s can become goal after some number of shifts on s.
    A shift on s consists of moving the leftmost character of s to the rightmost position.
    For example, if s = "abcde", then it will be "bcdea" after one shift.

    s = "rotation", goal = "tionrota"
    s = "hello", goal = "lohelx"
     */
    public static boolean isStringRotation(String s, String goal) {

        if (s.length() != goal.length()) return false;

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) { // rotations
            if (sb.toString().equals(goal)) {
                return true;
            }

            char firstChar = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(firstChar);
        }

        return false;
    }

    /*
    Given two strings, check if two strings are anagrams of each other or not.

    Input: CAT, ACT
    Output: true

    Input: RULES, LESRT
    Output: false
     */
    public static boolean isAnagram(String string1, String string2) {
        int[] countArr = new int[26];

        for (int i = 0; i < string1.length(); i++) {
            countArr[string1.toLowerCase().charAt(i) - 'a']++;
            countArr[string2.toLowerCase().charAt(i) - 'a']--;
        }

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] != 0) {
                return false;
            }
        }

        return true;

    }
}
