package katas.sevenKYU;

import java.util.Arrays;

/*
In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.

Examples
highAndLow("1 2 3 4 5") // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"
Notes
All numbers are valid Int32, no need to validate them.
There will always be at least one number in the input string.
Output string must be two numbers separated by a single space, and highest number is first.
 */
public class HighLow {
    public static String highAndLow(String numbers) {
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (String stringDigit: numbers.split(" ")) {
            int number = Integer.parseInt(stringDigit);
            if (number > highest) highest = number;
            if (number < lowest) lowest = number;
        }

        return highest + " " + lowest;
    }
}
