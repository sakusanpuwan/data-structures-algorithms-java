package Katas;

public class ProdFib {

    public static long[] productFib(long prod){

        long Fn = 0;
        long Fn1 = 1;

        int result = 0;

        while (Fn * Fn1 <= prod){
            if (Fn * Fn1 == prod){
                result = 1;
                break;
            } else {
                long tempFn1 = Fn1;
                Fn1 = Fn1 + Fn;
                Fn = tempFn1;
            }
        }

        return new long[] {Fn,Fn1,result};
    }

    // Method below works but is inefficient
    public static long[] productFib1(long prod){

        // While N * N +1 < prod
        // For each N if N * N+1 == prod return
        // Else return smallest N such that N * N + 1 > prod

        // 0,       1,      1,      2,      3,  5,  8, 13, 21, 34, 55, 89, 144, 233
        // Fn-2   Fn-1     Fn      Fn+1

        int Fn = 1;
        int Fn1 = 2;
        int FnMinus1 = 1;
        int FnMinus2 = 0;

        int result = 0;

        while (Fn * Fn1 <= prod){
            if (Fn * Fn1 == prod){
                result = 1;
                break;
            } else {
                FnMinus2 = FnMinus1;
                FnMinus1 = Fn;
                Fn1 = Fn1 + Fn;
                Fn = FnMinus1 + FnMinus2;
            }
        }

        return new long[] {Fn,Fn1,result};
    }
}
