package Katas;

import java.util.ArrayList;
// Check to see if a string has the same amount of 'x's and 'o's.
// The method must return a boolean and be case insensitive. The string can contain any char.
public class XO {
    public static boolean getXO (String str) {
        str = str.toLowerCase();
        char[] characters = str.toCharArray();
        int xCount = 0;
        int oCount = 0;

        for(char c:characters){
            if (c == 'x'){
                xCount ++;
            }
            else if (c == 'o'){
                oCount ++;
            }
        }

        return xCount == oCount;
    }
}
