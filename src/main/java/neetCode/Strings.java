package neetCode;


import java.util.*;
import java.util.Arrays;

public class Strings {
    /*
    You are given two strings s and t,
    return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from
    the original string by deleting some (can be none) of the characters
    without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     */
    public static boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;

        if (t.isEmpty()) return false;

        int i = 0; // Index of s

        for (int j = 0; j < t.length(); j++) {
            Character c = s.charAt(i);
            if (c.equals(t.charAt(j))) i++;
            if (i == s.length()) return true;
        }

        return false;
    }

    /*
    You are given two strings s and t consisting of only lowercase English letters.

    Return the minimum number of characters that
    need to be appended to the end of s so that t becomes a subsequence of s.

    s = "coaching", t = "coding"

    4

    Append the characters "ding" to the end of s so that s = "coachingding"
     */
    public static int appendCharacters(String s, String t) {

        if (t.isEmpty()) return 0;

        if (s.isEmpty()) return t.length();

        int i = 0; // Index of t

        for (int j = 0; j < s.length(); j++) {
            Character c = t.charAt(i);

            if (c.equals(s.charAt(j))) i++;
            if (i == t.length()) return 0;
        }

        return t.length() - i;
    }

    /*
    You are given a string s consisting of words and spaces,
    return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.

    Note: A substring is a contiguous non-empty sequence of characters within a string.
     */
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");

        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (!arr[i].trim().isEmpty()) return arr[i].length();
        }

        return 0;
    }

    /*
    You are given a 0-indexed array of strings details.
    Each element of details provides information about a given passenger
    compressed into a string of length 15. The system is such that:

    The first ten characters consist of the phone number of passengers.
    The next character denotes the gender of the person.
    The following two characters are used to indicate the age of the person.
    The last two characters determine the seat allotted to that person.
    Return the number of passengers who are strictly more than 60 years old.
     */
    public static int countSeniors(String[] details) {
        int count = 0;

        // 7868190130M7522
        for (String string: details) {
            if (Integer.parseInt(string.substring(11,13)) > 60) count++;
        }

        return count;
    }

    /*
    You are given an array of strings strs.
    Return the longest common prefix of all the strings.

    If there is no longest common prefix, return an empty string "".
     */
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        int count = 0;

        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return strs[0].substring(0, count);
            } else {
                count++;
            }
        }

        return strs[0].substring(0, count);
    }

    /*
    You are given an array of string words,
    return all strings in words that are a substring of another word.
    You can return the answer in any order.
     */
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));

        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    wordSet.add(words[i]);
                    break;
                }
            }
        }

        return new ArrayList<>(wordSet);
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email: emails) {
            StringBuilder emailBuilder = new StringBuilder();

            boolean isDomain = false;
            boolean isPlus = false;
            for (Character c: email.toCharArray()) {
                if (c.equals('@')) isDomain = true;
                if (c.equals('+')) isPlus = true;

                if (isDomain || (!isPlus && !c.equals('.'))) {
                    emailBuilder.append(c);
                }

            }

            uniqueEmails.add(emailBuilder.toString());
        }

        return uniqueEmails.size();
    }

    /*
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character
    while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.
     */
    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (!sMap.containsKey(s.charAt(i))) sMap.put(s.charAt(i), t.charAt(i));
            if (!tMap.containsKey(t.charAt(i))) tMap.put(t.charAt(i), s.charAt(i));

            if (!sMap.get(s.charAt(i)).equals(t.charAt(i)) || !tMap.get(t.charAt(i)).equals(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /*
    Your task is to find the maximum difference diff = freq(a1) - freq(a2)
    between the frequency of characters a1 and a2 in the string such that:

    a1 has an odd frequency in the string.
    a2 has an even frequency in the string.
    Return this maximum difference.
     */
    public static int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1 );
        }

        List<Integer> charCounts = new ArrayList<>(map.values());
        charCounts.sort(Comparator.naturalOrder());

        int a1 = charCounts.size() - 1;
        int a2 = 0;

        while (charCounts.get(a1) % 2 == 0 || charCounts.get(a2) % 2 != 0) {
            if (charCounts.get(a1) % 2 == 0) a1--;
            if (charCounts.get(a2) % 2 != 0) a2++;
        }

        return charCounts.get(a1) - charCounts.get(a2);
    }

    /*
    You are given two strings ransomNote and magazine,
    return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

    Each letter in the magazine can only be used once in ransomNote.
     */
    public static boolean canConstruct(String ransomNote, String magazine) {

        if (magazine.length() < ransomNote.length()) return false;

        int[] letterArr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            if (i < ransomNote.length()) {
                letterArr[ransomNote.charAt(i) - 'a']--;
            }
            letterArr[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < letterArr.length; i++) {
            if (letterArr[i] < 0) return false;
        }

        return true;
    }

    /*
    You are given a string num representing a large integer.
    An integer is good if it meets the following conditions:

    It is a substring of num with length 3.
    It consists of only one unique digit.
    Return the maximum good integer as a string or an empty string "" if no such integer exists.
     */
    public static String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        int count = 1;

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                count++;
                if (count == 3) {
                    max = Math.max(max, Integer.parseInt(String.valueOf(num.charAt(i))));
                }
            } else {
                count = 1;
            }
        }

        return max == Integer.MIN_VALUE ? "" : String.valueOf(max).repeat(3);
    }

    /*
    We can represent a sentence as an array of words, for example,
    the sentence "I am happy with neetcode" can be represented as
    arr = ["I","am","happy","with","neetcode"].

    Given two sentences sentence1 and sentence2 each represented as a
    string array and given an array of string pairs similarPairs
    where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.

    Return true if sentence1 and sentence2 are similar, or false if they are not similar.

    Two sentences are similar if:

    They have the same length (i.e. the same number of words)
    sentence1[i] and sentence2[i] are similar.
     */
    public static boolean areSentenceSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;

            boolean pairFound = false;
            for (List<String> pair: similarPairs) {
                if (pair.contains(sentence1[i]) && pair.contains(sentence2[i])) {
                    pairFound = true;
                    break;
                }
            }

            if (!pairFound) return false;
        }

        return true;
    }

}
