package Katas;

public class SpinWords {

    public String spinWords(String sentence){

        // "Hey fellow warriors" --> "Hey wollef sroirraw"

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length;i++){
            if (words[i].length() > 4){
                String reversedWord = "";
                for (int j = words[i].length()-1; j >= 0; j--){
                    reversedWord = reversedWord + words[i].charAt(j);
                }
                words[i] = reversedWord;
            }
        }

        String spinnedSentence = String.join(" ",words);

        return spinnedSentence;

    }
}
