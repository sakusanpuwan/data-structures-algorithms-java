package Katas;

public class DRoot {
    public static int digital_root(int n) {
        String stringNumber = String.valueOf(n);
        char[] characterArray = stringNumber.toCharArray();
        int result = 0;

        while (characterArray.length > 1){
            result = 0;
            for (char i:characterArray){
                result += Character.getNumericValue(i);
            }
            stringNumber = String.valueOf(result);
            characterArray = stringNumber.toCharArray();
        }

        return result;

        // Could've use > 9 to check number of digits
    }
}
