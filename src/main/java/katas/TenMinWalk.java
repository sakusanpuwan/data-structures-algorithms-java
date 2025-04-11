package katas;

import java.util.HashMap;

public class TenMinWalk {
    public static boolean isValid(char[] walk){

        if (walk.length != 10){
            return false;
        }

        int x = 0;
        int y = 0;

        HashMap<Character,Integer> valueMap = new HashMap<>();
        valueMap.put('n',1);
        valueMap.put('s',-1);
        valueMap.put('w',1);
        valueMap.put('e',-1);

        for (char direction:walk){
            int value = valueMap.get(direction);
            if (direction == 's' || direction == 'n'){
                y += value;
            } else {
                x += value;
            }

        }

        return x == 0 && y == 0;

    }

    public static boolean isValid1(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        int x = 0, y = 0;
        for (int i = 0; i < 10; i++) {
            switch (walk[i]) {
                case 'n':
                    y++;
                    break;
                case 'e':
                    x++;
                    break;
                case 's':
                    y--;
                    break;
                case 'w':
                    x--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
