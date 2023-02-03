package Test;
import Katas.Palindrome;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    @Test
    public void testIfTrue(){
        assertEquals(true, Palindrome.isPalindrome("tenet"));
    }

    @Test
    public void testIfFalse(){
        assertEquals(false,Palindrome.isPalindrome("hello"));
    }

    @Test
    public void testCase(){
        assertEquals(true,Palindrome.isPalindrome("Tenet"));
    }

    @Test
    public void testSymbols(){
        assertEquals(true,Palindrome.isPalindrome("!?tenet?!"));
    }

    @Test
    public void testPhrase(){assertEquals(true,Palindrome.isPalindrome("race car"));}

    @Test
    public void testPhraseFalse(){assertEquals(false,Palindrome.isPalindrome("hello world"));}
}
