package katas;

import static java.lang.Character.isAlphabetic;

public class PigLatin {

    public static String pigIt(String str){
            String[] words = str.split(" ");

            StringBuilder pigString = new StringBuilder();

            for (String word: words){
                if (word.matches(".*[a-zA-Z].*")){
                    String pigWord = word.substring(1) + word.charAt(0) + "ay";
                    pigString.append(pigWord);
                } else {
                    pigString.append(word);
                }
                pigString.append(" ");
            }

            pigString.deleteCharAt(pigString.length()-1);
            return pigString.toString();

    }

        public static String pigIt1(String str) {
            StringBuilder result = new StringBuilder();


            for (String s : str.split(" ")) {
                char firstLetter = s.charAt(0);

                result.append(s, 1, s.length())
                        .append(firstLetter)
                        .append(isAlphabetic(firstLetter) ? "ay" : "")
                        .append(" ");
            }

            return result.substring(0, result.length()-1);
        }


    // does not work with punctuation or multiples spaces
    public static String pigIt2(String str){

        // 'Pig latin is cool'


        String[] letterArray = str.split("");
        //  0 1 2 3 4 5 6 7 8 9 10 11 12 13
        // [P,i,g, ,l,a,t,i,n, ,c,o,o,l]

        StringBuilder pigString = new StringBuilder();
        int lastSpaceIndex = -1;

        for (int i = 0; i < letterArray.length; i++) {
            if (letterArray[i].equals(" ")) {
                for (int j = lastSpaceIndex + 2; j < i; j++) {
                    pigString.append(letterArray[j]);
                }

                pigString.append(letterArray[lastSpaceIndex + 1]);
                pigString.append("a");
                pigString.append("y");
                pigString.append(" ");

                lastSpaceIndex = i;

            } else if (i == letterArray.length - 1) { // i = 13
                for (int j = lastSpaceIndex + 2; j <= i; j++) {
                    pigString.append(letterArray[j]);
                }

                pigString.append(letterArray[lastSpaceIndex + 1]);
                pigString.append("a");
                pigString.append("y");
            }

        }

        return pigString.toString();

    }


}
