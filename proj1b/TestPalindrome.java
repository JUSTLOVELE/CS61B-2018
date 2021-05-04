import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testIsPalindrome() {

        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("abc"));
        assertFalse(palindrome.isPalindrome("abcdefg"));
        assertTrue(palindrome.isPalindrome("abcba"));
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("detrude", offByOne));
        CharacterComparator offBy5 = new OffByN(5);
        assertTrue(palindrome.isPalindrome("binding", offBy5));
    }

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.
}
