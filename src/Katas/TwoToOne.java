package Katas;

import java.util.Arrays;

public class TwoToOne {
    public static String longest (String s1, String s2) {
        String s = s1 + s2;
        String result = "";
        char[] charArray = s.toCharArray();

        for (char c = 'a'; c <= 'z'; c++){
            if (s.contains(Character.toString(c))){
                result = result + c;
            }
        }

        return result;



    }
}
