package katas;

public class Palindrome {

    public static boolean isPalindrome(String input){
        /*
            t e n e t
            0 1 2 3 4

            length = 5
         */
        boolean result = true;
        input = input.replace(" ","");
        char[] charArray = input.toLowerCase().toCharArray();


        for (int i=0; i < charArray.length ; i++){
            if (charArray[i] != charArray[charArray.length - i - 1]){
                result = false;
                break;
            }

        }
        return result;
    }
}
