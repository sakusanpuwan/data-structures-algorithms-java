package katas.sixKyu;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/523f5d21c841566fde000009/train/java

Implement a function that computes the difference between two lists. The function should remove all occurrences of elements from the first list (a) that are present in the second list (b).
The order of elements in the first list should be preserved in the result.
Examples
If a = [1, 2] and b = [1], the result should be [2].
If a = [1, 2, 2, 2, 3] and b = [2], the result should be [1, 3].

 */
public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        Set<Integer> bSet = Arrays.stream(b).boxed().collect(Collectors.toSet());

        return Arrays.stream(a)
                .filter(number -> !bSet.contains(number))
                .toArray();

    }
}
