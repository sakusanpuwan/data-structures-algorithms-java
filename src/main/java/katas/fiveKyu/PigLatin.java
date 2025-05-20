package katas.fiveKyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/520b9d2ad5c005041100000f/train/java
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !

 */
public class PigLatin {
    public static String pigIt(String str) {
        String[] words = str.split(" ");
        return Arrays.stream(words)
                .map(word -> word.matches("^[a-zA-Z]+$") ? word.substring(1) + word.charAt(0) + "ay" : word)
                .collect(Collectors.joining(" "));
    }
}