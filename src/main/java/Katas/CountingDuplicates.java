package Katas;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {
    public static int duplicateCount(String test){

        HashMap<Character,Integer> countMap = new HashMap<>();

        for (Character character: test.toLowerCase().toCharArray()){
            if (!countMap.containsKey(character)){
                countMap.put(character,1);
            } else {
                countMap.put(character,countMap.get(character) + 1);
            }

        }

        int duplicateCount = 0;

        for (Map.Entry<Character,Integer> entry: countMap.entrySet()){
            if (entry.getValue() > 1){
                duplicateCount ++;
            }
        }

        return duplicateCount;

    }
}
