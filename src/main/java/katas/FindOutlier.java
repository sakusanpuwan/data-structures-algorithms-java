package katas;

public class FindOutlier {
    public static int find(int[] integers){

        int evenCount = 0;

        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0){
                evenCount ++;
            }
        }

        // even array will have at least 2 evens in 1st three ints
        if (evenCount >= 2){
            for (int integer:integers){
                if (integer % 2 != 0){
                    return integer;
                }
            }
        } else {
            for (int integer:integers){
                if (integer % 2 == 0){
                    return integer;
                }
            }
        }
        return 0;
    }
}
