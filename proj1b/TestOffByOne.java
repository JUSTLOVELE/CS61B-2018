import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualCharsWithN() {

        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f')); // true
        assertFalse(offBy5.equalChars('f', 'h'));
        assertTrue(offBy5.equalChars('f', 'a'));

    }

    @Test
    public void testEqualChars() {

        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
    }

    // Your tests go here.
    //Uncomment this class once you've created your
    // CharacterComparator interface and OffByOne class.
}
