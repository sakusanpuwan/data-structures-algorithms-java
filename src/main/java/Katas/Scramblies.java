package Katas;

import java.util.HashMap;

public class Scramblies {
    public static boolean scramble(String str1,String str2){

        HashMap<Character,Integer> countMap = new HashMap<>();

        for (Character c:str1.toCharArray()){
            if (countMap.containsKey(c)){
                countMap.put(c,countMap.get(c) + 1);
            } else {
                countMap.put(c,1);
            }
        }

        for (Character c:str2.toCharArray()){
            if (!countMap.containsKey(c)){
                return false;
            } else if (countMap.get(c) == 0) {
                return false;
            } else {
                countMap.put(c,countMap.get(c) - 1);
            }
        }

        return true;
    }
}
