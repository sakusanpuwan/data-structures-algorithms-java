package Katas;

import java.util.HashMap;

public class DuplicateEncoder {
    public static String encode(String word){

        HashMap<Character,Integer> countMap = new HashMap<>();

        for (Character character: word.toLowerCase().toCharArray()){
            if (!countMap.containsKey(character)){
                countMap.put(character,1);
            } else {
                countMap.put(character,countMap.get(character) + 1);
            }
        }
        // Use StringBuilder to concatenate strings than +=
//        String newString = "";

        StringBuilder newString = new StringBuilder();

        // The order of the characters will not be preserved by looping
        // through the map entries
//        for (Map.Entry<Character,Integer> entry: countMap.entrySet()){
//            if (entry.getValue() > 1){
//                newString += ")";
//            } else {
//                newString += "(";
//            }
//        }

        for (Character character: word.toLowerCase().toCharArray()){
            if (countMap.get(character) > 1){
                newString.append(")");
            } else {
                newString.append("(");
            }
        }

        return newString.toString();
    }
}
