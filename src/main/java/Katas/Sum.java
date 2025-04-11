package Katas;

public class Sum {

    public int GetSum(int a, int b){
        // a = -3 , b = 5  ===> -3 + -2 + -1 + 0 + 1 + 2 + 3 + 4 + 5 === 9
        int sum = 0;

        if (a < b) {
            for (int i = a; i < b+1 ; i++) {
                sum += i;
            }
        } else if (a > b) {
            for (int i = b; i < a+1 ; i++) {
                sum += i;
            }
        } else {
            sum = a;
        }

        return sum;

    }
}
