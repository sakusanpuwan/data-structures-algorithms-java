package striversA2Z;

import java.util.ArrayList;
import java.util.List;

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
}
