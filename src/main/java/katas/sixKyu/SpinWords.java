package katas.sixKyu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/5264d2b162488dc400000001/train/java

Write a function that takes in a string of one or more words, and returns the same string, but with all words that have five or more letters reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
Examples:
"Hey fellow warriors"  --> "Hey wollef sroirraw"
"This is a test        --> "This is a test"
"This is another test" --> "This is rehtona test"

 */
public class SpinWords {
    public String spinWords(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));
        return words.stream()
                .map(word -> word.length() >= 5 ? new StringBuilder(word).reverse().toString() : word)
                .collect(Collectors.joining(" "));
    }
}
