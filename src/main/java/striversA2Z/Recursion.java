package striversA2Z;

public class Recursion {

    /*
    Given an integer N, write a program to print your name N times.
     */
    public static void printName(String name, int n, int count) {
        if (count == n) {
            return;
        }

        System.out.println(name);
        printName(name, n, count + 1);
    }

    /*
    Given an integer N, write a program to print numbers from 1 to N.
     */
    public static void printNumbers(int n, int count) {
        if (count > n){
            return;
        }

        System.out.println(count);

        printNumbers(n, count + 1);
    }
}
