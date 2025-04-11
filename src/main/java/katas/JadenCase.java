package katas;

public class JadenCase {
    public String toJadenCase(String phrase){

        if (phrase == null || phrase == "") return null;

//        String[] splitWords = phrase.split(" ");
//        ArrayList<String> joinedWords = new ArrayList<>();
//
//        for (String word: splitWords){
//            String capitalisedWord = word.substring(0,1).toUpperCase() + word.substring(1);
//            joinedWords.add(capitalisedWord);
//        }
//        String result = String.join(" ",joinedWords);
//        return result;

        char[] charArray = phrase.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (i == 0 || charArray[i-1] == ' '){
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }

        return new String(charArray);
    }
}
