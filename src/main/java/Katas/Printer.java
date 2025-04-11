package Katas;

public class Printer {

    public static String printerError(String s){

        // Refactored
        int errorTotal = 0;

        for (char c: s.toCharArray()){
            if (c > 'm' || c < 'a'){
                errorTotal ++;
            }
        }

        return errorTotal + "/" + s.length();


        // First Attempt
        /*


        String badControlChar = "";

        for (char c = 'n'; c <= 'z'; c++){
            badControlChar = badControlChar + c;
        }

        int errorTotal = 0;

        for (char c:s.toCharArray()){
            if (badControlChar.contains(c + "")){
                errorTotal ++;
            }
        }

        return errorTotal + "/" + s.length();

        */


    }
}
