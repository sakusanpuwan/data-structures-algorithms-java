package katas;

public class BinaryAddition {
    public static String binaryAddition(int a, int b) {

        int decimalResult = a + b;
        String binaryResult = Integer.toBinaryString(decimalResult);

        return binaryResult;
    }
}
