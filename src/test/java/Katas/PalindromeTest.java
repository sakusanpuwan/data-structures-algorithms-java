package Katas;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void testIfTrue(){
        assertEquals(true, Palindrome.isPalindrome("tenet"));
    }

    @Test
    public void testIfFalse(){
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    @Test
    public void testCase(){
        assertTrue(Palindrome.isPalindrome("Tenet"));
    }

    @Test
    public void testSymbols(){
        assertEquals(true,Palindrome.isPalindrome("!?tenet?!"));
    }

    @Test
    public void testPhrase(){
        assertEquals(true,Palindrome.isPalindrome("race car"));
    }

    @Test
    public void testPhraseFalse(){
        assertEquals(false,Palindrome.isPalindrome("hello world"));
    }
}
