package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic205 {
    public boolean isIsomorphic(String s, String t){

        Map<Character,Character> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {


            if (!hashMap.containsKey(s.charAt(i)) && !hashMap.containsValue(t.charAt(i))){
                hashMap.put(s.charAt(i),t.charAt(i));
            }

            if (!hashMap.containsKey(s.charAt(i)) || hashMap.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }

        }

        return true;

        // Model answer
//        int[] arr_s = new int[128];
//        int[] arr_t = new int[128];
//
//        // s = "egg"
//        // t = "add"
//
//        for (int i = 0; i < s.length(); i++){
//            char char_s = s.charAt(i); // e
//            char char_t = t.charAt(i); // a
//
//            if (arr_s[char_s] == 0){ // arr_s['e] is 0
//                arr_s[char_s] = char_t;  // arr_s['e'] is 'a'
//            }
//
//            if (arr_t[char_t] == 0){
//                arr_t[char_t] = char_s;
//            }
//
//            if (arr_s[char_s] != char_t || arr_t[char_t] != char_s){
//                return false;
//            }
//
//
//        }
//
//        return true;


    }
}
