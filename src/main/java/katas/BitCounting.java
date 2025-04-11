package katas;

public class BitCounting {
    public static int countBits(int n){

        return Integer.bitCount(n);
//        String binaryString = Integer.toBinaryString(n);
//        int bit = 0;
//        for (char c:binaryString.toCharArray()){
//            bit += Character.getNumericValue(c);
//            System.out.println(bit);
//        }
//        return bit;
    }
}
