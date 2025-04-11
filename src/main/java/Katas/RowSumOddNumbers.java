package Katas;


public class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {

        /*
        1 1
        2 3
        3 7
        4 13
        5 21
         */

        int firstNumber = (int) (Math.pow(n,2) -n +1);

        int currentNumber = firstNumber;

        int total = 0;

        if (n == 1 ){
            return 1;
        }

        for (int i = 0; i < n ; i++) {
            total += currentNumber;
            currentNumber += 2;
        }

        return total;
    }
}