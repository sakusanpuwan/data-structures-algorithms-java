package katas;

public class Max {
    public static int sequence(int[] arr){

        int currentSum = 0;
        int maxSum = 0;


        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            currentSum += currentNum;
            if (currentSum > maxSum){
                maxSum = currentSum;
            } else if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
