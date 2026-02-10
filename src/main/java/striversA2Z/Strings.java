package striversA2Z;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

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

    /*
    You are given a string s. Return the array of unique characters,
    sorted by highest to lowest occurring characters.
    If two or more characters have the same frequency, then arrange them in alphabetic order.

    s = "tree"
    ['e', 'r', 't']

    s = "raaaajj"
    ['a', 'j', 'r']
     */
    public static char[] sortByFreq(String s) {
        Map<Character, Integer> characterCount = new HashMap<>();

        for (char c: s.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> descEntryList = characterCount.entrySet().stream()
                .sorted((a, b) -> {
                    int freqCmp = Integer.compare(b.getValue(), a.getValue());
                    if (freqCmp != 0) {
                        return freqCmp;
                    } else {
                        return Character.compare(a.getKey(), b.getKey());
                    }
                })
                .toList();

        char[] result = new char[descEntryList.size()];
        int i = 0;

        for (Map.Entry<Character, Integer> entry : descEntryList) {
            result[i++] = entry.getKey();
        }

        return result;
    }

    /*
    Problem Statement: Given a valid parentheses string s, return the nesting depth of s.
    The nesting depth is the maximum number of nested parentheses.

     s = "(1+(2*3)+((8)/4))+1"
     3
     */
    public static int maxNestingDepth(String s) {
        int count = 0;
        int maxDepth = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;

            if (count > maxDepth) {
                maxDepth = count;
            }
        }

        return maxDepth;
    }

    /*
    Roman numerals are represented by seven different symbols: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
    For example: 2 is written as II, 12 is written as XII, 27 is written as XXVII.
    Roman numerals are usually written largest to smallest from left to right. But in six special cases, subtraction is used instead of addition:
    I before V or X → 4 and 9,
    X before L or C → 40 and 90,
    C before D or M → 400 and 900
    Given a Roman numeral, convert it to an integer.

    s = "LVIII" 58
    s = "MCMXCIV" 1994
     */
    public static int convertRomanNumberal(String s) {
        Map<Character, Integer> map = new HashMap<>(Map.ofEntries(
                Map.entry('I', 1),
                Map.entry('V', 5),
                Map.entry('X', 10),
                Map.entry('L', 50),
                Map.entry('C', 100),
                Map.entry('D', 500),
                Map.entry('M', 1000)
        ));

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                sum += map.get(s.charAt(i));
            } else if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }

        return sum;
    }

    /*
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
    The algorithm for myAtoi(string s) is as follows:
    1. Whitespace: Ignore any leading whitespace (" ").
    2. Signedness: Determine the sign by checking if the next character is '-' or '+',
    assuming positivity if neither present.
    3. Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached.
    If no digits were read, then the result is 0.
    4. Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
    then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231,
    and integers greater than 231 - 1 should be rounded to 231 - 1.

     s = "1337c0d3"
     1337
     */
    public static int implementAtoi(String s) {

        int sign = 1;
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') i++;

        if (s.trim().charAt(i) == '-') {
            sign *= -1;
            i++;
        } else if (s.trim().charAt(i) == '+') {
            sign *= 1;
            i++;
        }

        StringBuilder sb = new StringBuilder();

        while (Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i));
            i++;
        }

        long x = sb.toString().isEmpty() ? 0 : sign * Long.parseLong(sb.toString());

        int y;

        if (x > Integer.MAX_VALUE) {
            y = Integer.MAX_VALUE;
        } else if (x < Integer.MIN_VALUE) {
            y = Integer.MIN_VALUE;
        } else {
            y = (int) x;
        }

        return y;
    }

    /*
    You are given a string s and a positive integer k.
    Return the number of substrings that contain exactly k distinct characters.

     s = "pqpqs", k = 2

    7
     */
    public static int numberOfSubstrings(String s, int k) {
        Set<String> substrings = new HashSet<>();

        int left = 0;
        int right = 0;

        Set<Character> characters = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            characters.add(c);

            if (characters.size() > k) {
                left++;
                right = left;
                characters.clear();
                continue;
            }

            if (characters.size() == k) {
                substrings.add(s.substring(left, right + 1));
            }

            right++;
        }

        return substrings.size();
    }

    /*
    The beauty of a string is defined as the difference between the frequency of the most frequent character
    and the least frequent character (excluding characters that do not appear) in that string.
    Given a string s, return the sum of beauty values of all possible substrings of s.

     s = "xyx" -> 1
     s = "aabcbaa" -> 17
     */
    public static int sumOfBeauty(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) { // start index
            int[] freq = new int[26];

            for (int j = i; j < n; j++) { // end index
                freq[s.charAt(j) - 'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                for (int f: freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }

                sum += max - min;
            }
        }

        return sum;
    }

    /*
    Given an input string, containing upper-case and lower-case letters, digits, and spaces( ' ' ).
    A word is defined as a sequence of non-space characters. The words in s are separated by at least one space.
    Return a string with the words in reverse order, concatenated by a single space.
     */
    public static String reverseWords1(String s) {
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0 ; i--) {
            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
