package katas.sevenKYU;

import java.util.List;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/52fba66badcd10859f00097e/train/java
Disemvowel Trolls
-----------------
Trolls are attacking your comment section!

A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.

Your task is to write a function that takes a string and return a new string with all vowels removed.

For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".

Note: for this kata y isn't considered a vowel.
 */
public class Troll {
    public static String disemvowel(String str) {
        List<String> vowels = List.of("a","e","i","o","u");

        String result = str.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .filter(letter -> !vowels.contains(letter.toLowerCase()))
                .collect(Collectors.joining());

        return str.replaceAll("[aeiouAEIOU]", "");
    }
}
