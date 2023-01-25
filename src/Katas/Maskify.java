package Katas;

public class Maskify {
    public static String maskify(String str) {
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length - 4; i++) {
            charArray[i] = '#';
        }

        return new String(charArray);

    }
}
