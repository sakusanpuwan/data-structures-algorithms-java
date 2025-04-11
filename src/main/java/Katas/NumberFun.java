package Katas;

public class NumberFun {
    public static long findNextSquare(long sq) {

        long root = (long) Math.sqrt(sq);

        return root == Math.sqrt(sq) ? (long) Math.pow(root + 1, 2) : -1;
    }
}
