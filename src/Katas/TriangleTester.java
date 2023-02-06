package Katas;

class TriangleTester{
    public static boolean isTriangle(int a, int b, int c){

        // Triangle Inequality Theorem

        if ((a + b) > c && (a + c) > b && (b + c) > a){
            return true;
        }

        return false;
    }
}