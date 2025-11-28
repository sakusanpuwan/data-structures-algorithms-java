package striversA2Z;

public class Pattern {

    /*
    Rectangular Pattern

    *****
    *****
    *****
    *****
    *****
     */
    public static void rectangularStarPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void rectangularStarPatternUsingRepeat(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("*".repeat(n));
        }
    }

    /*
    Right-Angled Triangle Pattern
    *
    **
    ***
    ****
    *****
     */
    public static void rightAngledTrianglePattern(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("*".repeat(i + 1));
        }
    }

    /*
     Right-Angled Number Pyramid
     1
     12
     123
     1234
     12345
     */
    public static void rightAngledNumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /*
    Right-Angled Number Pyramid - II

    1
    22
    333
    4444
    55555
     */
    public static void rightAngledNumberPyramidII(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void rightAngledNumberPyramidII2(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(String.valueOf(i).repeat(i));
        }
    }

    /*
    Inverted Right Pyramid

    *****
    ****
    ***
    **
    *
     */
    public static void invertedRightPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n - i + 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    Star Pyramid
        *
       ***
      *****
     *******
    *********
     */
    public static void starPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i ; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j < 2 * i ; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= n - i ; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
