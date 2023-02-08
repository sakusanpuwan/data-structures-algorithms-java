package LeetCode;

public class Anagram {
    public boolean isAnagram(String s, String t){

        if (s.length() != t.length()){
            return false;
        }
        int [] array = new int[26]; // represent array of alphabet


        /*
         go through each char c in string s
         add the number of instances of c in s
         to array at position in alphabet
         char 'a' has ASCII value of 97
         'a' should represent arrray[0] or array[char - 'a']
         'b'   ""      ""     array[1]

         */

        for (int i=0; i< s.length(); i++){
            array[s.charAt(i) - 'a'] ++;
        }

        /*
        go through each char c in string t
        remove the number of instances of c in t
        to array at position in alphabet
        if array at position gives -ve value
        number of instances of char in s and t are not the same
         */

        for (int i=0; i< t.length(); i++){
            array[t.charAt(i) - 'a'] --;
            if (array[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }



        return true;
    }
}
