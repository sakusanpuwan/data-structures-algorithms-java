package katas;

import java.util.Arrays;

public class Isogram {
    public static boolean  isIsogram(String str) {
        // For all characters in str check if any repeating,consecutive or non-consecutive
        boolean result = true;
        char[] charArray = str.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        char testChar = 0;

        for (char targetChar:charArray){
            if (targetChar == testChar){
                result = false;
                break;
            }
            testChar = targetChar;
        }

        return result;
    }
}
