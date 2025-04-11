package Katas;

import java.util.ArrayList;
import java.util.List;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b){
        List<Integer> c = new ArrayList<>();

        for (int i = 0; i < a.length; i++){
            boolean isPresentInB = false;
            for (int j = 0; j < b.length; j++) {
                if ( a[i] == b[j]){
                    isPresentInB = true;
                    break;
                }
            }

            if (!isPresentInB){
                c.add(a[i]);
            }
        }

        return c.stream().mapToInt(Integer::intValue).toArray();
    }
}
