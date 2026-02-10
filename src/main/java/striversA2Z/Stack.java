package striversA2Z;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Stack {
    public static boolean checkBalancedParentheses(String str) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (Character c: str.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            if (stack.isEmpty()) {
                stack.add(c);
            } else if (stack.peek().equals(map.get(c))) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }

    /*
    Given an integer array A, return the next greater element for every element in A.
    The next greater element for an element x is the first element greater
    than x that we come across while traversing the array in a clockwise manner.
    If it doesn't exist, return -1 for this element.
     */
    public static int[] nextGreatestElement(int[] A) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int[] array = new int[A.length];

        for (int i = A.length - 1; i >= 0 ; i--) {
            if (stack.isEmpty()) {
                array[i] = -1;
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() > A[i]) {
                        array[i] = stack.peek();
                        break;
                    } else {
                        stack.pop();
                    }
                }

                if (array[i] == 0) array[i] = -1;
            }

            stack.add(A[i]);
        }

        return array;
    }
    
    public static int[] nextGreatestElementCircular(int[] arr) {
        int[] resultArr = new int[arr.length];
        int[] circularArray = new int[arr.length * 2];

        for (int i = 0; i < circularArray.length; i++) {
            if (i <= arr.length - 1) circularArray[i] = arr[i];
            if (i > arr.length - 1) circularArray[i] = arr[i - arr.length];
        }

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        //                       !
        // arr = [5, 7, 1, 7, 6, 0] [5, 7, 1, 7, 6, 0]
        for (int i = circularArray.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || i > arr.length - 1) {
                stack.add(circularArray[i]);
            } else {
                while(!stack.empty()) {
                    if (stack.peek() > circularArray[i]) {
                        resultArr[i] = stack.peek();
                        break;
                    } else {
                        stack.pop();
                    }
                }

                if (resultArr[i] == 0) resultArr[i] = -1;
                stack.add(circularArray[i]);
            }

        }

        return resultArr;
        
    }

}
