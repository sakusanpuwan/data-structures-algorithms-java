package katas;

public class FindOdd {
    public static int findIt(int[] A){
        /*
        [1,2,2,3,3,3,4,3,3,3,2,2,1]
         */

        for(int i:A){

            int count = 0;

            for (int j:A){
                if (i==j){
                    count ++;
                }
            }

            if (count % 2 == 1){
                return i;
            }
        }

        return 0;
    }
}
