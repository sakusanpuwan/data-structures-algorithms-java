package Katas;

import java.util.HashMap;
import java.util.Map;

public class Greed {
    public static int greedy(int[] dice){

        int score = 0;
        Map<Integer,Integer> diceCount = new HashMap<>();

        for (int i = 1; i < 7; i++) {
            diceCount.put(i,0);
        }

        for (int i = 0; i < dice.length; i++) {
            diceCount.put(dice[i],diceCount.get(dice[i]) + 1 );
        }

        for (int i = 1; i < 7; i++) {
            if (i == 1 && diceCount.get(1) >= 3){
                score += 1000;
                diceCount.put(1,diceCount.get(1) - 3);
            } else if (diceCount.get(i) >= 3) {
                score += i * 100;
                diceCount.put(i, diceCount.get(i) - 3);
            }
        }

        if (diceCount.get(1) > 0 && diceCount.get(1) < 3){
            score += 100 * diceCount.get(1);
        }

        if (diceCount.get(5) > 0 && diceCount.get(5)< 3){
            score += 50 * diceCount.get(5);
        }


        return score;
    }
}
