package Katas;

public class Mulitple3or5 {
    public int solution(int number){

        int total = 0;

        if (number < 0){
            return 0;
        }

        for (int i = 1; i < number; i++) {
            if (i % 3 == 0 || i % 5 ==0){
                total += i;
            }
        }

        return total;
    }
}
