package katas;

public class StringIncrementer {
    public static String incrementString(String str){

        StringBuilder newStr = new StringBuilder();

        // Need to consider
        // 9
        // 09
        // 19
        // 009
        // 99
        // 999

        char lastCharacter = str.charAt(str.length() - 1);

        if (!Character.isDigit(lastCharacter)){
            newStr.append(str).append(1);
        } else if (lastCharacter != '9') {
            newStr.append(str,0,str.length() - 1);
            newStr.append(Character.getNumericValue(lastCharacter) + 1);
        }

        return newStr.toString();
    }
}
