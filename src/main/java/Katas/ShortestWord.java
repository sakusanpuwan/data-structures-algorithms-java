package Katas;

public class ShortestWord {
    public static int findShort(String s){

        String[] stringArray = s.split(" ");
        int result = Integer.MAX_VALUE;
        for (String word: stringArray) {
            if(word.length() < result ){
                result = word.length();
            }
        }

        return result;
    }
}
