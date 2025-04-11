package katas;

import java.util.HashMap;

public class DnaStrand {
    public static String makeComplement(String dna) {

        /*
        In DNA strings, symbols "A" and "T" are complements of each other,
        as "C" and "G". Your function receives one side of the DNA (string,
        except for Haskell); you need to return the other complementary side.
         */

        HashMap<Character,Character> dnaComplement = new HashMap<>();

        dnaComplement.put('T','A');
        dnaComplement.put('A','T');
        dnaComplement.put('C','G');
        dnaComplement.put('G','C');


        char[] dnaCharArray = dna.toCharArray();

        for (int i = 0; i < dnaCharArray.length; i++) {
            dnaCharArray[i] = dnaComplement.get(dnaCharArray[i]);
        }

        return new String(dnaCharArray);

    }
}
