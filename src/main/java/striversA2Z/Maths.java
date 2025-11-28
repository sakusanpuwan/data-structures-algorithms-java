package striversA2Z;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maths {

    /*
    Given an integer N, return the number of digits in N.
     */
    public static int countDigits(int n) {
        int count = 0;

        while (n > 0) {
            count++;
            n = n /10;
        }
        return count;
    }

    /*
    You are given an integer n.
    Return the integer formed by placing the digits of n in reverse order.
     */
    public static int reverseNumber(int n) {
        int result = 0;

        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            result *= 10 ;
            result += digit;
        }

        return result;
    }

    /*
    Check if a number is Palindrome or Not
    Given an integer N, return true if it is a palindrome else return false.
     */
    public static boolean isPalindrome(int n) {
        int reverse = 0;
        int currentNumber = n;

        while (currentNumber > 0) {
            int lastDigit = currentNumber % 10;
            reverse *= 10;
            reverse += lastDigit;
            currentNumber = currentNumber / 10;
        }

        return reverse == n;
    }

    /*
    Given two integers N1 and N2, find their greatest common divisor.
     */
    public static int findGCD(int n1, int n2) {
        int min = Math.min(n1, n2);
        int gcd = Integer.MIN_VALUE;

        for (int i = 1; i <= min; i++) {
            if (n1 % i == 0 && n2 % i == 0 && i > gcd) {
                    gcd = i;
                }

        }

        return gcd;
    }

    /*
    Given an integer N, return true if it is an Armstrong number otherwise return false.
    An Armstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
     */
    public static boolean isArmstrong(int n) {
        int sum = 0;
        int power = 0;
        int current = n;

        while (current > 0) {
            current = current / 10;
            power++;
        }

        current = n;

        while (current > 0) {
            int lastDigit = current % 10;
            sum += Math.pow(lastDigit,power);
            current = current / 10;
        }

        return sum == n;
    }

    /*
    Given an integer N, return all divisors of N.
    A divisor of an integer N is a positive integer that divides N without leaving a remainder.
    In other words, if N is divisible by another integer without any remainder,
    then that integer is considered a divisor of N.
     */
    public static List<Integer> findDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }

        return divisors;
    }

    /*
    Check if a number is prime
    a whole number greater than 1 that cannot be exactly divided by any whole number other than itself and 1
     */
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
