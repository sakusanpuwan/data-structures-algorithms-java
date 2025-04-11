package leetCode;

import java.util.HashSet;

public class HappyNumber202 {
    public boolean isHappy(int n){
        HashSet<Integer> hashSet = new HashSet<>();

        int sum = 0;

        while(sum != 1 && !hashSet.contains(sum)){
            hashSet.add(sum);
            sum = 0;

            while (n != 0){
                // 19%10 => 1 reminder 9  = 9
                // 19/10 => 1.9 = 1
                sum += Math.pow(n%10,2); // 9^2 1^2
                n = n/10; // 1 0 -> break
                // sum = 81 + 1 = 82
            }

            n = sum;
        }

        return sum == 1;
    }
}
