package katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeightSort {
    public static String orderWeight(String strng) {
        String[] stringWeightArray = strng.split(" ");

        Map<String,Integer> map = new HashMap<>();

        for (String stringNumber:stringWeightArray){
            map.put(stringNumber,getSumOfDigits(stringNumber));
        }

        Arrays.sort(stringWeightArray, (a,b) -> {
            int weightComparator = Integer.compare(map.get(a), map.get(b));
            if (weightComparator == 0) {
                return a.compareTo(b);
            } else {
                return weightComparator;
            }
        });

        return String.join(" ",stringWeightArray);

    }

    public static int getSumOfDigits(String number){
        int sum = 0;
        for (char digit:number.toCharArray()){
            sum += Character.getNumericValue(digit);
        }

        return sum;
    }
}

